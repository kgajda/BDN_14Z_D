package pl.agh.projekt.db.dao;

import pl.agh.projekt.db.orm.Shippers;

import java.util.List;

/**
 * Created by michal on 31.10.14.
 */
public interface ShippersDAO {
    int insert(Shippers shippers);

    Shippers findByID(int id);

    List<Shippers> getAllShippers();

    void update(Shippers shippers);

    int delete(int id);
}
