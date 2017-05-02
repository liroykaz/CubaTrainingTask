package com.company.cubatrainingtask;

import org.springframework.jmx.export.annotation.ManagedResource;

/**
 * Created by lebedev on 30.03.2017.
 */
@ManagedResource(description = "Performs email operations")
public interface EmployeeWorkerMBean  {

    String sendGreetings();
}
