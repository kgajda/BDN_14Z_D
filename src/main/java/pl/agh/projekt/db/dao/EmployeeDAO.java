package pl.agh.projekt.db.dao;

import pl.agh.projekt.db.orm.Employees;

import java.util.List;

/**
 * Created by michal on 31.10.14.
 */
public interface EmployeeDAO {
    int insert(Employees employees);

    Employees findByID(int id);

    List<Employees> getAllEmployeers();

    void update(Employees employees);

    int delete(int id);


}
