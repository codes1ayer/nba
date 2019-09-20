package us.data.nba.entity;


import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

public class Player {
    public Integer id;
    public String name;
    @DateTimeFormat(pattern="yyyy-mm-dd")
    public Date brith;
    public String nationality;
    public Double height;
    public Double weight;
    public Double arme;

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brith=" + brith +
                ", nationality='" + nationality + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", arme=" + arme +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBrith() {
        return brith;
    }

    public void setBrith(Date brith) {
        this.brith = brith;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }


    public Double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Double getArme() {
        return arme;
    }

    public void setArme(double arme) {
        this.arme = arme;
    }

    public Player(Integer id, String name, Date brith, String nationality, double height, double weight, double arme) {
        this.id = id;
        this.name = name;
        this.brith = brith;
        this.nationality = nationality;
        this.height = height;
        this.weight = weight;
        this.arme = arme;
    }

    public Player(String name, Date brith, String nationality, double height, double weight, double arme) {
        this.name = name;
        this.brith = brith;
        this.nationality = nationality;
        this.height = height;
        this.weight = weight;
        this.arme = arme;
    }

    public Player() {
    }
}
