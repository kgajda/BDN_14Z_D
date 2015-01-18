package pl.agh.projekt.db.dao;

import pl.agh.projekt.db.orm.Categories;

import java.util.List;

/**
 * Created by szczepan on 31.10.14.
 */
public interface CategoriesDAO {
    List<Categories> findAll();

    Categories findById(int id);

    Integer save(Categories categories);

    int delete(int id);

    void update(Categories categories);
}
