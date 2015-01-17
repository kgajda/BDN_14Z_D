package pl.agh.projekt.db.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.agh.projekt.configuration.AppConfigurationSpring;
import pl.agh.projekt.db.orm.Employees;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfigurationSpring.class})
public class EmployeesDAOImplTest {
    @Autowired
    private EmployeeDAO employeeDAO;
    private Integer current;

    @Before
    public void beforeTest() throws Exception {
        testInsert();
    }

    @After
    public void afterTest() throws Exception {
        testDelete();
    }


    public void testInsert() throws Exception {
        Employees employees = new Employees();
        employees.setAddress("test");
        employees.setBirthDate(new Date());
        employees.setFirstName("Test");
        employees.setLastName("alibaba");

        employeeDAO.insert(employees);
        assertNotNull(employees.getEmployeeID());
        current = employees.getEmployeeID();

    }

    @Test
    public void testFindByID() throws Exception {
        Employees employees = employeeDAO.findByID(current);
        Employees employees2 = employeeDAO.findByID(current);
        assertEquals("alibaba", employees.getLastName());
        assertEquals("alibaba", employees2.getLastName());
    }

    //    @Test
    public void testGetAllEmployeers() throws Exception {
        List<Employees> employeesList = employeeDAO.getAllEmployeers();
        assertFalse(employeesList.isEmpty());
    }

    //    @Test
    public void testUpdate() throws Exception {
        Employees employees = employeeDAO.findByID(current);
        employees.setAddress("test2");
        employeeDAO.update(employees);
    }


    public void testDelete() throws Exception {
        employeeDAO.delete(current);
    }
}