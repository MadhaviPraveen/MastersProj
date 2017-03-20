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
public class UserAnswer {

    private int userID;
    private int testID;
    private int questionID;
    private int optionID;
    
    @Override
    public String toString() {
        return "UserAnswer{" + "userID=" + userID + ", testID=" + testID + ", questionID=" + questionID + ", optionID=" + optionID + '}';
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

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public int getOptionID() {
        return optionID;
    }

    public void setOptionID(int optionID) {
        this.optionID = optionID;
    }

    public UserAnswer(int userID, int testID, int questionID, int optionID) {
        this.userID = userID;
        this.testID = testID;
        this.questionID = questionID;
        this.optionID = optionID;
    }

    public UserAnswer() {
    }

}
