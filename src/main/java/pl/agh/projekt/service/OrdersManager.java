/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.agh.projekt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.agh.projekt.db.dao.OrdersDAO;
import pl.agh.projekt.db.orm.CompanyOrders;
import pl.agh.projekt.db.orm.Orders;

import java.util.List;

/**
 *
 * @author szczepan
 */
@Service
public class OrdersManager {
    
    @Autowired
    private OrdersDAO ordersDAO;
    
    public List<Orders> findAllOrfers(){
        return ordersDAO.getAllOrders();
    }
    
    public Orders findByID(int id){
        return ordersDAO.findByID(id);
    }
    
    public int insertToDB(Orders orders){
       return ordersDAO.insert(orders);
    }

    public String update(Orders orders) {
        return String.valueOf(ordersDAO.update(orders));
    }

    public String delete(int id) {
        return String.valueOf(ordersDAO.delete(id));
    }

    public List<CompanyOrders> selectCO() {
        return ordersDAO.selectCO();
    }

    ;
}
