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
public class StudentClassService {
    public static void main(String args[]) {
	StudentClass clas = new StudentClass();
	clas.setClassName("test");
	clas.setYear(5);
	clas.setSemester("test");
	//insertClass(clas);
	System.out.println(clas);
    }

    public boolean insertStudentClass(StudentClass cls) {
        Connection con = null;
	try {
            con = DBConnection.getConnection();
            System.out.println(con);
            StudentClassDAO.setCon(con);
            boolean test = StudentClassDAO.insert(cls);
            con.commit();
            return test;
	} catch (SQLException ex) {
            Logger.getLogger(StudentClassService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {
		try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(StudentClassService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return false;
    }

    public StudentClass getClassById(int classID) {
    	Connection con = null;
        try {
            con = DBConnection.getConnection();
            StudentClassDAO.setCon(con);
            return StudentClassDAO.getClassById(classID);
	} catch (SQLException ex) {
            Logger.getLogger(StudentClassService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {				
                try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(StudentClassService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return null;
    }

    public void createData() {
	Connection con = null;
        try {
            con = DBConnection.getConnection();
            StudentClassDAO.setCon(con);
	} catch (SQLException ex) {
            Logger.getLogger(StudentClassService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {
		try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(StudentClassService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
    }
	
    public List<StudentClass> getAllStudentClass() {
        Connection con = null;
        try {
            con = DBConnection.getConnection();
            StudentClassDAO.setCon(con);
            return StudentClassDAO.getAllStudentClass();
        } catch (SQLException ex) {
            Logger.getLogger(StudentClassService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentClassService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
    
    public boolean deleteStudentClass(int classID) {
        Connection con = null;
	try {
            con = DBConnection.getConnection();
            StudentClassDAO.setCon(con);
            boolean test = StudentClassDAO.deleteStudentClass(classID);
            con.commit();
            return test;
	} catch (SQLException ex) {
            Logger.getLogger(StudentClassService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {
		try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(StudentClassService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return false;
    }
    
    public boolean insertUserClass(UserClasses userClasses) {
        Connection con = null;
	try {
            con = DBConnection.getConnection();
            StudentClassDAO.setCon(con);
            boolean test = StudentClassDAO.insertUserClass(userClasses);
            con.commit();
            return test;
	} catch (SQLException ex) {
            Logger.getLogger(StudentClassService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {
		try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(StudentClassService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return false;
    }
    
    public List<UserClass> getStcSelectionById( int userID) {
    	Connection con = null;
        try {
            con = DBConnection.getConnection();
            StudentClassDAO.setCon(con);
            return StudentClassDAO.ucSelection(userID);
	} catch (SQLException ex) {
            Logger.getLogger(StudentClassService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {				
                try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(StudentClassService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return null;
    }
    
    public boolean deleteUserClass(int userID) {
        Connection con = null;
	try {
            con = DBConnection.getConnection();
            StudentClassDAO.setCon(con);
            boolean test = StudentClassDAO.deleteUserClass(userID);
            con.commit();
            return test;
	} catch (SQLException ex) {
            Logger.getLogger(StudentClassService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {
		try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(StudentClassService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return false;
    }
    public StudentClass getUserById(int userID) {
    	Connection con = null;
        try {
            con = DBConnection.getConnection();
            StudentClassDAO.setCon(con);
            return StudentClassDAO.getUserById(userID);
	} catch (SQLException ex) {
            Logger.getLogger(StudentClassService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {				
                try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(StudentClassService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return null;
    }
    
}
