package com.company.cubatrainingtask;

import com.haulmont.cuba.core.app.ServerConfig;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Configuration;
import com.haulmont.cuba.core.jmx.ConfigStorageMBean;
import org.springframework.stereotype.Component;

/**
 * Created by lebedev on 31.03.2017.
 */
@Component("ChangeEmailMBean")
public class ChangeEmail implements ChangeEmailMBean {

    @Override
    public void newAdress(String email) {
        ConfigStorageMBean configStorageMBean = AppBeans.get(ConfigStorageMBean.class);

        configStorageMBean.getDbProperty("cuba.email.fromAddress");
        configStorageMBean.setDbProperty("cuba.email.fromAddress", email);

    }
}
