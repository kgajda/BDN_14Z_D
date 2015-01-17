package pl.agh.projekt.db.dao;

import pl.agh.projekt.db.orm.Products;

import java.util.List;

/**
 * Created by karol on 31.10.14.
 */
public interface ProductsDAO {
    int insert(Products products);

    Products findByID(int id);

    List<Products> getAllProducts();

    void update(Products products);

    int delete(int id);
}
