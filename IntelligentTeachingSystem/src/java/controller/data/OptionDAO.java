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
import javax.swing.JOptionPane;

public class OptionDAO {

    private static Connection con = null;
    public static Connection getCon() {
        return con;
    }

    public static void setCon(Connection con) {
        OptionDAO.con = con;
    }
    public static boolean insert(Option opn) {
        if (opn == null) {
            return false;
        }
        System.out.println(opn);
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO Options VALUES(?,?)");
            //ps.setInt(1, qsn.getOptionID());
            ps.setString(1, opn.getText());
            ps.setBoolean(2, opn.isCorrectOption());
            int count = ps.executeUpdate();
            con.commit();
            if (count > 0) {
               return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OptionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;   
    }
    
    public static Option getOptionById(int optionID){
    	if(optionID == 0){
    		return null;
    	}
    	try {
            Statement stat = con.createStatement();
            String queryString = "SELECT * FROM Options WHERE optionID = ?";
            //Create a statement
            PreparedStatement preparedStatement = con.prepareStatement(queryString);
            preparedStatement.setInt(1, optionID);
            ResultSet rset = preparedStatement.executeQuery();
            if(rset.next()){
                Option options = new Option();
                options.setOptionID(rset.getInt(1));
                options.setText(rset.getString(2));
                options.setCorrectOption(rset.getBoolean(3));
                return options;
            }
    	}
    	catch(Exception ex){
            ex.printStackTrace();
    	}
	return null;
    }
    
    public static List<Option> getAllOptions() {
    	try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM Options");
            ArrayList<Option> data = new ArrayList<Option>();
            while (rs.next()) {
            	Option optionDTO = new Option();
            	optionDTO.setOptionID(rs.getInt("optionID"));
            	optionDTO.setText(rs.getString("text"));
                optionDTO.setCorrectOption(rs.getBoolean("correctOption"));
            	data.add(optionDTO);
            	//data.add(new Option(rs.getInt("optionID"), rs.getString("optionName"), rs.getBoolean("correct_Option")));
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(OptionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }return null;
    }
    
    public static boolean delete(int optionID) {
    	if (optionID == 0) {
            return false;
        }
    	try {
            PreparedStatement stat = con.prepareStatement("DELETE FROM Options WHERE OptionID = ?;" );
            stat.setInt(1, optionID);
            int result = stat.executeUpdate();
            con.commit();
            if (result > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OptionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }
    
    public static boolean update(Option opn) {
       if (opn == null) {
            return false;
        }
       	try {
            PreparedStatement stat = con.prepareStatement("UPDATE Options SET text=? and correctOption=? where optionID = ? " );
            stat.setString(1, opn.getText());
            stat.setBoolean(1, opn.isCorrectOption());
            int result = stat.executeUpdate();
            con.commit();
            if (result > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OptionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }
    public static boolean insertQuestionOption(QuestionOption qop) {
        if (qop == null) {
            return false;
        }
        System.out.println(qop);
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO Question_Options VALUES(?,?)");
            ps.setInt(1, qop.getQuestionID());
            ps.setInt(2, qop.getOptionID());
            int count = ps.executeUpdate();
            con.commit();
            if (count > 0) {
               return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OptionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static QuestionOption getQuestionOptionById(int questionID){
    	if(questionID == 0){
    		return null;
    	}
    	try {
            Statement stat = con.createStatement();
            String queryString = "SELECT O.* FROM Options O JOIN Question_Options QO ON O.optionID = QO.optionID WHERE QO.questionID = ?";
            //Create a statement
            PreparedStatement preparedStatement = con.prepareStatement(queryString);
            preparedStatement.setInt(1, questionID);
            ResultSet rset = preparedStatement.executeQuery();
            if(rset.next()){
                QuestionOption questionoption = new QuestionOption();
                questionoption.setQuestionID(rset.getInt(1));
                questionoption.setOptionID(rset.getInt(2));
                return questionoption;
            }
    	}
    	catch(Exception ex){
            ex.printStackTrace();
    	}
	return null;
    }
    
    public static boolean deleteQuestionOption(int questionID) {
    	if (questionID == 0) {
            return false;
        }
    	try {
            PreparedStatement stat = con.prepareStatement("DELETE FROM Question_Options WHERE QuestionID = ?;" );
            stat.setInt(1, questionID);
            int result = stat.executeUpdate();
            con.commit();
            if (result > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OptionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }
    
}
    
