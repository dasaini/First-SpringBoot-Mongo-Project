package com.example.demo_mongodb_springboot;

import org.apache.catalina.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UserData")
public class UserData {

    private String userFirstName;
    private String userLastName;
    private String userDob;
    @Id
    private String Id;
    private String userAddress;
    private String userCity;
    private String userState;
    private String userZip;

    public UserData(String userFirstName, String userLastName, String userDob, String Id, String userAddress, String userCity, String userState, String userZip) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userDob = userDob;
        this.Id = Id;
        this.userAddress = userAddress;
        this.userCity = userCity;
        this.userState = userState;
        this.userZip = userZip;
    }

    public UserData() {
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserDob() {
        return userDob;
    }

    public void setUserDob(String userDob) {
        this.userDob = userDob;
    }

    public String getId() {
        return Id;
    }

    public void setId(String userId) {
        this.Id = userId;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public String getUserZip() {
        return userZip;
    }

    public void setUserZip(String userZip) {
        this.userZip = userZip;
    }
}
