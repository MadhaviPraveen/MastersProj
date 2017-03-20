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

public class QuestionDAO {
    private static Connection con = null;
    public static Connection getCon() {
        return con;
    }

    public static void setCon(Connection con) {
        QuestionDAO.con = con;
    }
        public static boolean insert(Question qsn) {
            if (qsn == null) {
                return false;
            }        
            System.out.println(qsn);
            try {
                PreparedStatement ps = con.prepareStatement("INSERT INTO Question(question) VALUES (?)");
                //ps.setString(1, qsn.getQuestionID());
                ps.setString(1, qsn.getQuestion());
                //ps.setArray(2, qsn.getOptions());
                int count = ps.executeUpdate();
                con.commit();
                if (count > 0) {
                   return true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;         
        }
    
    public static Question getQuestionById(int questionId){
    	if(questionId == 0){
    		return null;
    	}
    	try {
            Statement stat = con.createStatement();
            String queryString = "SELECT * FROM Question WHERE QuestionId =?";
            //Create a statement
            PreparedStatement preparedStatement = con.prepareStatement(queryString);
            preparedStatement.setInt(1, questionId);
            ResultSet rset = preparedStatement.executeQuery();
            if(rset.next()){
                Question question = new Question();
                question.setQuestionID(rset.getInt(1));
                question.setQuestion(rset.getString(2));
                return question;
            }
    	}
    	catch(Exception ex){
            ex.printStackTrace();
    	}
	return null;
    }
    
    public static List<Question> getAllQuestions() {
    	try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("select * from Question");
            ArrayList<Question> data = new ArrayList<Question>();
            while (rs.next()) {
            	Question questionDTO = new Question();
            	questionDTO.setQuestionID(rs.getInt("QuestionID"));
            	questionDTO.setQuestion(rs.getString("questionName"));
            	data.add(questionDTO);
            	//data.add(new Question(rs.getInt("QuestionID"), rs.getString("questionName")));
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }return null;
    }
    
    public static boolean delete(int questionID) {
    	if (questionID == 0) {
            return false;
        }
    	try {
            PreparedStatement stat = con.prepareStatement("DELETE FROM Question WHERE QuestionID = ?" );
            stat.setInt(1, questionID);
            int result = stat.executeUpdate();
            con.commit();
            if (result > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }
    
    public static boolean update(Question qsn) {
       if (qsn == null) {
            return false;
        }
       	try {
            PreparedStatement stat = con.prepareStatement("UPDATE Question SET Question=? where questionID = ? " );
            stat.setString(1, qsn.getQuestion());
            int result = stat.executeUpdate();
            con.commit();
            if (result > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }
    
    public static boolean insertTestQuestion(TestQuestion tqn) {
        if (tqn == null) {
            return false;
        }
        
        System.out.println(tqn);
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO Test_Question VALUES(?,?);");
            ps.setInt(1, tqn.getTestID());
            ps.setInt(2, tqn.getQuestionID());
            int count = ps.executeUpdate();
            con.commit();
            if (count > 0) {
               return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static TestQuestion getTestQuestionById(int testID){
    	if(testID == 0){
    		return null;
    	}
    	try {
            Statement stat = con.createStatement();
            String queryString = "SELECT Q.* FROM Question Q JOIN Test_Question TQ ON Q.questionID = TQ.questionID WHERE TQ.testID = ?";
            //Create a statement
            PreparedStatement preparedStatement = con.prepareStatement(queryString);
            preparedStatement.setInt(1, testID);
            ResultSet rset = preparedStatement.executeQuery();
            if(rset.next()){
                TestQuestion testquestion = new TestQuestion();
                testquestion.setTestID(rset.getInt(1));
                testquestion.setQuestionID(rset.getInt(2));
                return testquestion;
            }
    	}
    	catch(Exception ex){
            ex.printStackTrace();
    	}
	return null;
    }
    
    public static boolean deleteTestQuestion(int testID) {
    	if (testID == 0) {
            return false;
        }
    	try {
            PreparedStatement stat = con.prepareStatement("DELETE FROM Test_Question WHERE QuestionID = ?" );
            stat.setInt(1, testID);
            int result = stat.executeUpdate();
            con.commit();
            if (result > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }
    
    public static List<Question> getAllQuestionsByTestID(int testID) {
    	try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT Q.*, O.optionID, O.text FROM TEST_QUESTION TQ JOIN QUESTION Q ON TQ.questionID=Q.questionID\n" +
"                                                                            JOIN Question_Options QO ON Q.questionID = QO.questionID\n" +
"                                                                            JOIN OPTIONS O ON QO.OptionID = O.OptionID  "
                    + "where testId = " + testID + " GROUP BY questionID, optionID");
            ArrayList<Question> questions = new ArrayList<Question>();
            int questionId = 0;
            List<OptionDTO> options = null;
            while (rs.next()) {
            	
                int qId = rs.getInt("QuestionID");
                 Question questionDTO = null;
                if (questionId != qId) {
                    questionDTO = new Question();
                    questionDTO.setQuestionID(qId);
                    questionDTO.setQuestion(rs.getString("question"));
                    questions.add(questionDTO);
                    options = new ArrayList<>();
                } else {
                    questionDTO = questions.get(questions.size() - 1);
                    options = questionDTO.getOptions();
                } 
                
                questionId = qId;
                //questionDTO.setOptions((List<OptionsDTO>) rs.getArray("Options"));
            	
                OptionDTO optionsdto = new OptionDTO();
                optionsdto.setText(rs.getString("text"));
                optionsdto.setOptionId(rs.getInt("optionId"));
            	options.add(optionsdto);
                questionDTO.setOptions(options);
                
                
            	//data.add(new Question(rs.getInt("QuestionID"), rs.getString("questionName")));
            }
            return questions;
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }return null;
    }
    
    public static boolean insertQuestionOptions(TestDTO tst) {
        if (tst == null) {
            return false;
        }        
        System.out.println(tst);
        try {
            String insertTest = "insert into Test(testName) values(?)";
            PreparedStatement ps = con.prepareStatement(insertTest);
            ps.setString(1, tst.getTest());
            int success = ps.executeUpdate();
            con.commit();
            
            String selectquery1 = "SELECT MAX(testId) FROM ITS.Test WHERE testName= ? ";
            ps = con.prepareStatement(selectquery1);
            ps.setString(1, tst.getTest());
            ResultSet rs = ps.executeQuery();
            int testId = 0;
            
            if (rs.next()) {
                testId = rs.getInt(1);
            }
            
            System.out.println("testId got is " + testId + " for testName : " + tst.getTest());
            List<QuestionDTO> questions = tst.getQuestions();
            if (questions == null || questions.isEmpty()) {
                System.out.println("Questions are empty");
                return false;
            }
            
            for (QuestionDTO question : questions){
                String insertString1 = "INSERT INTO Question(question) VALUES (?)";
                ps = con.prepareStatement(insertString1);
                ps.setString(1, question.getQuestion());
                success = ps.executeUpdate();
                con.commit();
            
                 System.out.println("inserting question Question " + question.getQuestion());
            
                selectquery1 = "SELECT MAX(QuestionID) FROM ITS.Question WHERE question= ? ";
                ps = con.prepareStatement(selectquery1);
                ps.setString(1, question.getQuestion());
                rs = ps.executeQuery();
                int questionId = 0;
            
                if (rs.next()) {
                    questionId = rs.getInt(1);
                }
            
                String test_question1 = "insert into test_question(testID, questionID) values (?,?)";
                ps = con.prepareStatement(test_question1);
                ps.setInt(1, testId);
                ps.setInt(2, questionId);
                ps.executeUpdate();
                System.out.println("testId : " + testId + " questionId : " + questionId);
                con.commit();
            
                int count = 0;
                for(String option: question.getOptions()){
                //pst.setArray(2, qsn.getOptions());
                    String insertString2 = "INSERT INTO Options(text, correct_Option) VALUES (?,?)";
                    PreparedStatement pst = con.prepareStatement(insertString2);
                    pst.setString(1, option);
                    if (count == question.getCorrectOption()) {
                        pst.setBoolean(2, true);
                    } else {
                        pst.setBoolean(2, false);
                    }
                
                    pst.executeUpdate();
                    con.commit();
                    count++;
                
                    String selectquery2 = "SELECT MAX(OptionID) FROM Options WHERE text = ? ";
                
                    ps = con.prepareStatement(selectquery2);
                    ps.setString(1, option);
                    rs = ps.executeQuery();
                    int optionId = 0;
                
                    if (rs.next()) {
                        optionId = rs.getInt(1);
                    }
                    String insertQuestionOption = "INSERT INTO ITS.Question_Options(QuestionId, OptionID) value (?, ?)";
                    ps = con.prepareStatement(insertQuestionOption);
                    ps.setInt(1, questionId);
                    ps.setInt(2, optionId);
                    ps.executeUpdate();
                    con.commit();
                }            
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;         
    }
    
    
}
    
