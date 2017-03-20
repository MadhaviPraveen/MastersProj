/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.data;

import java.util.List;

/**
 *
 * @author ivatu
 */
public class QuestionDTO {

    private String question;
    private List<String> options;
    private int correctOption;
    
    public QuestionDTO() {
    }

    @Override
    public String toString() {
        return "classQuestionDTO{" + "question=" + question + ", options=" + options + ", correctOption=" + correctOption + '}';
    }
    
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public int getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(int correctOption) {
        this.correctOption = correctOption;
    }

}
