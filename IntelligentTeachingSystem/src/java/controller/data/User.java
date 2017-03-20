package controller.data;

    
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ivatu
 */
public class User {

    private int userID;
    private String fname;
    private String lname;
    private String userName;
    private String password;
    private String userType;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int UserID) {
        this.userID = UserID;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    
    public User() {
    }
    
    public User(int UserID, String fname, String lname, String userName, String password, String userType) {
        this.userID = UserID;
        this.fname = fname;
        this.lname = lname;
        this.userName = userName;
        this.password = password;
        this.userType = userType;
    }
    
    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", fname=" + fname + ", lname=" + lname + ", userName=" + userName + ", password=" + password + ", userType=" + userType + '}';
    }
    
}
