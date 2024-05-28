package com.smart.entities;

import jakarta.persistence.*;

@Entity
@Table(name="CONTACT")
public class Contact {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int cId;
    private String name;
    private String secondname;
    private String work;
    private String email;
    private String imgUrl;
    @Column(length=500)
    private String description;
    private String phone;
    @ManyToOne
    private User user;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public int getcId() {
        return cId;
    }
    public void setcId(int cId) {
        this.cId = cId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSecondname() {
        return secondname;
    }
    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }
    public String getWork() {
        return work;
    }
    public void setWork(String work) {
        this.work = work;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getImgUrl() {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
