package pl.agh.projekt.db.orm;

import javax.persistence.*;

/**
 * Created by karol on 31.10.14.
 */
@Entity
@Table(name = "shippers")
public class Shippers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ShipperID", length = 11, nullable = false)
    private int shipperId;
    @Column(name = "CompanyName", length = 40)
    private String companyName;
    @Column(name = "Phone", length = 24)
    private String phone;

    public Shippers() {
    }

    public int getShipperId() {
        return shipperId;
    }

    public void setShipperId(int shipperId) {
        this.shipperId = shipperId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
