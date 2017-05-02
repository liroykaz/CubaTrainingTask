package com.company.cubatrainingtask;

import org.springframework.jmx.export.annotation.ManagedResource;

/**
 * Created by lebedev on 31.03.2017.
 */
@ManagedResource(description = "Performs changing email adress")
public interface ChangeEmailMBean {

    void newAdress(String email);
}
