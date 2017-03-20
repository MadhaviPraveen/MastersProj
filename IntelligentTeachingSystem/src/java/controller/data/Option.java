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
public class Option {

    private int optionID;
    private String text;
    private boolean correctOption;

    public int getOptionID() {
        return optionID;
    }

    public void setOptionID(int optionID) {
        this.optionID = optionID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(boolean correctOption) {
        this.correctOption = correctOption;
    }
    
    @Override
    public String toString() {
        return "Options{" + "optionID=" + optionID + ", text=" + text + ", correctOption=" + correctOption + '}';
    }

    public Option() {
    }
    
    public Option(int optionID, String text, boolean correctOption) {
        this.optionID = optionID;
        this.text = text;
        this.correctOption = correctOption;
    }
}
