package com.miempresa.demoapp.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity
public class User {
    @PrimaryKey()
    @NotNull
    @ColumnInfo(index = true)
    String userEmail;
    String userPassword;
    @ColumnInfo(index = true)
    String userName;
    String userIdentificationType;
    String userIdentificationNumber;
    String userRegion;
    String userCity;
    String userDirection;
    public boolean sesion;

    public User(){}

    @Ignore
    public User(String userEmail, String userPassword, String userName, String userIdentificationType, String userIdentificationNumber, String userRegion, String userCity, String userDirection, boolean sesion) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userIdentificationType = userIdentificationType;
        this.userIdentificationNumber = userIdentificationNumber;
        this.userRegion = userRegion;
        this.userCity = userCity;
        this.userDirection = userDirection;
        this.sesion = sesion;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIdentificationType() {
        return userIdentificationType;
    }

    public void setUserIdentificationType(String userIdentificationType) {
        this.userIdentificationType = userIdentificationType;
    }

    public String getUserIdentificationNumber() {
        return userIdentificationNumber;
    }

    public void setUserIdentificationNumber(String userIdentificationNumber) {
        this.userIdentificationNumber = userIdentificationNumber;
    }

    public String getUserRegion() {
        return userRegion;
    }

    public void setUserRegion(String userRegion) {
        this.userRegion = userRegion;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserDirection() {
        return userDirection;
    }

    public void setUserDirection(String userDirection) {
        this.userDirection = userDirection;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
