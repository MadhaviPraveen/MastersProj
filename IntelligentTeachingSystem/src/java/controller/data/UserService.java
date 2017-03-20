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
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public static void main(String args[]) {
	User user = new User();
	user.setFname("test");
	user.setLname("test");
	user.setUserName("test");
	user.setPassword("test");
	user.setUserType("Admin");
	//insertUser(user);
	System.out.println(user);
    }

    public boolean insertUser(User usr) {
        Connection con = null;
	try {
            con = DBConnection.getConnection();
            System.out.println(con);
            UserDAO.setCon(con);
            boolean test = UserDAO.insert(usr);
            con.commit();
            return test;
	} catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {
		try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return false;
    }

    public User loginCredentials(LoginDTO login) {
    	Connection con = null;
        try {
            con = DBConnection.getConnection();
            UserDAO.setCon(con);
            return UserDAO.loginCredentials(login);
	} catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {				
                try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return null;
    }

    public void createData() {
	Connection con = null;
        try {
            con = DBConnection.getConnection();
            UserDAO.setCon(con);
	} catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {
		try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
    }
	
    public List<User> getAllUser() {
        Connection con = null;
        try {
            con = DBConnection.getConnection();
            UserDAO.setCon(con);
            return UserDAO.getAllUser();
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
    
    public boolean deleteUser(int userID) {
        Connection con = null;
	try {
            con = DBConnection.getConnection();
            UserDAO.setCon(con);
            boolean test = UserDAO.delete(userID);
            con.commit();
            return test;
	} catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {
		try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return false;
    }
    
}
