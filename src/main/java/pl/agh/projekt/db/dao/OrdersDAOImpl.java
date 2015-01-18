/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.agh.projekt.db.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.agh.projekt.db.orm.CompanyOrders;
import pl.agh.projekt.db.orm.Orders;

import java.util.List;

/**
 *
 * @author szczepan
 */
@Repository
public class OrdersDAOImpl implements OrdersDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public Orders findByID(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Orders WHERE OrderID = :id");
        query.setParameter("id", id);
        return (Orders) query.uniqueResult();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Orders> getAllOrders() {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Orders");
        return (List<Orders>) query.list();
    }

    @Override
    @Transactional
    public int insert(Orders orders) {
        sessionFactory.getCurrentSession().save(orders);
        return orders.getOrderId();
    }

    @Override
    @Transactional
    public int update(Orders orders) {
        sessionFactory.getCurrentSession().update(orders);
        return 1;
    }

    @Override
    @Transactional
    public int delete(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("DELETE Orders WHERE OrderID = :id");
        query.setParameter("id", id);
        return query.executeUpdate();
    }

    @Override
    @Transactional
    public List<CompanyOrders> selectCO() {
        String s = "SELECT  new pl.agh.projekt.db.orm.CompanyOrders(c.companyName,  COUNT(o.orderId))" +
                " FROM Orders o JOIN o.customer c" +
                " GROUP BY c.customerID";
        return (List<CompanyOrders>) sessionFactory.getCurrentSession().createQuery(s).list();
    }


}
