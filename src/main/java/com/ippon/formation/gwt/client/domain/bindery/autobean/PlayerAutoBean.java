package com.ippon.formation.gwt.client.domain.bindery.autobean;

import java.util.Date;

import com.ippon.formation.gwt.shared.domain.entities.Country;
import com.ippon.formation.gwt.shared.domain.entities.Plays;

public interface PlayerAutoBean {

    CountryAutoBean getCountry();

    void setCountry(Country country);

    void setBirthDay(Date birthDay);

    String getName();

    void setName(String name);

    Date getBirthDay();

    void setTurnedPro(Date birthDay);

    int getHeight();

    void setHeight(Integer height);

    int getWeight();

    void setWeight(Integer weight);

    int getYearTurnPro();

    void setYearTurnPro(Integer yearTurnPro);

    Plays getPlayHand();

    void setPlayHand(Plays playHand);

    Integer getAtpPoint();

    void setAtpPoint(Integer atpPoint);
}
