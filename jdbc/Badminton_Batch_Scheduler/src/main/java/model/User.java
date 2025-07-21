package model;

public class User {
    private int userID;
    private String userName;
    private int batchId;

    public User() {
    }

    public User(int userID, String userName, int batchId) {
        this.userID = userID;
        this.userName = userName;
        this.batchId = batchId;
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

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", batchId=" + batchId +
                '}';
    }
}
