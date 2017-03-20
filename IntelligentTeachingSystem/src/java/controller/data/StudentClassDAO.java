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
import javax.swing.JOptionPane;

public class StudentClassDAO {
    private static Connection con = null;
    public static Connection getCon() {
        return con;
    }

    public static void setCon(Connection con) {
        StudentClassDAO.con = con;
    }
    public static boolean insert(StudentClass cls) {
        if (cls == null) {
            return false;
        }
        try {
            PreparedStatement ps = con.prepareStatement("insert into Class(classID, className, year, semester) values(null, ?, ?, ?)");
        
            ps.setString(1, cls.getClassName());
            ps.setInt(2, cls.getYear());
            ps.setString(3, cls.getSemester());
            int count = ps.executeUpdate();
            con.commit();
            if (count > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;         
        
    }
    
    public static StudentClass getClassById(int classID){
    	if(classID == 0){
    		return null;
    	}
    	try {
    		Statement stat = con.createStatement();
    		String queryString = "SELECT * FROM Class WHERE classID =?";
    		//Create a statement
    		PreparedStatement preparedStatement = con.prepareStatement(queryString);
    		preparedStatement.setInt(1, classID);
    		ResultSet rset = preparedStatement.executeQuery();
    		if(rset.next()){
                    StudentClass studentclass = new StudentClass();
                    studentclass.setClassID(rset.getInt(1));
                    studentclass.setClassName(rset.getString(2));
                    studentclass.setYear(rset.getInt(3));
                    studentclass.setSemester(rset.getString(4));
                    return studentclass;
    		}
        }
    	catch(Exception ex){
            ex.printStackTrace();
    	}
	return null;
    }
    
    public static List<StudentClass> getAllStudentClass() {
    	try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM Class");
            ArrayList<StudentClass> data = new ArrayList<StudentClass>();
            while (rs.next()) {
            	StudentClass classDTO = new StudentClass();
            	classDTO.setClassID(rs.getInt("classID"));
            	classDTO.setClassName(rs.getString("classname"));
            	classDTO.setYear(rs.getInt("year"));
            	classDTO.setSemester(rs.getString("semester"));
            	data.add(classDTO);
            	//data.add(new StudentClass(rs.getInt("classID"), rs.getString("className"), rs.getInt("year"), rs.getString("semster")));
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(StudentClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }return null;
    }
    
    public static boolean deleteStudentClass(int classID) {
    	if (classID == 0) {
            return false;
        }
    	try {
            PreparedStatement stat = con.prepareStatement("DELETE FROM Class WHERE classID = ? " );
            stat.setInt(1, classID);
            int result = stat.executeUpdate();
            con.commit();
            if (result > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }
    
    public static boolean update(StudentClass cls) {
       if (cls == null) {
            return false;
        }
       	try {
            PreparedStatement stat = con.prepareStatement("UPDATE Class SET className=?, year=?, semester=? WHERE classID = ?" );
            stat.setString(1, cls.getClassName());
            stat.setInt(2, cls.getYear());
            stat.setString(3, cls.getSemester());
            int result = stat.executeUpdate();
            con.commit();
            if (result > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }
    
    public static boolean insertUserClass(UserClasses userClasses) {
        if (userClasses == null) {
            return false;
        }
        System.out.println(userClasses);
        try {
            int success = -1;
            for(String classId: userClasses.getClassIds()){
                String SQL = "insert into ITS.user_class values(?,?);";
                PreparedStatement ps = con.prepareStatement(SQL);
                ps.setInt(1, userClasses.getUserId());
                ps.setString(2, classId);
                success = ps.executeUpdate();
            }
            if(success > 0){
                return true;
            }
            else return false;
        } catch (SQLException   ex) {
            Logger.getLogger(UserAnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;         
    }
    
    public static List<UserClass> ucSelection(int userID){
    	if(userID == 0 ){
            return null;
    	}
    	try {
            PreparedStatement stat = con.prepareStatement("SELECT C.* FROM Class C JOIN User_Class UC ON C.classID = UC.classID where uc.userID = ?");
            stat.setInt(1, userID);
            ResultSet rs = stat.executeQuery();
            List<UserClass> data = new ArrayList<UserClass>();
            while (rs.next()) {
            	UserClass classDTO = new UserClass();
            	classDTO.setClassID(rs.getInt("classId"));
                classDTO.setUserID(userID);
            	classDTO.setClassName(rs.getString("classname"));
            	classDTO.setYear(rs.getInt("year"));
            	classDTO.setSemester(rs.getString("semester"));
                System.out.println(classDTO);
            	data.add(classDTO);
            	//data.add(new StudentClass(rs.getInt("classID"), rs.getString("className"), rs.getInt("year"), rs.getString("semster")));
            }
            return data;
            }
    	catch(Exception ex){
            ex.printStackTrace();
    	}
	return null;
    }
        
        public static boolean deleteUserClass(int userID) {
    	if (userID == 0) {
            return false;
        }
    	try {
            PreparedStatement stat = con.prepareStatement("DELETE FROM user_Class WHERE userID = ?;" );
            stat.setInt(1, userID);
            int result = stat.executeUpdate();
            con.commit();
            if (result > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }

    public static StudentClass getUserById(int userID){
    	if(userID == 0){
    		return null;
    	}
    	try {
    		Statement stat = con.createStatement();
    		String queryString = "SELECT * FROM ITS.user_class WHERE userID=?";
    		//Create a statement
    		PreparedStatement preparedStatement = con.prepareStatement(queryString);
    		preparedStatement.setInt(1, userID);
    		ResultSet rset = preparedStatement.executeQuery();
    		if(rset.next()){
                    StudentClass studentclass = new StudentClass();
                    studentclass.setClassID(rset.getInt(1));
                    studentclass.setClassName(rset.getString(2));
                    studentclass.setYear(rset.getInt(3));
                    studentclass.setSemester(rset.getString(4));
                    return studentclass;
    		}
        }
    	catch(Exception ex){
            ex.printStackTrace();
    	}
	return null;
    }
}