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
public class UserOptions {

    private int question;
    private int option;
    
    public UserOptions(int question, int option) {
        this.question = question;
        this.option = option;
    }

    public UserOptions() {
    }

    @Override
    public String toString() {
        return "UserOptions{" + "question=" + question + ", option=" + option + '}';
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }
    
}
