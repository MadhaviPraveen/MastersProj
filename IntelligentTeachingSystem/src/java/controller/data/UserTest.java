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
public class UserTest {

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    @Override
    public String toString() {
        return "UserTest{" + "userID=" + userID + ", testID=" + testID + ", testName=" + testName + '}';
    }

    private int userID;
    private int testID;
    private String testName;



    public UserTest(int userID, int testID, String testName) {
        this.userID = userID;
        this.testID = testID;
        this.testName = testName;
    }

    public UserTest() {
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getTestID() {
        return testID;
    }

    public void setTestID(int testID) {
        this.testID = testID;
    }    
}
