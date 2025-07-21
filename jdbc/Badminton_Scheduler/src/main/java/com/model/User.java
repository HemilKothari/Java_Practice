package com.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userID;
    private String userName;

    @ManyToOne
    @JoinColumn(name = "batchId")
    private Batch batchInfo;

    public User() {
    }

    public User(int userID, String userName, Batch batchInfo) {
        this.userID = userID;
        this.userName = userName;
        this.batchInfo = batchInfo;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Batch getBatchInfo() {
        return batchInfo;
    }

    public void setBatchInfo(Batch batchInfo) {
        this.batchInfo = batchInfo;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                '}';
    }
}
