package controller.data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ivatu
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ivatu
 */
public class TestDAO {
    private static Connection con = null;
    
    public static Connection getCon() {
        return con;
    }
    
    public static void setCon(Connection con) {
        TestDAO.con = con;
    }
    
    public static boolean insertTest(Test tst) {
        if (tst == null) {
            return false;
        }
        try {
            PreparedStatement ps = con.prepareStatement(
                    "insert into Test(testName) values(?)");
            //ps.setString(1, tst.getTestId());
            ps.setString(1, tst.getTestName());
            int count = ps.executeUpdate();
            con.commit();
            if (count > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;         
    }
    
    public static Test getTestByID(int testID){
    	if(testID == 0){
            return null;
    	}
    	try {
            Statement stat = con.createStatement();
            String queryString = "select * from Test where testID = ?";
            //Create a statement
            PreparedStatement preparedStatement = con.prepareStatement(queryString);
            preparedStatement.setInt(1, testID);
            ResultSet rset = preparedStatement.executeQuery();
            if(rset.next()){
                Test test = new Test();
                test.setTestID(rset.getInt(1));
                test.setTestName(rset.getString(2));
    		return test;
            }
    	}
    	catch(Exception ex){
            ex.printStackTrace();
    	}
	return null;
    }
    
    public static List<Test> getAllTest() {
    	try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("select * from Test");
            ArrayList<Test> data = new ArrayList<Test>();
            while (rs.next()) {
            	Test testDTO = new Test();
            	testDTO.setTestID(rs.getInt("testid"));
            	testDTO.setTestName(rs.getString("testname"));
            	data.add(testDTO);
            	//data.add(new Test(rs.getString("TestID"), rs.getString("testName"), rs.getInt("year"), rs.getString("semester")));
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }return null;
    }
    
    public static boolean delete(int TestID) {
    	if (TestID == 0) {
            return false;
        }
    	try {
            PreparedStatement stat = con.prepareStatement("DELETE FROM test where testID = ?" );
            stat.setInt(1, TestID);
            int result = stat.executeUpdate();
            con.commit();
            if (result > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }
    
    public static boolean update(Test tst) {
       if (tst == null) {
            return false;
        }
       	try {
            PreparedStatement stat = con.prepareStatement("update Test set testName=?, year=?, semester=? where testID = ? " );
            //stat.setInt(1, usr.getUserId());
            stat.setString(1, tst.getTestName());
            int result = stat.executeUpdate();
            con.commit();
            if (result > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }
    
    public static boolean insertClassTest(ClassTest ct) {
        if (ct == null) {
            return false;
        }
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO class_test VALUES (?,?)");
            ps.setInt(1, ct.getClassID());
            ps.setInt(2, ct.getTestID());
            int count = ps.executeUpdate();
            con.commit();
            if (count > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;         
    }
    

    public static List<ClassTest> getCTSelectionById(int classID, int userId){
    	System.out.println(classID);
        if(classID == 0){
            
            return null;
    	}
    	try {
            PreparedStatement stat = con.prepareStatement("select  classId, T.* from ITS.Test T JOIN ITS.Class_Test CT ON T.testID = CT.testID WHERE CT.classID =  ? and CT.testId not in (select testId from user_test where userID = ?)");
            //Create a statement
            stat.setInt(1, classID);
            stat.setInt(2, userId);
            ResultSet rs = stat.executeQuery();
            List<ClassTest> data = new ArrayList<ClassTest>();
            while(rs.next()){
    		ClassTest classtest = new ClassTest();
                classtest.setClassID(rs.getInt("classID"));
    		classtest.setTestID(rs.getInt("testID"));
                classtest.setTestName(rs.getString("testName"));
                System.out.println(classtest);
                data.add(classtest);
            }
            return data;
    	}
    	catch(Exception ex){
            ex.printStackTrace();
    	}
	return null;
    }
    
    public static boolean deleteClassTest(int classID) {
    	if (classID == 0) {
            return false;
        }
    	try {
            PreparedStatement stat = con.prepareStatement("DELETE FROM class_Test WHERE classID=?" );
            stat.setInt(1, classID);
            int result = stat.executeUpdate();
            con.commit();
            if (result > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }
    
    public static boolean insertUserTest(UserTest ut) {
        if (ut == null) {
            return false;
        }
        try {
            PreparedStatement ps = con.prepareStatement("insert into User_Test values(?,?)");
            ps.setInt(1, ut.getUserID());
            ps.setInt(1, ut.getTestID());
            int count = ps.executeUpdate();
            con.commit();
            if (count > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;         
    }
    
    public static UserTest getUserTestByID(int userID){
    	if(userID == 0){
            return null;
    	}
    	try {
            Statement stat = con.createStatement();
            String queryString = "select T.* from Test T JOIN User_Test UT ON T.TestID = UT.testID WHERE userID=?;";
            //Create a statement
            PreparedStatement preparedStatement = con.prepareStatement(queryString);
            preparedStatement.setInt(1, userID);
            ResultSet rset = preparedStatement.executeQuery();
            if(rset.next()){
                UserTest usertest = new UserTest();
                usertest.setUserID(rset.getInt(1));
    		usertest.setTestID(rset.getInt(2));
                return usertest;
            }
    	}
    	catch(Exception ex){
            ex.printStackTrace();
    	}
	return null;
    }
    
    //SELECT * FROM Test WHERE testID NOT IN (SELECT testID FROM user_test where user_test.userID = 1);
    public static UserTest getUserPendingTestByID(int userID){
    	if(userID == 0){
            return null;
    	}
    	try {
            Statement stat = con.createStatement();
            String queryString = "SELECT * FROM Test WHERE testID NOT IN (SELECT testID FROM user_test where user_test.userID = ?)";
            //Create a statement
            PreparedStatement preparedStatement = con.prepareStatement(queryString);
            preparedStatement.setInt(1, userID);
            ResultSet rset = preparedStatement.executeQuery();
            if(rset.next()){
                UserTest usertest = new UserTest();
                usertest.setUserID(rset.getInt(1));
    		usertest.setTestID(rset.getInt(2));
                usertest.setTestName(rset.getString(3));
                return usertest;
            }
    	}
    	catch(Exception ex){
            ex.printStackTrace();
    	}
	return null;
    }
    
    //Evaluation
    public static Evaluation getEvaluationByID(int testID, int userID){
    	int correctAnswers;
        int totalQuestions;
        
        PreparedStatement correct = null;
        PreparedStatement total = null;
        
        if(testID == 0 || userID == 0){
            return null;       
        }
    	try {
            Evaluation evaluation = new Evaluation();
     
            String queryString1 = "SELECT COUNT(*) FROM user_answer UA JOIN Options O ON O.optionID = UA.optionID WHERE userID=? and testID=? and O.correct_Option=1";
            //Create a statement
            correct = con.prepareStatement(queryString1);
            correct.setInt(1, userID);
            correct.setInt(2, testID);
            ResultSet rset = correct.executeQuery();
            if(rset.next()){
                evaluation.setCorrectAnswers(rset.getInt(1));
            }
            
            String queryString2 = "SELECT COUNT(*) FROM TEST_QUESTION WHERE Testid=?";
            total = con.prepareStatement(queryString2);
            total.setInt(1, testID);
            ResultSet rs = total.executeQuery();
            if(rs.next()){
                evaluation.setTotalQuestions(rs.getInt(1));
            }
            
             return evaluation;
    	}
    	catch(Exception ex){
            ex.printStackTrace();
    	}
	return null;
    }
    
        
    public static boolean deleteUserTest(int UserID) {
    	if (UserID == 0) {
            return false;
        }
    	try {
            PreparedStatement stat = con.prepareStatement("DELETE FROM User_test where userID = ?;" );
            stat.setInt(1, UserID);
            int result = stat.executeUpdate();
            con.commit();
            if (result > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }
}    
