package com.ippon.formation.gwt.client.domain.bindery.autobean;

import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;

public interface CustomAutoBeanFactory extends AutoBeanFactory {

    AutoBean<CountryAutoBean> country();

    AutoBean<PlayerAutoBean> player();
}
