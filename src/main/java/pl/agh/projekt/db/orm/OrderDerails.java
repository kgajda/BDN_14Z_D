package pl.agh.projekt.db.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by michal on 31.10.14.
 */
@Entity
@Table(name = "order_details")
public class OrderDerails {

    @Id
    @Column(name = "odID", length = 10, nullable = false)
    private Integer odId;
    @Column(name = "OrderID", length = 11)
    private Integer orderId;
    @Column(name = "ProductID", length = 11)
    private Integer productId;
    @Column(name = "UnitPrice", length = 1)
    private Float unitPrice;


    public OrderDerails() {
    }


    public Integer getOdId() {
        return odId;
    }

    public void setOdId(Integer odId) {
        this.odId = odId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }


}
