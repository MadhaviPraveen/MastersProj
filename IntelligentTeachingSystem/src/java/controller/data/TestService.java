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
public class TestService {

    public static void main(String args[]) {
        Connection con = null;
	try {
            con = DBConnection.getConnection();
            TestDAO.setCon(con);
        
	//Evaluation evaluation = new Evaluation();
//	evaluation.setTestID(2);
//        evaluation.setUserID(1);
//        evaluation.setCorrectAnswers();
//        evaluation.setTotalQuestions(5);
        //getEvaluationByID(1,2);
//            TestDAO.getCTSelectionById(1);
//            ClassTest classtest = new ClassTest();
//            classtest.getClassID();
//            classtest.getTestID();
//       
//            System.out.println(classtest);
        } catch (SQLException ex) {
            Logger.getLogger(TestService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {
		try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(TestService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
                
    }

    public boolean insertTest(Test tst) {
        Connection con = null;
	try {
            con = DBConnection.getConnection();
            TestDAO.setCon(con);
            boolean test = TestDAO.insertTest(tst);
            con.commit();
            return test;
	} catch (SQLException ex) {
            Logger.getLogger(TestService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {
		try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(TestService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return false;
    }

    public Test getTestByID(int testID) {
    	Connection con = null;
        try {
            con = DBConnection.getConnection();
            TestDAO.setCon(con);
            return TestDAO.getTestByID(testID);
	} catch (SQLException ex) {
            Logger.getLogger(TestService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {				
                try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(TestService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return null;
    }

    public void createData() {
	Connection con = null;
        try {
            con = DBConnection.getConnection();
            TestDAO.setCon(con);
	} catch (SQLException ex) {
            Logger.getLogger(TestService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {
		try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(TestService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
    }
	
    public  List<Test> getAllTest() {
        Connection con = null;
        try {
            con = DBConnection.getConnection();
            TestDAO.setCon(con);
            return TestDAO.getAllTest();
        } catch (SQLException ex) {
            Logger.getLogger(TestService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TestService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
    
    public boolean deleteTest(int testID) {
        Connection con = null;
	try {
            con = DBConnection.getConnection();
            TestDAO.setCon(con);
            boolean test = TestDAO.delete(testID);
            con.commit();
            return test;
	} catch (SQLException ex) {
            Logger.getLogger(TestService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {
		try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(TestService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return false;
    }
    
    public boolean insertClassTest(ClassTest ct) {
        Connection con = null;
	try {
            con = DBConnection.getConnection();
            TestDAO.setCon(con);
            boolean test = TestDAO.insertClassTest(ct);
            con.commit();
            return test;
	} catch (SQLException ex) {
            Logger.getLogger(TestService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {
		try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(TestService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return false;
    }
    
    public List<ClassTest> getCTSelectionById(int classID, int userId) {
    	Connection con = null;
        try {
            con = DBConnection.getConnection();
            TestDAO.setCon(con);
            return TestDAO.getCTSelectionById(classID, userId);
	} catch (SQLException ex) {
            Logger.getLogger(TestService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {				
                try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(TestService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return null;
    }
    
    public boolean deleteClassTest(int classID) {
        Connection con = null;
	try {
            con = DBConnection.getConnection();
            TestDAO.setCon(con);
            boolean test = TestDAO.deleteClassTest(classID);
            con.commit();
            return test;
	} catch (SQLException ex) {
            Logger.getLogger(TestService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {
		try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(TestService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return false;
    }
    
    public boolean insertUserTest(UserTest ut) {
        Connection con = null;
	try {
            con = DBConnection.getConnection();
            TestDAO.setCon(con);
            boolean test = TestDAO.insertUserTest(ut);
            con.commit();
            return test;
	} catch (SQLException ex) {
            Logger.getLogger(TestService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {
		try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(TestService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return false;
    }
    
    public UserTest getUserTestByID(int userID) {
    	Connection con = null;
        try {
            con = DBConnection.getConnection();
            TestDAO.setCon(con);
            return TestDAO.getUserTestByID(userID);
	} catch (SQLException ex) {
            Logger.getLogger(TestService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {				
                try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(TestService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return null;
    }
    
    
    public UserTest getUserPendingTestByID(int userID) {
    	Connection con = null;
        try {
            con = DBConnection.getConnection();
            TestDAO.setCon(con);
            return TestDAO.getUserPendingTestByID(userID);
	} catch (SQLException ex) {
            Logger.getLogger(TestService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {				
                try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(TestService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return null;
    }
    
    //Evaluation getEvaluationByID(int testID, int userID)
    public Evaluation getEvaluationByID(int userID, int testID) {
    	Connection con = null;
        try {
            con = DBConnection.getConnection();
            TestDAO.setCon(con);
            return TestDAO.getEvaluationByID(testID, userID);
	} catch (SQLException ex) {
            Logger.getLogger(TestService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {				
                try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(TestService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return null;
    }
        
    public boolean deleteUserTest(int userID) {
        Connection con = null;
	try {
            con = DBConnection.getConnection();
            TestDAO.setCon(con);
            boolean test = TestDAO.deleteUserTest(userID);
            con.commit();
            return test;
	} catch (SQLException ex) {
            Logger.getLogger(TestService.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
            if (con != null) {
		try {
                    con.close();
		} catch (SQLException ex) {
                    Logger.getLogger(TestService.class.getName()).log(Level.SEVERE, null, ex);
		}
            }
	}
	return false;
    }
}
