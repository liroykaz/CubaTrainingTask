package com.company.cubatrainingtask.service;


import com.company.cubatrainingtask.entity.City;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Metadata;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

@Service(CitiesService.NAME)
public class CitiesServiceBean implements CitiesService {

    @Override
    public City getDefaultCity() {
        Persistence persistence = AppBeans.get(Persistence.class);
        Transaction tx = persistence.createTransaction();
        EntityManager em = persistence.getEntityManager();
        Query q = em.createQuery("SELECT c from cubatrainingtask$City c WHERE c.defaultCity = TRUE", City.class);
        City city = (City) q.getFirstResult();
        System.out.print(city.getName());
        tx.close();
        return city;
    }

    @Override
    public void resetDefaultCity(String code){
        Persistence persistence = AppBeans.get(Persistence.class);
        Transaction tx = persistence.createTransaction();
        EntityManager em = persistence.getEntityManager();
        Query q = em.createQuery("UPDATE cubatrainingtask$City c SET c.defaultCity = FALSE WHERE c.defaultCity = TRUE AND c.code <> :code", City.class)
                .setParameter("code", code);
        q.executeUpdate();
        try {
            em.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}