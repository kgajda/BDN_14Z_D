package pl.agh.projekt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.agh.projekt.db.dao.EmployeeDAO;
import pl.agh.projekt.db.orm.Employees;

import java.util.List;

/**
 * Created by michal on 08.11.14.
 */
@Service
public class EmployeeManager {

    @Autowired
    private EmployeeDAO employeeDAO;

    public List<Employees> employeeList() {
        return employeeDAO.getAllEmployeers();
    }

    public Employees getEmployee(int id) {
        return employeeDAO.findByID(id);
    }

    public String delete(int id) {
        return String.valueOf(employeeDAO.delete(id));
    }

    public void update(Employees employee) {
        employeeDAO.update(employee);
    }

    public String save(Employees employee) {
        return String.valueOf(employeeDAO.insert(employee));
    }
}
