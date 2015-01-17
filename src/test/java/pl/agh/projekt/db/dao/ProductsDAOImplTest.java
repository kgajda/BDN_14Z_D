package pl.agh.projekt.db.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.agh.projekt.configuration.AppConfigurationSpring;
import pl.agh.projekt.db.orm.Products;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfigurationSpring.class})
public class ProductsDAOImplTest {
    @Autowired
    private ProductsDAO productsDAO;
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
        Products products = new Products();
        products.setProductName("kawa");
        productsDAO.insert(products);
        assertNotNull(products.getProductId());
        current = products.getProductId();

    }

    @Test
    public void testFindByID() throws Exception {
        Products products = productsDAO.findByID(current);
        assertEquals("kawa", products.getProductName());
    }

    @Test
    public void testGetAllProducts() throws Exception {
        List<Products> productsList = productsDAO.getAllProducts();
        assertFalse(productsList.isEmpty());
    }

    @Test
    public void testUpdate() throws Exception {
        Products products = productsDAO.findByID(current);
        products.setDiscontinued(true);
        productsDAO.update(products);
    }


    public void testDelete() throws Exception {
        productsDAO.delete(current);
    }
}