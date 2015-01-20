package pl.agh.projekt.db.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.agh.projekt.db.orm.Customer;

/**
 * Created by michal on 13.12.14.
 */
@Repository
public class CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public Customer findById(String id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Customer where customerID = :id");
        query.setParameter("id", id);
        return (Customer) query.uniqueResult();
    }

    @Transactional
    public void update(Customer categories) {
        sessionFactory.getCurrentSession().update(categories);
    }

}
