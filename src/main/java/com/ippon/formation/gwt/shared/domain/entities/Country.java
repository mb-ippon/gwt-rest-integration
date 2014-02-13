package com.ippon.formation.gwt.shared.domain.entities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Country implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 8873060740655964600L;

    private String code;

    private String libelle;

    public Country() {
    }

    public Country(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

}
