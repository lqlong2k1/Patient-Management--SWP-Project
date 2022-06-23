/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author DELL
 */
public class User {
 private String ID_User;
 private String Phone;
 private String addressUser;
 private boolean gender;
 private String CCCD;
 private String Email;
 private String User_Name;
 private int User_AGE;
 private Date DOB;
 private String User_ROLE;

    public String getID_User() {
        return ID_User;
    }

    public void setID_User(String ID_User) {
        this.ID_User = ID_User;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getAddressUser() {
        return addressUser;
    }

    public void setAddressUser(String addressUser) {
        this.addressUser = addressUser;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String User_Name) {
        this.User_Name = User_Name;
    }

    public int getUser_AGE() {
        return User_AGE;
    }

    public void setUser_AGE(int User_AGE) {
        this.User_AGE = User_AGE;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getUser_ROLE() {
        return User_ROLE;
    }

    @Override
    public String toString() {
        return "User{" + "ID_User=" + ID_User + ", Phone=" + Phone + ", addressUser=" + addressUser + ", gender=" + gender + ", CCCD=" + CCCD + ", Email=" + Email + ", User_Name=" + User_Name + ", User_AGE=" + User_AGE + ", DOB=" + DOB + ", User_ROLE=" + User_ROLE + '}';
    }

    public void setUser_ROLE(String User_ROLE) {
        this.User_ROLE = User_ROLE;
    }

    public User(String ID_User, String Phone, String addressUser, boolean gender, String CCCD, String Email, String User_Name, int User_AGE, Date DOB, String User_ROLE) {
        this.ID_User = ID_User;
        this.Phone = Phone;
        this.addressUser = addressUser;
        this.gender = gender;
        this.CCCD = CCCD;
        this.Email = Email;
        this.User_Name = User_Name;
        this.User_AGE = User_AGE;
        this.DOB = DOB;
        this.User_ROLE = User_ROLE;
    }

    public User() {
    }

    
}
