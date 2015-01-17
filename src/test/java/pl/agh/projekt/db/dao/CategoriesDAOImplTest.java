package pl.agh.projekt.db.dao;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.agh.projekt.configuration.AppConfigurationSpring;
import pl.agh.projekt.db.orm.Categories;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfigurationSpring.class})
@DatabaseSetup(value = "sources.xml", type = DatabaseOperation.CLEAN_INSERT)
public class CategoriesDAOImplTest {

    @Autowired
    private CategoriesDAO categoriesDAO;
    private Integer current;

    @Before
    public void beforeTest() throws Exception {
        testSave();
    }

    @After
    public void afterTest() throws Exception {
        testDelete();
    }

    //    @Test
    public void testFindAll() throws Exception {
        List<Categories> categoriesList = categoriesDAO.findAll();
        assertTrue(!categoriesList.isEmpty());
    }

    @Test
    public void testFindById() throws Exception {
        Categories categories = categoriesDAO.findById(current);
        Categories categories2 = categoriesDAO.findById(current);
        assertEquals("test2", categories.getCategoryName());
        assertEquals("test2", categories2.getCategoryName());
    }


    public void testSave() throws Exception {
        Categories categories = new Categories();
        categories.setCategoryName("test2");
        categories.setDescription("bla");
        categories.setPicture("jpg");
        categoriesDAO.save(categories);
        assertNotNull(categories.getCategoryId());
        current = categories.getCategoryId();
    }


    public void testDelete() throws Exception {
        categoriesDAO.delete(current);

    }
}