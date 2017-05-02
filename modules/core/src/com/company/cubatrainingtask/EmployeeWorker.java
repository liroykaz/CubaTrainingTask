package com.company.cubatrainingtask;

import com.company.cubatrainingtask.entity.Employee;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.TypedQuery;
import com.haulmont.cuba.core.app.EmailerAPI;
import com.haulmont.cuba.core.app.ServerConfig;
import com.haulmont.cuba.core.global.*;
import com.haulmont.cuba.security.app.Authenticated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.naming.Binding;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by lebedev on 30.03.2017.
 */
@Component("EmployeeWorkerMBean")
public class EmployeeWorker implements EmployeeWorkerMBean {


    @Authenticated
    @Transactional
    @Override
    public String sendGreetings() {
        String stringBirth, stringToday = null;
        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM", Locale.ENGLISH );
        SimpleDateFormat ageFormat = new SimpleDateFormat("YYYY", Locale.ENGLISH );;
        int age = 0;

        Persistence persistence = AppBeans.get(Persistence.class);
        EmailerAPI emailerAPI = AppBeans.get(EmailerAPI.class);
        Transaction tx = persistence.createTransaction();

        Scripting scripting = AppBeans.get(Scripting.class);

        EntityManager em = persistence.getEntityManager();
        TypedQuery<Employee> query = em.createNativeQuery(
                "select * from CUBATRAININGTASK_EMPLOYEE",
                Employee.class);
        List<Employee> list = query.getResultList();
        tx.commit();

        List<Employee> birthdayList = new ArrayList<>();
        for(int i = 0; i < list.size();i++){
            stringBirth = dateFormat.format(list.get(i).getBirthDate());
            stringToday = dateFormat.format(today);
            if(stringToday.equals(stringBirth)){
                birthdayList.add(list.get(i));
                stringBirth = ageFormat.format(list.get(i).getBirthDate());
                stringToday = ageFormat.format(today);
                age = Integer.parseInt(stringToday) - Integer.parseInt(stringBirth);
                System.out.print("AGE = " + age);
            }
            System.out.print("TODAY    " + stringToday + "\n ");
            System.out.print("Birthday " + stringBirth+"\n ");
        }


        //Class MailText = scripting.loadClass("com.company.cubatrainingtask/MailText");

        groovy.lang.Binding binding = new groovy.lang.Binding();
        binding.setVariable("employee", birthdayList.get(0));
        binding.setVariable("age", String.valueOf(age));
        String text = scripting.runGroovyScript("com.company.cubatrainingtask.MailText", binding).toString();
        String email = birthdayList.get(0).getEmail();

        EmailInfo emailInfo = new EmailInfo(email,"С Днём Рождения!", null, text);
        try {
            emailerAPI.sendEmail(emailInfo);
        } catch (EmailException e) {
            e.printStackTrace();
        }
        return "Selected : LastName" + birthdayList.get(0).getLastName() + "Email: " + email;
    }
}
