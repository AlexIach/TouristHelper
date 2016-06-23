package com.qoobico.remindme.model;

/**
 * Created by ЦАРЬ on 05.01.2016.
 */
public class Sights {
    private Integer id;
    private String name;
    private String country;
    private String coordination;
    private String description;

    public Sights(Integer id, String name, String country, String coordination, String description) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.coordination = coordination;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCoordination() {
        return coordination;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCoordination(String coordination) {
        this.coordination = coordination;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void printInfoAboutSight(){
        System.out.println("Id of Sights = "+this.id + ", Sight's name =  "+this.name+", Country = "+this.country+", Coordinations = "+this.coordination+", Description = "+this.description+" .");
    }
}
