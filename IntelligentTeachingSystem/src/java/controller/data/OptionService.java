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

public class OptionService {
    
        public static void main(String args[]) {
	Option options = new Option();
	options.setText("test");
        options.setCorrectOption(true);
	//insertOptions(options);
	System.out.println(options);
    }

    public  boolean insertOptions(Option ons) {
        Connection con = null;
	try {
            con = DBConnection.getConnection();
            OptionDAO.setCon(con);
            boolean test = OptionDAO.insert(ons);
            con.commit();
            return test;
	} catch (SQLException ex) {
            Logger.getLogger(OptionService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {
		try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(OptionService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return false;
    }

    public  Option getOptionById(int optionId) {
    	Connection con = null;
        try {
            con = DBConnection.getConnection();
            OptionDAO.setCon(con);
            return OptionDAO.getOptionById(optionId);
	} catch (SQLException ex) {
            Logger.getLogger(OptionService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {				
                try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(OptionService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return null;
    }

    public void createData() {
	Connection con = null;
        try {
            con = DBConnection.getConnection();
            OptionDAO.setCon(con);
	} catch (SQLException ex) {
            Logger.getLogger(OptionService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {
		try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(OptionService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
    }
	
    public List<Option> getAllOptions() {
        Connection con = null;
        try {
            con = DBConnection.getConnection();
            OptionDAO.setCon(con);
            return OptionDAO.getAllOptions();
        } catch (SQLException ex) {
            Logger.getLogger(OptionService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OptionService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
    
    public boolean deleteOptions(int optionID) {
        Connection con = null;
	try {
            con = DBConnection.getConnection();
            OptionDAO.setCon(con);
            boolean test = OptionDAO.delete(optionID);
            con.commit();
            return test;
	} catch (SQLException ex) {
            Logger.getLogger(OptionService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {
		try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(OptionService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return false;
    }
    
    public  boolean insertQuestionOptions(QuestionOption qons) {
        Connection con = null;
	try {
            con = DBConnection.getConnection();
            OptionDAO.setCon(con);
            boolean test = OptionDAO.insertQuestionOption(qons);
            con.commit();
            return test;
	} catch (SQLException ex) {
            Logger.getLogger(OptionService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {
		try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(OptionService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return false;
    }
    
    public  QuestionOption getQuestionOptionById(int questionId) {
    	Connection con = null;
        try {
            con = DBConnection.getConnection();
            OptionDAO.setCon(con);
            return OptionDAO.getQuestionOptionById(questionId);
	} catch (SQLException ex) {
            Logger.getLogger(OptionService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {				
                try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(OptionService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return null;
    }
    
    public boolean deleteQuestionOption(int questionID) {
        Connection con = null;
	try {
            con = DBConnection.getConnection();
            OptionDAO.setCon(con);
            boolean test = OptionDAO.deleteQuestionOption(questionID);
            con.commit();
            return test;
	} catch (SQLException ex) {
            Logger.getLogger(OptionService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {
		try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(OptionService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return false;
    }
    
}
