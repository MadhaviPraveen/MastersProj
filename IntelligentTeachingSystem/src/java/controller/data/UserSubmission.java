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
public class UserSubmission {
    
    private int userId;
    private int testId;
    private List<UserOptions> questionOptions;

    public UserSubmission(int userId, int testId, List<UserOptions> questionOptions) {
        this.userId = userId;
        this.testId = testId;
        this.questionOptions = questionOptions;
    }

    public UserSubmission() {
    }

    @Override
    public String toString() {
        return "UserSubmission{" + "userId=" + userId + ", testId=" + testId + ", questionOptions=" + questionOptions + '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public List<UserOptions> getQuestionOptions() {
        return questionOptions;
    }

    public void setQuestionOptions(List<UserOptions> questionOptions) {
        this.questionOptions = questionOptions;
    }


    
}
