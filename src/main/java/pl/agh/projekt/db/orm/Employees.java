package pl.agh.projekt.db.orm;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by michal on 22.10.14.
 */
@Entity
@Table(name = "employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EmployeeID", unique = true, nullable = false, length = 10)
    private Integer employeeID;
    @Column(name = "LastName", length = 20)
    private String lastName;
    @Column(name = "FirstName", length = 10)
    private String firstName;
    @Column(name = "Title", length = 30)
    private String title;
    @Column(name = "TitleOfCourtesy", length = 25)
    private String titleOfCourtesy;
    @Column(name = "BirthDate")
    private Date birthDate;
    @Column(name = "HireDate")
    private Date hireDate;
    @Column(name = "Address", length = 60)
    private String address;
    @Column(name = "City", length = 15)
    private String city;
    @Column(name = "Region", length = 15)
    private String region;
    @Column(name = "PostalCode", length = 15)
    private String postalCode;
    @Column(name = "Country")
    private String country;
    @Column(name = "HomePhone", length = 24)
    private String homePhone;
    @Column(name = "Extension", length = 4)
    private String extension;
    @Column(name = "Photo", length = 40)
    private String photo;
    @Column(name = "Notes", columnDefinition = "TEXT")
    private String notes;
    @Column(name = "ReportsTo", length = 11)
    private Integer reportsTo;

    public Employees() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleOfCourtesy() {
        return titleOfCourtesy;
    }

    public void setTitleOfCourtesy(String titleOfCourtesy) {
        this.titleOfCourtesy = titleOfCourtesy;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Integer reportsTo) {
        this.reportsTo = reportsTo;
    }
}
