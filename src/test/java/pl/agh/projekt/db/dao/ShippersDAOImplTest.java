package pl.agh.projekt.db.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.agh.projekt.configuration.AppConfigurationSpring;
import pl.agh.projekt.db.orm.Shippers;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfigurationSpring.class})
public class ShippersDAOImplTest {
    @Autowired
    private ShippersDAO shippersDAO;
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
        Shippers shippers = new Shippers();
        shippers.setCompanyName("bla");
        shippersDAO.insert(shippers);
        assertNotNull(shippers.getShipperId());
        current = shippers.getShipperId();
    }

    @Test
    public void testFindByID() throws Exception {
        Shippers shippers = shippersDAO.findByID(current);
        assertEquals("bla", shippers.getCompanyName());
    }

    @Test
    public void testGetAllShippers() throws Exception {
        List<Shippers> shippersList = shippersDAO.getAllShippers();
        assertFalse(shippersList.isEmpty());
    }

    @Test
    public void testUpdate() throws Exception {
        Shippers shippers = shippersDAO.findByID(current);
        shippers.setPhone("132456748");
        shippersDAO.update(shippers);
    }


    public void testDelete() throws Exception {
        shippersDAO.delete(current);
    }
}