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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserAnswerDAO {
    private static Connection con = null;
    
    public static Connection getCon() {
        return con;
    }
    
    public static void setCon(Connection con) {
        UserAnswerDAO.con = con;
    }
    
    public static boolean insertUserAnswer(UserSubmission userSubmission) {
        if (userSubmission == null) {
            return false;
        }
        System.out.println(userSubmission);
        try {
            String usertestSQL = "INSERT INTO user_test (userID, testID) VALUES (?,?)";
            PreparedStatement ps = con.prepareStatement(usertestSQL);

            ps.setInt(1, userSubmission.getUserId());
            ps.setInt(2, userSubmission.getTestId());

            int success = ps.executeUpdate();
            System.out.println("inserting userId : " + userSubmission.getUserId() + " testId : " + userSubmission.getTestId());
            con.commit();
                    System.out.println("inserted in the user_test table as - userId : " + userSubmission.getUserId() + " testId : " + userSubmission.getTestId());
                    
            for (UserOptions uo : userSubmission.getQuestionOptions()) {
                String userAnswerSQL = "insert into user_answer(userId, testId, questionId, optionId) values (?,?,?,?)";
                ps = con.prepareStatement(userAnswerSQL);
                ps.setInt(1, userSubmission.getUserId());
                ps.setInt(2, userSubmission.getTestId());
                ps.setInt(3, uo.getQuestion());
                ps.setInt(4, uo.getOption());
                System.out.println("Inserting userId: " + userSubmission.getUserId() + "testId: " + userSubmission.getTestId() + "questionId: " + userSubmission.getQuestionOptions()); 
                ps.executeUpdate();
                con.commit();
                System.out.println("Inserted the following details userId: " + userSubmission.getUserId() + "testId: " + userSubmission.getTestId() + "questionId: " + userSubmission.getQuestionOptions());
                
            }
        } catch (SQLException   ex) {
            Logger.getLogger(UserAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;         
    }
    
    public static UserAnswer getUserAnswerByID(int testID){
    	if(testID == 0){
            return null;
    	}
    	try {
            Statement stat = con.createStatement();
            String queryString = "SELECT Q.*, O.* FROM Test_Question TQ JOIN Question Q ON TQ.questionID = Q.questionID \n" +
"									JOIN Question_Options QO ON Q.questionID = QO.questionId\n" +
"                                                                       JOIN ITS.Options O ON O.optionId = QO.optionID\n" +
"                                                                       WHERE TQ.testID =?";
            //Create a statement
            PreparedStatement preparedStatement = con.prepareStatement(queryString);
            preparedStatement.setInt(1, testID);
            ResultSet rset = preparedStatement.executeQuery();
            if(rset.next()){
                UserAnswer useranswer = new UserAnswer();
                useranswer.setTestID(rset.getInt(1));
                useranswer.setUserID(rset.getInt(2));
                useranswer.setQuestionID(rset.getInt(3));
                useranswer.setOptionID(rset.getInt(4));
    		return useranswer;
            }
    	}
    	catch(Exception ex){
            ex.printStackTrace();
    	}
	return null;
    }
    
    public static List<UserAnswer> getAllUserAnswer() {
    	try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM User_Answer;");
            ArrayList<UserAnswer> data = new ArrayList<UserAnswer>();
            while (rs.next()) {
            	UserAnswer useranswer = new UserAnswer();
            	useranswer.setUserID(rs.getInt("userID"));
            	useranswer.setTestID(rs.getInt("testID"));
            	useranswer.setQuestionID(rs.getInt("questionID"));
            	useranswer.setOptionID(rs.getInt("optionID"));
            	data.add(useranswer);
            	//data.add(new UserAnswer(rs.getInt("userid"), rs.getInt("testid"), rs.getInt("questionid"), rs.getInt("optionid")));
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(UserAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }return null;
    }
    
    public static boolean deleteUserAnswer(int UserID) {
    	if (UserID <= 0) {
            return false;
        }
    	try {
            PreparedStatement stat = con.prepareStatement("DELETE FROM  User_Answer where UserID = ?" );
            stat.setInt(1, UserID);
            int result = stat.executeUpdate();
            con.commit();
            if (result > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }
        
//    public static boolean updateUserAnswer(UserAnswer uar) {
//       if (uar == null) {
//            return false;
//        }
//       	try {
//            PreparedStatement stat = con.prepareStatement("update User set fname=?, lname=?, username=?, password=?, userType=? where userID = ?");
//            //stat.setInt(1, usr.getUserID());
//            stat.setString(1, usr.getFname());
//            stat.setString(2, usr.getLname());
//            stat.setString(3, usr.getUserName());
//            stat.setString(4, usr.getPassword());
//            stat.setString(5, usr.getUserType() + "");
//            int result = stat.executeUpdate();
//            con.commit();
//            if (result > 0) {
//                return true;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//        return false;
//    }
}    
