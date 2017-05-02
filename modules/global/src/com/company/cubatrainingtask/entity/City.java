package com.company.cubatrainingtask.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;

@NamePattern("%s|name")
@Table(name = "CUBATRAININGTASK_CITY")
@Entity(name = "cubatrainingtask$City")

public class City extends StandardEntity {
    private static final long serialVersionUID = 49649867750289460L;

    @Column(name = "NAME", nullable = false, length = 100)
    protected String name;

    @Column(name = "CODE", nullable = false, length = 100)
    protected String code;

    @Column(name = "DEFAULT_CITY")
    protected Boolean defaultCity;

    public void setDefaultCity(Boolean defaultCity) {
        this.defaultCity = defaultCity;
    }

    public Boolean getDefaultCity() {
        return defaultCity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}