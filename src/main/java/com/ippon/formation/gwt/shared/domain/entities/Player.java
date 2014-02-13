package com.ippon.formation.gwt.shared.domain.entities;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Player implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -4312165633377357234L;

    public Player() {

    }

    public Player(String name, Integer height, Integer weight, Date birthDay, Plays playHand, Integer yearTurnPro,
            Integer atpPoint, Country country) {
        this.name = name;
        this.height = height;
        this.playHand = playHand;
        this.birthDay = birthDay;
        this.weight = weight;
        this.yearTurnPro = yearTurnPro;
        this.atpPoint = atpPoint;
        this.country = country;
    }

    private String name;
    private Date birthDay;
    private Integer height;
    private Integer weight;
    private Integer yearTurnPro;
    private Integer atpPoint;
    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    // the way which he plays
    private Plays playHand;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setTurnedPro(Date birthDay) {
        this.birthDay = birthDay;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public int getYearTurnPro() {
        return yearTurnPro;
    }

    public void setYearTurnPro(Integer yearTurnPro) {
        this.yearTurnPro = yearTurnPro;
    }

    public Plays getPlayHand() {
        return playHand;
    }

    public void setPlayHand(Plays playHand) {
        this.playHand = playHand;
    }

    public Integer getAtpPoint() {
        return atpPoint;
    }

    public void setAtpPoint(Integer atpPoint) {
        this.atpPoint = atpPoint;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Player other = (Player) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        }
        else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

}
