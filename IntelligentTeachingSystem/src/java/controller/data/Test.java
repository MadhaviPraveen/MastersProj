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
public class Test {

    private int testID;
    private String testName;
    
    public int getTestID() {
        return testID;
    }

    public void setTestID(int testID) {
        this.testID = testID;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    @Override
    public String toString() {
        return "Test{" + "testID=" + testID + ", testName=" + testName + '}';
    }

    public Test() {
    }
    
    public Test(int testID, String testName) {
        this.testID = testID;
        this.testName = testName;
    }
}
