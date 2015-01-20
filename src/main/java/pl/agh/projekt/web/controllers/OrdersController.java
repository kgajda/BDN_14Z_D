/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.agh.projekt.web.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import pl.agh.projekt.db.orm.CompanyOrders;
import pl.agh.projekt.db.orm.Orders;
import pl.agh.projekt.service.OrdersManager;
import pl.agh.projekt.untils.loggers.NewRequestLogger;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author michal
 */
@RequestMapping(value = "/orders")
@RestController
public class OrdersController {
    @Autowired
    private OrdersManager ordersManager;
    @Autowired
    private ObjectMapper objectMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriesController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String getAllOrders() {
        List<Orders> orders = ordersManager.findAllOrfers();
        String response = null;
        try {
            response = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(orders);
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage(), e.getCause());
            throw new HttpServerErrorException(HttpStatus.EXPECTATION_FAILED);
        }
        return response;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String insertOrders(@RequestBody String string, HttpServletRequest httpServletRequest) {
        NewRequestLogger newRequestLogger = new NewRequestLogger(httpServletRequest, string);
        String id;
        try {
            Orders order = objectMapper.readValue(string, Orders.class);
            int i = ordersManager.insertToDB(order);
            id = String.valueOf(i);
            newRequestLogger.setResponse(id);
        } catch (IOException ex) {
            newRequestLogger.setError(ex.getMessage());
            LOGGER.error(ex.getMessage(), ex);
            return ex.getMessage();
        }
        newRequestLogger.end();
        return id;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public String getOrder(@PathVariable("id") String id, HttpServletRequest httpServletRequest) {
        Orders order = ordersManager.findByID(Integer.valueOf(id));
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
            Orders orders = objectMapper.readValue(json, Orders.class);
            orders.setOrderId(Integer.valueOf(id));
            return ordersManager.update(orders);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e.getCause());
            throw new HttpServerErrorException(HttpStatus.EXPECTATION_FAILED);
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public String deleteOrder(@PathVariable("id") String id, HttpServletRequest httpServletRequest) {
        return ordersManager.delete(Integer.valueOf(id));

    }

    @RequestMapping(value = "/raport", method = RequestMethod.GET, produces = "application/json")
    public String raport() {
        List<CompanyOrders> order = ordersManager.selectCO();
        String response = null;
        try {
            response = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(order);
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage(), e.getCause());
            throw new HttpServerErrorException(HttpStatus.EXPECTATION_FAILED);
        }
        return response;

    }

}
