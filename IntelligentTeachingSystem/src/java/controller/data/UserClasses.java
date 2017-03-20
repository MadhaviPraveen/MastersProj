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
public class UserClasses {
    
    private int userId;
    private List<String> classIds;

    public List<String> getClassIds() {
        return classIds;
    }

    public void setClassIds(List<String> classIds) {
        this.classIds = classIds;
    }

    @Override
    public String toString() {
        return "UserClasses{" + "userId=" + userId + ", classId=" + classIds + '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    

    public UserClasses() {
    }
    
}
