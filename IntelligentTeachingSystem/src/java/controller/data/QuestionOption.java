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
public class QuestionOption {

    private int questionID;
    private int optionID;
    
    public QuestionOption() {
    }
    
    public QuestionOption(int questionID, int optionID) {
        this.questionID = questionID;
        this.optionID = optionID;
    }

    @Override
    public String toString() {
        return "QuestionOption{" + "questionID=" + questionID + ", optionID=" + optionID + '}';
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

     
}
