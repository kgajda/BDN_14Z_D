package pl.agh.projekt.db.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.agh.projekt.db.orm.Employees;

import java.util.List;

/**
 * Created by michal on 08.11.14.
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public int insert(Employees employees) {
        sessionFactory.getCurrentSession().save(employees);
        return employees.getEmployeeID();
    }

    @Override
    @Transactional(readOnly = true)
    public Employees findByID(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Employees WHERE EmployeeID = :id");
        query.setParameter("id", id);
        return (Employees) query.uniqueResult();

    }

    @Override
    @Transactional(readOnly = true)
    public List<Employees> getAllEmployeers() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employees.class);
        criteria.setFirstResult(5);
        criteria.setMaxResults(10);
        return (List<Employees>) criteria.list();
    }

    @Override
    @Transactional
    public void update(Employees employees) {
        sessionFactory.getCurrentSession().update(employees);

    }

    @Override
    @Transactional
    public int delete(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("DELETE Employees WHERE EmployeeID = :id");
        query.setParameter("id", id);
        return query.executeUpdate();
    }
}
