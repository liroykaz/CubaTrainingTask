package com.company.cubatrainingtask.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.security.entity.User;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import java.util.Collection;

@NamePattern("%s %s|name,name")
@Table(name = "CUBATRAININGTASK_CAR_SERVICE_CENTER")
@Entity(name = "cubatrainingtask$CarServiceCenter")
public class CarServiceCenter extends StandardEntity {
    private static final long serialVersionUID = 6439740927617009634L;

    @Column(name = "NAME")
    protected String name;

    @Column(name = "PHONE")
    protected String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY_ID")
    @OnDeleteInverse(DeletePolicy.DENY)
    protected City city;

    @Column(name = "ADDRESS")
    protected String address;

    @OneToMany(mappedBy = "center")
    protected Set<Employee> employees;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "carServiceCenter")
    protected Set<Repair> repair;

    @OneToMany(mappedBy = "center")
    protected Set<Customer> customers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATOR_ID")
    protected User creator;

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }





    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }




    public Set<Repair> getRepair() {
        return repair;
    }

    public void setRepair(Set<Repair> repair) {
        this.repair = repair;
    }



    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }



    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }


}