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

public class UserDAO {
    private static Connection con = null;
    
    public static Connection getCon() {
        return con;
    }
    
    public static void setCon(Connection con) {
        UserDAO.con = con;
    }
    
    public static boolean insert(User usr) {
        if (usr == null) {
            return false;
        }
        try {
            PreparedStatement ps = con.prepareStatement(
                    "insert into User values( ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, usr.getUserID());
            ps.setString(2, usr.getFname());
            ps.setString(3, usr.getLname());
            ps.setString(4, usr.getUserName());
            ps.setString(5, usr.getPassword());
            ps.setString(6, usr.getUserType());
            int count = ps.executeUpdate();
            con.commit();
            if (count > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;         
    }
    
    public static User loginCredentials(LoginDTO loginDTO){
    	if(loginDTO == null || loginDTO.getPassword() == null){
            return null;
    	}
    	try {
            Statement stat = con.createStatement();
            String queryString = "select * from User where Username =? and password = ?";
            //Create a statement
            PreparedStatement preparedStatement = con.prepareStatement(queryString);
            preparedStatement.setString(1, loginDTO.getUserId());
            preparedStatement.setString(2, loginDTO.getPassword());
            ResultSet rset = preparedStatement.executeQuery();
            if(rset.next()){
    		User user = new User();
                user.setUserID(rset.getInt(1));
                user.setFname(rset.getString(2));
    		user.setLname(rset.getString(3));
    		user.setUserName(rset.getString(4));
    		user.setPassword(rset.getString(5));
    		user.setUserType(rset.getString(6));
    		return user;
            }
    	}
    	catch(Exception ex){
            ex.printStackTrace();
    	}
	return null;
    }
    
    public static List<User> getAllUser() {
    	try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("select * from User");
            ArrayList<User> data = new ArrayList<User>();
            while (rs.next()) {
            	User userDTO = new User();
            	userDTO.setUserID(rs.getInt("userID"));
            	userDTO.setFname(rs.getString("fname"));
            	userDTO.setLname(rs.getString("lname"));
            	userDTO.setUserName(rs.getString("username"));
            	userDTO.setPassword(rs.getString("password"));
            	userDTO.setUserType(rs.getString("userType"));
            	data.add(userDTO);
            	//data.add(new User(rs.getInt("userid"), rs.getString("fname"), rs.getString("lname"), rs.getString("username"), rs.getString("password"), rs.getString("usertype")));
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }return null;
    }
    
    public static boolean delete(int UserID) {
    	if (UserID <= 0) {
            return false;
        }
    	try {
            PreparedStatement stat = con.prepareStatement("DELETE FROM user where UserID = ?" );
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
    
    public static boolean update(User usr) {
       if (usr == null) {
            return false;
        }
       	try {
            PreparedStatement stat = con.prepareStatement("update User set fname=?, lname=?, username=?, password=?, userType=? where userID = ?");
            //stat.setInt(1, usr.getUserID());
            stat.setString(1, usr.getFname());
            stat.setString(2, usr.getLname());
            stat.setString(3, usr.getUserName());
            stat.setString(4, usr.getPassword());
            stat.setString(5, usr.getUserType() + "");
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
}    
