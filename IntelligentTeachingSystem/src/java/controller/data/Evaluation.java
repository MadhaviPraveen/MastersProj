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
public class Evaluation {

    private int correctAnswers;
    private int totalQuestions;   
    
    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }
    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }
    
    
    public Evaluation(int correctAnswers, int totalQuestions) {
        this.correctAnswers = correctAnswers;
        this.totalQuestions = totalQuestions;
    }

//    private int testID;
//    private int userID;

    public Evaluation() {
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }
    
    public int getTotalQuestions() {
        return totalQuestions;
    } 
    
    @Override
    public String toString() {
        return "Evaluation{" + "correctAnswers=" + correctAnswers + ", totalQuestions=" + totalQuestions + '}';
    }

//    public int getUserID() {
//        return userID;
//    }
//
//    public void setUserID(int userID) {
//        this.userID = userID;
//    }
//    public int getTestID() {
//        return testID;
//    }
//
//    public void setTestID(int testID) {
//        this.testID = testID;
//    }
//    @Override
//    public String toString() {
//        return "Evaluation{" + "correctAnswers=" + correctAnswers + ", totalQuestions=" + totalQuestions + ", testID=" + testID + ", userID=" + userID + '}';
//    }
//    public Evaluation(int correctAnswers, int totalQuestions, int testID, int userID) {
//        this.correctAnswers = correctAnswers;
//        this.totalQuestions = totalQuestions;
//        this.testID = testID;
//        this.userID = userID;
//    }

    
}
