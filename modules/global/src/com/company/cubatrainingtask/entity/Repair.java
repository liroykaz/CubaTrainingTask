package com.company.cubatrainingtask.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s %s|employee,carServiceCenter")
@Table(name = "CUBATRAININGTASK_REPAIR")
@Entity(name = "cubatrainingtask$Repair")
public class Repair extends StandardEntity {
    private static final long serialVersionUID = 5866056119798373409L;

    @Column(name = "DESCRIPTION")
    protected String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID")
    protected Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAR_SERVICE_CENTER_ID")
    protected CarServiceCenter carServiceCenter;

    public void setCarServiceCenter(CarServiceCenter carServiceCenter) {
        this.carServiceCenter = carServiceCenter;
    }

    public CarServiceCenter getCarServiceCenter() {
        return carServiceCenter;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }


}