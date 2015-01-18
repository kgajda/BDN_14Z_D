package pl.agh.projekt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.agh.projekt.db.dao.ProductsDAO;
import pl.agh.projekt.db.orm.Products;

import java.util.List;

/**
 * Created by szczepan on 09.11.14.
 */
@Service
public class ProductssManager {
    @Autowired
    private ProductsDAO productsDAO;

    public List<Products> findAllOrfers() {
        return productsDAO.getAllProducts();
    }

    public int insertToDB(Products order) {
        return productsDAO.insert(order);
    }

    public Products findByID(int id) {
        return productsDAO.findByID(id);
    }

    public String delete(int id) {
        return String.valueOf(productsDAO.delete(id));
    }

    public void update(Products products) {
        productsDAO.update(products);
    }

    public String save(Products products) {
        return String.valueOf(productsDAO.insert(products));
    }
}
