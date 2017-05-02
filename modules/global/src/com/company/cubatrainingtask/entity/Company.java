package com.company.cubatrainingtask.entity;

import javax.persistence.*;

import com.haulmont.cuba.core.entity.StandardEntity;

@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
@Table(name = "CUBATRAININGTASK_COMPANY")
@Entity(name = "cubatrainingtask$Company")
public class Company extends Customer {
    private static final long serialVersionUID = 8142977976869766358L;

    @Column(name = "INN", nullable = false)
    protected Integer inn;

    public void setInn(Integer inn) {
        this.inn = inn;
    }

    public Integer getInn() {
        return inn;
    }


}