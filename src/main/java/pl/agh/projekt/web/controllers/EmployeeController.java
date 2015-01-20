package pl.agh.projekt.web.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.agh.projekt.db.orm.Employees;
import pl.agh.projekt.service.EmployeeManager;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by michal on 08.11.14.
 */
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeManager employeeManager;
    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String getAllEmployees() {
        List<Employees> employeesList = employeeManager.employeeList();
        String jeson;
        try {
            jeson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeesList);
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
        return jeson;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public String getEmployee(@PathVariable String id, HttpServletRequest httpServletRequest) {

        Employees employees = employeeManager.getEmployee(Integer.valueOf(id));
        String jeson;
        try {
            jeson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employees);
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
        return jeson;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
    public String updateEmployee(@PathVariable String id, @RequestBody String json) {
        try {
            Employees employee = objectMapper.readValue(json, Employees.class);
            employee.setEmployeeID(Integer.valueOf(id));
            employeeManager.update(employee);
            return "ok";
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String updateEmployee(@RequestBody String json) {
        try {
            Employees employee = objectMapper.readValue(json, Employees.class);
            return employeeManager.save(employee);
        } catch (IOException e) {
            return e.getMessage();
        }
    }



    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public String deleteEmployee(@PathVariable String id, HttpServletRequest httpServletRequest) {
        return employeeManager.delete(Integer.valueOf(id));
    }


}
