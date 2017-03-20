package controller.data;

import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ivatu
 */
public class Question {

    private int questionID;
    private String question;
    private List<OptionDTO> options;
    
    public Question(int questionID, String question, List<OptionDTO> options) {
        this.questionID = questionID;
        this.question = question;
        this.options = options;
    }

    @Override
    public String toString() {
        return "Question{" + "questionID=" + questionID + ", question=" + question + ", Options=" + options + '}';
    }
    
    public List<OptionDTO> getOptions() {
        return options;
    }

    public void setOptions(List<OptionDTO> Options) {
        this.options = Options;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Question() {
    }

    
}
