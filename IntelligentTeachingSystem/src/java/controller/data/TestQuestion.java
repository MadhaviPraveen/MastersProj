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
public class TestQuestion {

    private int testID;
    private int questionID;
    
    @Override
    public String toString() {
        return "TestQuestion{" + "testID=" + testID + ", questionID=" + questionID + '}';
    }

    public TestQuestion(int testID, int questionID) {
        this.testID = testID;
        this.questionID = questionID;
    }

    public TestQuestion() {
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
       
}
