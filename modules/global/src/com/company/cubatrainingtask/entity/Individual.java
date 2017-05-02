package com.company.cubatrainingtask.entity;

import javax.persistence.*;

import com.haulmont.cuba.core.entity.StandardEntity;

@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
@Table(name = "CUBATRAININGTASK_INDIVIDUAL")
@Entity(name = "cubatrainingtask$Individual")
public class Individual extends Customer {
    private static final long serialVersionUID = -6033773780958616850L;

    @Column(name = "PASSPORT_NO", nullable = false)
    protected Integer passportNo;

    public void setPassportNo(Integer passportNo) {
        this.passportNo = passportNo;
    }

    public Integer getPassportNo() {
        return passportNo;
    }


}