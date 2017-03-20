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
public class ClassTest {

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    @Override
    public String toString() {
        return "ClassTest{" + "classID=" + classID + ", testID=" + testID + ", testName=" + testName + '}';
    }
    
    private int classID;
    private int testID;
    private String testName;

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public int getTestID() {
        return testID;
    }

    public void setTestID(int testID) {
        this.testID = testID;
    }

    public ClassTest() {
    }
    
    public ClassTest(int classID, int testID) {
        this.classID = classID;
        this.testID = testID;
    }

    
}
