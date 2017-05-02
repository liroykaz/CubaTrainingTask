package com.company.cubatrainingtask.gui.repair;

import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.cubatrainingtask.entity.Repair;
import com.haulmont.cuba.gui.components.FieldGroup;
import com.haulmont.cuba.gui.data.Datasource;

import javax.inject.Inject;
import java.util.Map;

public class RepairEdit extends AbstractEditor<Repair> {

    @Inject
    FieldGroup fieldGroup;

    @Inject
    private Datasource<Repair> repairDs;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        repairDs.addItemChangeListener(e -> {
            //repairDs.getItem()
        });
    }


}