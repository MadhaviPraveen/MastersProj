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
public class UserClass {

    private int userID;
    private int classID;
    private String className;
    private int year;
    private String semester;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public UserClass() {
    }
    
    public UserClass(int userID, int classID) {
        this.userID = userID;
        this.classID = classID;
    }

    @Override
    public String toString() {
        return "UserClass{" + "userID=" + userID + ", classID=" + classID + ", className=" + className + ", year=" + year + ", semester=" + semester + '}';
    }
    
    
}
