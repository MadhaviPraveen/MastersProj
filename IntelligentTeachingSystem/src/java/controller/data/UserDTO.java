/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.data;

/**
 *
 * @author ivatu
 */
public class UserDTO {
    private int userID;
    private String fname;
    private String lname;
    private String userName;
    private String userType;
    
    public UserDTO() {
    }
    
    public UserDTO(User user) {
        if (user != null) {
            this.setFname(user.getFname());
            this.setLname(user.getLname());
            this.setUserID(user.getUserID());
            this.setUserType(user.getUserType());
            this.setUserName(user.getUserName());
        }
    }
    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
