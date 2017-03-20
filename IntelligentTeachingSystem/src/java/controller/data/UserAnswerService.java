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
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class UserAnswerService {
    
    public static void main(String args[]) {
	//UserAnswer useranswer = new UserAnswer();
//	useranswer.setUserID(1);
//	useranswer.setTestID(1);
//	useranswer.setQuestionID(1);
//	useranswer.setOptionID(1);
	//insertUser(user);
	
        UserSubmission userSubmission = new UserSubmission();
        System.out.println();
        
//        us.setUserId(5);
//        us.setTestId(2);
//        us.setQuestionoptions(questionoptions);
//                
//        List<String> options = new ArrayList<String>();
//        
//        
//        UserAnswerService service = new UserAnswerService();
//        System.out.println(us);
        
    }

    public boolean insertUserAnswer(UserSubmission userSubmission) {
        Connection con = null;
	try {
            con = DBConnection.getConnection();
            System.out.println(con);
            UserAnswerDAO.setCon(con);
            boolean test = UserAnswerDAO.insertUserAnswer(userSubmission);
            con.commit();
            return test;
	} catch (SQLException ex) {
            Logger.getLogger(UserAnswerService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {
		try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(UserAnswerService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return false;
    }

    public UserAnswer getUserAnswerByID(int userID) {
    	Connection con = null;
        try {
            con = DBConnection.getConnection();
            UserAnswerDAO.setCon(con);
            return UserAnswerDAO.getUserAnswerByID(userID);
	} catch (SQLException ex) {
            Logger.getLogger(UserAnswerService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {				
                try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(UserAnswerService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return null;
    }

    public void createData() {
	Connection con = null;
        try {
            con = DBConnection.getConnection();
            UserAnswerDAO.setCon(con);
	} catch (SQLException ex) {
            Logger.getLogger(UserAnswerService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {
		try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(UserAnswerService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
    }
	
    public List<UserAnswer> getAllUserAnswer() {
        Connection con = null;
        try {
            con = DBConnection.getConnection();
            UserAnswerDAO.setCon(con);
            return UserAnswerDAO.getAllUserAnswer();
        } catch (SQLException ex) {
            Logger.getLogger(UserAnswerService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserAnswerService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
    
    public boolean deleteUserAnswer(int userID) {
        Connection con = null;
	try {
            con = DBConnection.getConnection();
            UserAnswerDAO.setCon(con);
            boolean test = UserAnswerDAO.deleteUserAnswer(userID);
            con.commit();
            return test;
	} catch (SQLException ex) {
            Logger.getLogger(UserAnswerService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {
		try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(UserAnswerService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return false;
    }
    
}
