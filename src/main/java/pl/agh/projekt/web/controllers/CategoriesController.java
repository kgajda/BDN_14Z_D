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
import pl.agh.projekt.service.CattegoriesManager;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by szczepan on 01.11.14.
 */
@RestController
@RequestMapping(value = "/categories")
public class CategoriesController {
    @Autowired
    private CattegoriesManager cattegoriesManager;
    @Autowired
    private ObjectMapper objectMapper;


    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriesController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String getCategories(HttpServletRequest httpServletRequest) {
        List<Categories> categories = cattegoriesManager.getAllCategories();
        String response;
        try {
            response = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(categories);
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage(), e.getCause());
            throw new HttpServerErrorException(HttpStatus.EXPECTATION_FAILED);
        }
        return response;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public String getCategorie(@PathVariable String id) {
        Categories categorie = cattegoriesManager.getCategorie(Integer.valueOf(id));
        String response;
        try {
            response = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(categorie);
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage(), e.getCause());
            throw new HttpServerErrorException(HttpStatus.EXPECTATION_FAILED);
        }
        return response;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
    public void updateCategorie(@PathVariable String id, @RequestBody String json) {
        Categories categories = null;
        try {
            categories = objectMapper.readValue(json, Categories.class);
            categories.setCategoryId(Integer.valueOf(id));
            cattegoriesManager.update(categories);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e.getCause());
            throw new HttpServerErrorException(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String insertCategorie(@RequestBody String json) {
        Categories categories = null;
        try {
            categories = objectMapper.readValue(json, Categories.class);
            return cattegoriesManager.insert(categories);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e.getCause());
            throw new HttpServerErrorException(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public String deleteCategorie(@PathVariable String id, HttpServletRequest httpServletRequest) {
        return cattegoriesManager.delete(Integer.valueOf(id));
    }
}
