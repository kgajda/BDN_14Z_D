package pl.agh.projekt.db.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.agh.projekt.db.orm.Shippers;

import java.util.List;

/**
 * Created by michal on 09.11.14.
 */
@Repository
public class ShippersDAOImpl implements ShippersDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public int insert(Shippers shippers) {
        sessionFactory.getCurrentSession().save(shippers);
        return shippers.getShipperId();
    }

    @Override
    @Transactional(readOnly = true)
    public Shippers findByID(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Shippers WHERE ShipperID = :id");
        query.setParameter("id", id);
        return (Shippers) query.uniqueResult();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Shippers> getAllShippers() {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Shippers");
        return (List<Shippers>) query.list();
    }

    @Override
    @Transactional
    public void update(Shippers shippers) {
        sessionFactory.getCurrentSession().update(shippers);

    }

    @Override
    @Transactional
    public int delete(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("DELETE Shippers WHERE ShipperID = :id");
        query.setParameter("id", id);
        return query.executeUpdate();
    }
}
