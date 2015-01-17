/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.agh.projekt.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import pl.agh.projekt.db.dao.CustomerDAO;
import pl.agh.projekt.db.orm.Customer;

/**
 * @author karol
 */
@RestController
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class HomeController {

    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getWork() throws InterruptedException {
        String result = Thread.currentThread().getName() + " " + this.toString();
        Thread.sleep(5000);
        return result;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update() {
        Customer customer = customerDAO.findById("VINET");
        customer.setCompanyName("agh");
        customerDAO.update(customer);
        return "update";
    }
}
