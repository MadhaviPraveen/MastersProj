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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    public static void main(String args[]) {
	QuestionDTO question = new QuestionDTO();
        question.setQuestion("What is Madhavi's name ?");
        
        List<String> options = new ArrayList<String>();
        options.add("Madhavi");
        options.add("Praveen");
        options.add("Medha");
        
        question.setOptions(options);
        question.setCorrectOption(0);
        
        QuestionService service = new QuestionService();
        //service.insertQuestionOptions(question);
        
	//question.setQuestion("test");
	//insertQuestion(question);
	System.out.println(question);
    }

    public  boolean insertQuestion(Question qsn) {
        Connection con = null;
	try {
            con = DBConnection.getConnection();
            QuestionDAO.setCon(con);
            boolean test = QuestionDAO.insert(qsn);
            con.commit();
            return test;
	} catch (SQLException ex) {
            Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {
		try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return false;
    }

    public  Question getQuestionById(int questionId) {
    	Connection con = null;
        try {
            con = DBConnection.getConnection();
            QuestionDAO.setCon(con);
            return QuestionDAO.getQuestionById(questionId);
	} catch (SQLException ex) {
            Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {				
                try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return null;
    }

    public void createData() {
	Connection con = null;
        try {
            con = DBConnection.getConnection();
            QuestionDAO.setCon(con);
	} catch (SQLException ex) {
            Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {
		try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
    }
	
    public List<Question> getAllQuestions() {
        Connection con = null;
        try {
            con = DBConnection.getConnection();
            QuestionDAO.setCon(con);
            return QuestionDAO.getAllQuestions();
        } catch (SQLException ex) {
            Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
    
    public boolean deleteQuestion(int questionID) {
        Connection con = null;
	try {
            con = DBConnection.getConnection();
            QuestionDAO.setCon(con);
            boolean test = QuestionDAO.delete(questionID);
            con.commit();
            return test;
	} catch (SQLException ex) {
            Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {
		try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return false;
    }
    
    public  boolean insertTestQuestion(TestQuestion tqn) {
        Connection con = null;
	try {
            con = DBConnection.getConnection();
            QuestionDAO.setCon(con);
            boolean test = QuestionDAO.insertTestQuestion(tqn);
            con.commit();
            return test;
	} catch (SQLException ex) {
            Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {
		try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return false;
    }
    
    public  TestQuestion getTestQuestionById(int testID) {
    	Connection con = null;
        try {
            con = DBConnection.getConnection();
            QuestionDAO.setCon(con);
            return QuestionDAO.getTestQuestionById(testID);
	} catch (SQLException ex) {
            Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {				
                try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return null;
    }
    
    public boolean deleteTestQuestion(int testID) {
        Connection con = null;
	try {
            con = DBConnection.getConnection();
            QuestionDAO.setCon(con);
            boolean test = QuestionDAO.deleteTestQuestion(testID);
            con.commit();
            return test;
	} catch (SQLException ex) {
            Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {
		try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return false;
    }
    
    public List<Question> getAllQuestionsByTestID(int testID) {
    Connection con = null;
	try {
            con = DBConnection.getConnection();
            QuestionDAO.setCon(con);
            List<Question> questions = QuestionDAO.getAllQuestionsByTestID(testID);
            con.commit();
            return questions;
	} catch (SQLException ex) {
            Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {
		try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
        return null;
    }
    
    public  boolean insertQuestionOptions(TestDTO qsn) {
        Connection con = null;
	try {
            con = DBConnection.getConnection();
            QuestionDAO.setCon(con);
            boolean test = QuestionDAO.insertQuestionOptions(qsn);
            con.commit();
            return test;
	} catch (SQLException ex) {
            Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {
		try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return false;
    }
    
    
}
