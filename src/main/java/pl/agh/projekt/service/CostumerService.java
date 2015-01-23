package pl.agh.projekt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.agh.projekt.db.dao.CustomerDAO;
import pl.agh.projekt.db.orm.Customer;
import pl.agh.projekt.db.orm.Orders;

import java.util.Date;
import java.util.List;

/**
 * Created by karol on 23.01.15.
 */
@Service
public class CostumerService {
    @Autowired
    CustomerDAO customerDAO;

    public List<Customer> getAll() {
        return customerDAO.findAll();
    }

    @Transactional
    public void newOrder(String a, String b) {
        Orders order = new Orders();
        order.setOrderDate(new Date());
        order.setShipVia(27);
        Customer customer = customerDAO.findById(a);
        order.setCustomerId(customer);
        customer.getOrdersList().add(order);
//        customerDAO.update(customer);
        if (Boolean.parseBoolean(b)) {
            throw new RuntimeException();
        }
    }

}
