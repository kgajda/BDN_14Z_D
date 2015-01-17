package pl.agh.projekt.db.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.agh.projekt.configuration.AppConfigurationSpring;
import pl.agh.projekt.db.orm.Orders;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfigurationSpring.class})
public class OrdersDAOImplTest {

    @Autowired
    private OrdersDAO ordersDAO;
    private Integer current;

    @Before
    public void beforeTest() throws Exception {
        testInsert();
    }

    @After
    public void afterTest() throws Exception {
        testDelete();
    }

    @Test
    public void testFindByID() throws Exception {
        Orders orders = ordersDAO.findByID(current);
        assertEquals("tytanik", orders.getShipName());
    }

    @Test
    public void testGetAllOrders() throws Exception {
        List<Orders> ordersList = ordersDAO.getAllOrders();
        assertFalse(ordersList.isEmpty());
    }


    public void testInsert() throws Exception {
        Orders orders = new Orders();
        orders.setShipName("tytanik");
        ordersDAO.insert(orders);
        assertNotNull(orders.getOrderId());
        current = orders.getOrderId();
    }

    @Test
    public void testUpdate() throws Exception {
        Orders orders = ordersDAO.findByID(current);
        orders.setShipCountry("krakow");
        ordersDAO.update(orders);

    }


    public void testDelete() throws Exception {
        ordersDAO.delete(current);
    }
}