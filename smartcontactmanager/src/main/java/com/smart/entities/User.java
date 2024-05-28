package com.smart.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="USER")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private int id;
    private String name;
    @Column(unique=true)
    private String email;
    private String password;
    private String role;
    @Column(length=500)
    private String about;
    private boolean enabled;
    private String imgUrl;

    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY,mappedBy ="user")
    private List<Contact> contacts=new ArrayList<>();

    public List<Contact> getContacts() {
        return contacts;
    }
    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getAbout() {
        return about;
    }
    public void setAbout(String about) {
        this.about = about;
    }
    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    public String getImgUrl() {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


}
