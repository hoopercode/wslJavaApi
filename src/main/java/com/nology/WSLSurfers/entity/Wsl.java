package com.nology.WSLSurfers.entity;

import com.sun.istack.NotNull;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Validated
public class Wsl {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private int surfingNumber;
    @NotNull
    private int rookieYear;
    @NotNull
    private String imgUrl;
    @NotNull
    private String stance;
    @NotNull
    private int age;
    @NotNull
    private int height;


    public Wsl(int id, String firstName, String lastName, int surfingNumber, int rookieYear, String imgUrl, String stance, int age, int height) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.surfingNumber = surfingNumber;
        this.rookieYear = rookieYear;
        this.imgUrl = imgUrl;
        this.stance = stance;
        this.age = age;
        this.height = height;
    }

    public Wsl() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSurfingNumber() {
        return surfingNumber;
    }

    public void setSurfingNumber(int surfingNumber) {
        this.surfingNumber = surfingNumber;
    }

    public int getRookieYear() {
        return rookieYear;
    }

    public void setRookieYear(int rookieYear) {
        this.rookieYear = rookieYear;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getStance() {
        return stance;
    }

    public void setStance(String stance) {
        this.stance = stance;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
