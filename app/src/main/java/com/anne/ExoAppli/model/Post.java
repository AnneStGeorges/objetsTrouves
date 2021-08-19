package com.anne.ExoAppli.model;

import androidx.annotation.NonNull;

import java.util.Date;

public class Post {
    private String name;
    private String description;
    private String address;
    private CivilityEnum civility;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private Date createdDate;


    public Post(String name, String description, String address, CivilityEnum civility, String firstname, String lastname, String email, String phoneNumber) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.civility = civility;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.createdDate = new Date();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCivility(CivilityEnum civility) {
        this.civility = civility;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getAddress() {
        return address;
    }

    public CivilityEnum getCivility() {
        return civility;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    @NonNull
    @Override
    public String toString() {
        return "Post{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", civility=" + civility +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
