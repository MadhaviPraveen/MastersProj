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
public class StudentClass {

    private int classID;
    private String className;
    private int year;
    private String semester;

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getClassID() {
        return classID;
    }

    public String getClassName() {
        return className;
    }

    public int getYear() {
        return year;
    }

    public String getSemester() {
        return semester;
    }
    
    public StudentClass(int classID, String className, int year, String semester) {
        this.classID = classID;
        this.className = className;
        this.year = year;
        this.semester = semester;
    }
    
    public StudentClass() {
    }
    
    @Override
    public String toString() {
        return "Clas{" + "classID=" + classID + ", className=" + className + ", year=" + year + ", semester=" + semester + '}';
    }
}
