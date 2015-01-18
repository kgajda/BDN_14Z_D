package pl.agh.projekt.db.orm;

import javax.persistence.*;

/**
 * Created by szczepan on 31.10.14.
 */
@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ProductID", length = 11, nullable = false)
    private Integer productId;
    @Column(name = "ProductName", length = 40)
    private String productName;
    @Column(name = "supplierID", length = 11)
    private Integer supplierId;
    @Column(name = "CategoryID", length = 11)
    private Integer categoryId;
    @Column(name = "QuantityPerUnit", length = 20)
    private String quantityPerUnit;
    @Column(name = "UnitPrice", length = 1)
    private Float unitPrice;
    @Column(name = "UnitsInStock", length = 6, columnDefinition = "SMALLINT")
    private Integer unitsInStock;
    @Column(name = "UnitsOnOrder", length = 6, columnDefinition = "SMALLINT")
    private Integer unitsOnOrder;
    @Column(name = "ReorderLevel", length = 6, columnDefinition = "SMALLINT")
    private Integer reorderLevel;
    @Column(name = "Discontinued", length = 1, columnDefinition = "BIT")
    private boolean discontinued;

    public Products() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(Integer unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public Integer getUnitsOnOrder() {
        return unitsOnOrder;
    }

    public void setUnitsOnOrder(Integer unitsOnOrder) {
        this.unitsOnOrder = unitsOnOrder;
    }

    public Integer getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(Integer reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public boolean getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }
}
