package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import controller.data.*;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("apis")
public class DataController {

        @Autowired
        StudentClassService studentClassService;
        
        @Autowired
        OptionService optionsService;
        
        @Autowired
        QuestionService questionService;
        
        @Autowired
        UserAnswerService userAnswerService;
        
        @Autowired
        TestService testService;
        
        @Autowired
        UserService userService;
        
            
        @RequestMapping(value="{name}", method = RequestMethod.GET)
	public @ResponseBody Shop getShopInJSON(@PathVariable String name) {
            Shop shop = new Shop();
            shop.setName(name);
            shop.setStaffName(new String[]{"mkyong1", "mkyong2"});
            return shop;
	}
        
//Class        
        @RequestMapping(value = "class", method = RequestMethod.PUT, consumes = "application/json")
        public @ResponseBody  boolean insertStudentClass(@RequestBody StudentClass cls) {
            return studentClassService.insertStudentClass(cls);
        }
        
        @RequestMapping(value = "class/id/{classId}", method = RequestMethod.GET)
        public @ResponseBody StudentClass getClassById(@PathVariable int classId) {
            return studentClassService.getClassById(classId);
        }
        
        @RequestMapping(value = "allClass", method = RequestMethod.GET)
        public @ResponseBody List<StudentClass> getAllClass() {
            return studentClassService.getAllStudentClass();
        } 
        
        //insertUserClass(UserClass uc)
        @RequestMapping(value = "userclass", method = RequestMethod.PUT, consumes = "application/json")
        public @ResponseBody  boolean insertUserClass(@RequestBody UserClasses userClasses) {
            return studentClassService.insertUserClass(userClasses);
        }
        
        //UserClass getStcSelectionById( int userID)
        @RequestMapping(value = "userclass/user/{userId}", method = RequestMethod.GET)
        public @ResponseBody List<UserClass> getStcSelectionById(@PathVariable int userId) {
            return studentClassService.getStcSelectionById(userId);
        }
        
        //deleteUserClass(int userID)
        @RequestMapping(value = "alluserclass", method = RequestMethod.GET)
        public @ResponseBody boolean deleteUserClass(@PathVariable int userId) {
            return studentClassService.deleteUserClass(userId);
        }
        
//        //get class by userId
//        @RequestMapping(value = "class/id/{userId}", method = RequestMethod.GET)
//        public @ResponseBody StudentClass getUserById(@PathVariable int userId) {
//            return studentClassService.getUserById(userId);
//        }
        
//Question        
        @RequestMapping(value = "question", method = RequestMethod.PUT, consumes = "application/json")
        public @ResponseBody  boolean insertOptions(@RequestBody Question qsn) {
            return questionService.insertQuestion(qsn);
        }
        
        @RequestMapping(value = "question/id/{questionId}", method = RequestMethod.GET)
        public @ResponseBody Question getQuestionById(@PathVariable int questionId) {
            return questionService.getQuestionById(questionId);
        }
        
        @RequestMapping(value = "allQuestions", method = RequestMethod.GET)
        public @ResponseBody List<Question> getAllQuestions() {
            return questionService.getAllQuestions();
        }
//QuestionOptions        
        @RequestMapping(value = "questionOptions", method = RequestMethod.PUT, consumes = "application/json")
        public @ResponseBody  boolean insertQuestionOptions(@RequestBody TestDTO qsn) {
            return questionService.insertQuestionOptions(qsn);
        }
//Option        
        @RequestMapping(value = "option", method = RequestMethod.PUT, consumes = "application/json")
        public @ResponseBody  boolean insertOptions(@RequestBody Option ons) {
            return optionsService.insertOptions(ons);
        }
        
        @RequestMapping(value = "options/id/{optionId}", method = RequestMethod.GET)
        public @ResponseBody Option getOptionsById(@PathVariable int optionID) {
            return optionsService.getOptionById(optionID);
        }
        
        @RequestMapping(value = "allOptions", method = RequestMethod.GET)
        public @ResponseBody List<Option> getAllOptions() {
            return optionsService.getAllOptions();
        } 
                
//Test        
        @RequestMapping(value = "test", method = RequestMethod.PUT, consumes = "application/json")
        public @ResponseBody  boolean insertTest(@RequestBody Test tst) {
            return testService.insertTest(tst);
        }
        
        @RequestMapping(value = "test/id/{testID}", method = RequestMethod.GET)
        public @ResponseBody Test getTestById(@PathVariable int testID) {
            return testService.getTestByID(testID);
        }
        
        @RequestMapping(value = "allTests", method = RequestMethod.GET)
        public @ResponseBody List<Test> getAllTest() {
            return testService.getAllTest();
        }
        
        //insertClassTest(ClassTest ct)
        @RequestMapping(value = "classtest", method = RequestMethod.PUT, consumes = "application/json")
        public @ResponseBody  boolean insertClassTest(@RequestBody ClassTest ct) {
            return testService.insertClassTest(ct);
        }
        //ClassTest getCTSelectionById(int classID, int testID)
        @RequestMapping(value = "classtest/class/{classID}/userId/{userId}", method = RequestMethod.GET)
        public @ResponseBody List<ClassTest> getCTSelectionById(@PathVariable int classID, @PathVariable int userId) {
            return testService.getCTSelectionById(classID, userId);
        }
        //boolean deleteClassTest(int classID)
        @RequestMapping(value = "deleteClassTest", method = RequestMethod.GET)
        public @ResponseBody boolean deleteClassTest(@PathVariable int classID){
            return testService.deleteClassTest(classID);
        }       
        
        //boolean insertUserTest(UserTest ut)
        @RequestMapping(value = "usertest", method = RequestMethod.PUT, consumes = "application/json")
        public @ResponseBody boolean insertUserTest(@RequestBody UserTest ut) {
            return testService.insertUserTest(ut);
        }
        //public UserTest getUserTestByID(int userID) {
        @RequestMapping(value = "userstest/id/{userID}", method = RequestMethod.GET)
        public @ResponseBody UserTest getUserTestByID(@PathVariable int userID){
            return testService.getUserTestByID(userID);
        }
        //getUserPendingTestByID
        @RequestMapping(value = "userpendingtest/id/{userID}", method = RequestMethod.GET)
        public @ResponseBody UserTest getUserPendingTestByID(@PathVariable int userID){
            return testService.getUserPendingTestByID(userID);
        }
        //Evaluation getEvaluationByID(int testID, int userID)
        @RequestMapping(value = "evaluation/userID/{userID}/testID/{testID}", method = RequestMethod.GET)
        public @ResponseBody Evaluation getEvaluationByID(@PathVariable int userID, @PathVariable int testID){
            return testService.getEvaluationByID(userID, testID);
        }
        //boolean deleteUserTest(int userID)
        @RequestMapping(value = "deleteUserTest", method = RequestMethod.GET)
        public @ResponseBody boolean deleteUserTest(@PathVariable int userID){
            return testService.deleteUserTest(userID);
        }
        
//User   
        @RequestMapping(value = "user", method = RequestMethod.PUT, consumes = "application/json")
        public @ResponseBody  boolean insertUser(@RequestBody User usr) {
            return userService.insertUser(usr);
        }
        
        @RequestMapping(value = "user", method = RequestMethod.POST, consumes = "application/json")
        public @ResponseBody UserDTO loginCredentials(@RequestBody LoginDTO login, HttpServletResponse resp) {
            User user = userService.loginCredentials(login);
            if (resp != null ) {
                if (user == null) {
                    resp.setStatus(404);
                } else {
                    resp.setStatus(200);
                }
            }
            return new UserDTO(user);
        }
        
        @RequestMapping(value = "allUsers", method = RequestMethod.GET)
        public @ResponseBody List<User> getAllUser() {
            return userService.getAllUser();
        }
        
//UserAnswer        
        @RequestMapping(value = "userAnswer", method = RequestMethod.PUT, consumes = "application/json")
        public @ResponseBody  boolean insertUserAnswer(@RequestBody UserSubmission userSubmission){
            return userAnswerService.insertUserAnswer(userSubmission);
        }
        
        @RequestMapping(value = "useranswer/id/{userId}", method = RequestMethod.GET)
        public @ResponseBody UserAnswer getUserAnswerByID(@PathVariable int userID) {
            return userAnswerService.getUserAnswerByID(userID);
        }        
        @RequestMapping(value = "allUserAnswer", method = RequestMethod.GET)
        public @ResponseBody List<UserAnswer> getAllUserAnswer() {
            return userAnswerService.getAllUserAnswer();
        }
        @RequestMapping(value = "questions/testId/{testID}", method = RequestMethod.GET)
        public @ResponseBody List<Question> getAllQuestionsByTestID(@PathVariable int testID) {
            return questionService.getAllQuestionsByTestID(testID);
        }
        
}