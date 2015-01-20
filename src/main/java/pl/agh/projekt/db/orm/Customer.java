package pl.agh.projekt.db.orm;

import javax.persistence.*;

/**
 * Created by michal on 12.12.14.
 */
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CustomerID", length = 11, nullable = false)
    private String customerID;
    @Column(name = "CompanyName")
    private String companyName;
    @Column(name = "ContactName")
    private String contactName;
    @Column(name = "ContactTitle")
    private String contactTitle;
    @Version
    private long vesrion;

    public Customer() {
    }

    public Customer(String companyName, String contactName, String contactTitle) {
        this.companyName = companyName;
        this.contactName = contactName;
        this.contactTitle = contactTitle;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public long getVesrion() {
        return vesrion;
    }

    public void setVesrion(long vesrion) {
        this.vesrion = vesrion;
    }
}
