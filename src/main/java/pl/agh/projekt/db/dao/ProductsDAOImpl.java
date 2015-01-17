package pl.agh.projekt.db.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.agh.projekt.db.orm.Products;

import java.util.List;

/**
 * Created by karol on 09.11.14.
 */
@Repository
public class ProductsDAOImpl implements ProductsDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public int insert(Products products) {
        sessionFactory.getCurrentSession().save(products);
        return products.getProductId();
    }

    @Override
    @Transactional(readOnly = true)
    public Products findByID(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Products WHERE ProductID = :id");
        query.setParameter("id", id);
        return (Products) query.uniqueResult();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Products> getAllProducts() {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Products");
        return (List<Products>) query.list();
    }

    @Override
    @Transactional
    public void update(Products products) {
        sessionFactory.getCurrentSession().update(products);
    }

    @Override
    @Transactional
    public int delete(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("DELETE Products WHERE ProductID = :id");
        query.setParameter("id", id);
        return query.executeUpdate();
    }
}
