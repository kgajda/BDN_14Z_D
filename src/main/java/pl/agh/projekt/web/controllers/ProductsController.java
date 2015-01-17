package pl.agh.projekt.web.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import pl.agh.projekt.db.orm.Products;
import pl.agh.projekt.service.ProductssManager;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by karol on 09.11.14.
 */
@RestController
@RequestMapping(value = "/products")
public class ProductsController {

    @Autowired
    private ProductssManager productsManager;
    @Autowired
    private ObjectMapper objectMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriesController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String getAllOrders(HttpServletRequest httpServletRequest) {
        List<Products> orders = productsManager.findAllOrfers();
        String response = null;
        try {
            response = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(orders);
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage(), e.getCause());
            throw new HttpServerErrorException(HttpStatus.EXPECTATION_FAILED);
        }
        return response;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public String getOrder(@PathVariable("id") String id, HttpServletRequest httpServletRequest) {
        Products order = productsManager.findByID(Integer.valueOf(id));
        String response = null;
        try {
            response = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(order);
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage(), e.getCause());
            throw new HttpServerErrorException(HttpStatus.EXPECTATION_FAILED);
        }
        return response;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
    public String updateOrder(@PathVariable("id") String id, @RequestBody String json) {
        try {
            Products products = objectMapper.readValue(json, Products.class);
            products.setProductId(Integer.valueOf(id));
            productsManager.update(products);
            return "ok";
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String insert(@RequestBody String json) {
        try {
            Products products = objectMapper.readValue(json, Products.class);
            return productsManager.save(products);
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public String deleteOrder(@PathVariable("id") String id, HttpServletRequest httpServletRequest) {
        return productsManager.delete(Integer.valueOf(id));
    }
}
