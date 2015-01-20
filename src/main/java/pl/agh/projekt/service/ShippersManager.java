package pl.agh.projekt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.agh.projekt.db.dao.ShippersDAO;
import pl.agh.projekt.db.orm.Shippers;

import java.util.List;

/**
 * Created by michal on 09.11.14.
 */
@Service
public class ShippersManager {
    @Autowired
    private ShippersDAO shippersDAO;

    public List<Shippers> findAllOrfers() {
        return shippersDAO.getAllShippers();
    }

    public String insertToDB(Shippers order) {
        return String.valueOf(shippersDAO.insert(order));
    }

    public Shippers findByID(int integer) {
        return shippersDAO.findByID(integer);
    }

    public String delete(Integer integer) {
        return String.valueOf(shippersDAO.delete(integer));
    }

    public void update(Shippers shippers) {
        shippersDAO.update(shippers);
    }
}
