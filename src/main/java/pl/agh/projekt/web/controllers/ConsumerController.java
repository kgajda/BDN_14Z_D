package pl.agh.projekt.web.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import pl.agh.projekt.db.orm.Categories;
import pl.agh.projekt.db.orm.Customer;
import pl.agh.projekt.service.CattegoriesManager;
import pl.agh.projekt.service.CostumerService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by karol on 23.01.15.
 */
@RestController
@RequestMapping(value = "/consumer")
public class ConsumerController {
    @Autowired
    private CostumerService cos;
    @Autowired
    private ObjectMapper objectMapper;


    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String getCategories(HttpServletRequest httpServletRequest) throws JsonProcessingException {
        List<Customer> categories = cos.getAll();
        String response;

        response = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(categories);

        return response;
    }

    @RequestMapping(value = "/f", method = RequestMethod.GET, produces = "application/json")
    public String getCategories2(HttpServletRequest httpServletRequest) throws JsonProcessingException {
        cos.newOrder("ALFKI", "false");

        return "ok";
    }

    @RequestMapping(value = "/t", method = RequestMethod.GET, produces = "application/json")
    public String getCategories3(HttpServletRequest httpServletRequest) throws JsonProcessingException {
        cos.newOrder("ALFKI", "true");

        return "ok";
    }

}
