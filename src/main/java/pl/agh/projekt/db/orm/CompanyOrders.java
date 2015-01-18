package pl.agh.projekt.db.orm;

/**
 * Created by szczepan on 12.12.14.
 */
public class CompanyOrders {

    private String companyName;
    private Long orders;

    public CompanyOrders(String companyName, Long orders) {
        this.companyName = companyName;
        this.orders = orders;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getOrders() {
        return orders;
    }

    public void setOrders(Long orders) {
        this.orders = orders;
    }
}
