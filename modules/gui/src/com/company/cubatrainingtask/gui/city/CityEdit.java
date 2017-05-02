package com.company.cubatrainingtask.gui.city;

import com.company.cubatrainingtask.entity.Employee;
import com.company.cubatrainingtask.service.CitiesService;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.core.global.View;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.cubatrainingtask.entity.City;
import com.haulmont.cuba.gui.components.FieldGroup;
import com.haulmont.cuba.gui.components.PopupView;
import com.haulmont.cuba.gui.components.actions.EditAction;
import com.haulmont.cuba.gui.data.Datasource;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transaction;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CityEdit extends AbstractEditor {
    @Inject
    CitiesService citiesService;
    @Inject
    private Datasource<City> cityDs;
    @Inject
    private DataManager dataManager;
    @Inject
    private Persistence persistence;
    @Inject
    private EntityManager em;
    @Inject
    private FieldGroup fieldGroup;

    private boolean openForCreate = false;

    @Override
        protected boolean postCommit(boolean committed, boolean close) {
//        if(cityDs.getItem().getDefaultCity()){
//            citiesService.resetDefaultCity(cityDs.getItem().getCode());
//        }

//        City city = (City) getItem();
//        System.out.print(city.getName());
//        if (city.getDefaultCity()) {
//            LoadContext<City> lc = new LoadContext<>(City.class)
//                    .setQuery(new LoadContext.Query(
//                            "SELECT c from cubatrainingtask$City c WHERE c.defaultCity = true AND  c.name <> :id").setParameter("id", city.getName()))
//                    .setView(View.LOCAL);
//            List<City> cities = dataManager.loadList(lc);
//
//            for (int i = 0; i < cities.size(); i++) {
//                if (cities.get(i).getDefaultCity() && !cities.get(i).equals(city)) {
//                    cities.get(i).setDefaultCity(false);
//                    dataManager.commit(cities.get(i));
//                }
//                System.out.print(cities.get(i).getName() + "\n");
//            }
//        }

        return super.postCommit(committed, close);
    }

    @Override
    protected void initNewItem(Entity item) {
        super.initNewItem(item);
        openForCreate = true;
    }

    @Override
    protected boolean preCommit() {
            if(openForCreate == true){
            City city = (City) getItem();
            System.out.print("City: " + city.getName());
            LoadContext<City> lc = new LoadContext<>(City.class)
                    .setQuery(new LoadContext.Query(
                            "SELECT c from cubatrainingtask$City c"));

            List<City> cities = dataManager.loadList(lc);
            for(int i = 0; i < cities.size();i++){
                if(!cities.get(i).getName().equals(city.getName())){
                    String msg = formatMessage("warningMessage", city.getName());
                    System.out.print(msg);
                    fieldGroup.getField("name").setCaption(msg);
                    // super.initNewItem(item);
                } else return false;
            }
        }   return super.preCommit();
    }



    @Override
    public void init(Map<String, Object> params) {

    }
}