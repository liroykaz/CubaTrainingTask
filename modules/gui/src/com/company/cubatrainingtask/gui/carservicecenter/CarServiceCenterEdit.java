package com.company.cubatrainingtask.gui.carservicecenter;

import com.company.cubatrainingtask.entity.City;
import com.company.cubatrainingtask.entity.Customer;
import com.company.cubatrainingtask.service.CitiesService;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.*;
import com.company.cubatrainingtask.entity.CarServiceCenter;

import javax.inject.Inject;

import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.data.GroupDatasource;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.haulmont.cuba.security.global.UserSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CarServiceCenterEdit extends AbstractEditor<CarServiceCenter> {

    @Inject
    private CitiesService citiesService;

    @Inject
    private TabSheet tabSheet;

    @Inject
    private Table customersTable;

    @Inject
    protected ComponentsFactory componentsFactory;

    @Inject
    UserSession userSession;

    @Inject
    private Datasource<CarServiceCenter> carServiceCenterDs;
    @Inject
    private GroupDatasource<Customer, UUID> customersDs;

    private boolean openToCreate = false;

    @Override
    protected void initNewItem(CarServiceCenter item) {
        openToCreate = true;
        super.initNewItem(item);
        item.setCity(citiesService.getDefaultCity());
    }

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        customersDs.addCollectionChangeListener(e -> {
           int num = customersDs.getItems().size();
           tabSheet.getTab("CustomersTab").setCaption("Клиенты (" + num +")");
        });
    }

    @Override
    protected boolean preCommit() {
        if(openToCreate){
           carServiceCenterDs.getItem().setCreator(userSession.getUser());
        }
        return super.preCommit();

    }
}