/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function getScoresForTestId(testID, userID){
    $.ajax({
            type: "GET",
            url: "http://localhost:32340/ITS/apis/evaluation/userID/" + userID + "/testID/" + testID,
            contentType: "application/json",
            error : function(data) {doScoreDisplay(data);},
            success : function(dataFromServer) {
                doScoreDisplay(dataFromServer);
            },
            dataType : "application/json"
    });
}    
    
function doScoreDisplay(data){
    var resp = eval("(" + data['responseText'] + ')');
    var ca = resp.correctAnswers;
    var tq = resp.totalQuestions;
    var rightDiv = $("#right-div");
    $("#dataDiv").html("");
    var correctAnswersDiv = $("<div> Number of correct answers: " + ca + " </div>");
    $("#dataDiv").append(correctAnswersDiv);
    var totalQuestionsDiv = $("<div> Total Number of Questions: " + tq + " </div>");
    $("#dataDiv").append(totalQuestionsDiv);
}





function onQuestionPaperSubmit(){
    checkTestPaperAnswers();
} 
   
function checkTestPaperAnswers(){
    var questionHolders = $("#dataDiv").find("div[questionHolder=questionHolder]");
    var dataToBackEnd = {};
    dataToBackEnd.testId = testID;
    dataToBackEnd.userId = userData.userID;
    dataToBackEnd.questionOptions = [];
    for (var i = 0; i < questionHolders.length; i ++) {
        if (questionHolders[i] == null) {
            continue;
        }
        
        var question = $(questionHolders[i]).find("div[question = question]");
        var option = $(questionHolders[i]).find("input[option=option]:checked");
        
        if (option == null) {
            continue;
        }
        
        var questionOption = {};
        questionOption.question = $(question).attr("id");
        questionOption.option = $(option).val();
        dataToBackEnd.questionOptions.push(questionOption);
    }
    
   //dataToBackEnd = dataToBackEnd;
    
    $.ajax({
        type: "PUT",
        url: "http://localhost:32340/ITS/apis/userAnswer",
        dataType: 'text',
        contentType: "application/json",
        data : JSON.stringify(dataToBackEnd),
        error : function(err) {
            $("#test").html("");
            $("#test").append("<div style='text-align: left;padding-left: 15%;font-weight: bold;color: #fff;'>Test submitted successfully.</div>");
            getScoresForTestId(testID, userData.userID);
        },
        success : function(dataFromServer) {
            $("#test").html("");
            $("#test").append("<div>Test submitted successfully.</div>");
            getScoresForTestId(testID, userData.userID);
        },
        dataType : "application/json"
     });
}

function showTestPaper(testID) {
    $.ajax({
            type: "GET",
            url: "http://localhost:32340/ITS/apis/questions/testId/" + testID,
            contentType: "application/json",
            error : function(err) {doTestPaperDisplay(err, testID);},
            success : function(dataFromServer) {
                doTestPaperDisplay(dataFromServer, testID);
            },
            dataType : "application/json"
    });
}

function doTestPaperDisplay(data, testId){
    testID = testId;
    var resp = eval("(" + data['responseText'] + ')');
    var leftNav = $("#fname-div"); 
    var rightDiv = $("#right-div");
    rightDiv.html("");
    rightDiv.append(leftNav);
    var dataDiv = $("<div id='dataDiv' style='display:block;'></div>");
    rightDiv.append(dataDiv);
    //testID, testName, questionID, question, optionID, text 
    for (var i = 0; i < resp.length; i ++) {
        var questionDiv = $("<div questionHolder=\"questionHolder\" id=\"Q" + i + "\"><div>");
        dataDiv.append(questionDiv);
        var question = $("<div question=\"question\" id=\"" + resp[i].questionID + "\">" + resp[i].question + "</div>");
        questionDiv.append(question);
        for (var j = 0; j < resp[i]["options"].length; j++) {
            var optionDiv = $("<div option=\"optionHolder\" \"" + resp[i]["options"][j].optionId + "\">\n\
                        <input option=\"option\" type=\"radio\" value=\"" + resp[i]["options"][j].optionId 
                    + "\" id=" + resp[i].questionID + "-" + resp[i]["options"][j].optionId 
                    + " name=" + resp[i].questionID + "> \n\
                        <label for=\"" + resp[i].questionID + "-" + resp[i]["options"][j].optionId + "\">" 
                            + resp[i]["options"][j].text 
                        + "</label>\n\
                    </div>");
            questionDiv.append(optionDiv);
        }
    } 
    dataDiv.append("<input type=\"button\" value=\"Submit\" id=\"testPaperDisplay\" name=\"testPaperDisplay\" onclick=\"javascript:onQuestionPaperSubmit()\">");
    
}    


function getTestsForClassId(classID) {
    $("#dataDiv").html("");
    $.ajax({
            type: "GET",
            url: "http://localhost:32340/ITS/apis/classtest/class/" + classID + "/userId/" + userData.userID,
            contentType: "application/json",
            error : function(err) {doTestDisplay(err);},
            success : function(dataFromServer) {
                doTestDisplay(dataFromServer);
            },
            dataType : "application/json"
    });
}    
    
function doTestDisplay(data){
    var resp = eval("(" + data['responseText'] + ')');
    var rightDiv = $("#right-div");
    $("#dataDiv").html("");
    var dataDiv = $("<div id='dataDiv' style='color:white;display:block;'></div>");
    rightDiv.append(dataDiv);
    for (var i = 0; i < resp.length; i ++) {
        var link = $("<div><a href=\"javascript:showTestPaper(" + resp[i].testID + ")\">"   + resp[i].testName + " </a></div>");
        dataDiv.append(link);
    }    
}


function doUserClassDisplay(data) {
    var resp = eval("(" + data['responseText'] + ')');
    
    var rightDiv = $("#right-div");
    //$("#dataDiv").html("");
    var dataDiv = $("<div id= 'dataDiv' style= 'display:block;color:white;'></div>");
    rightDiv.append(dataDiv);
    for (var i = 0; i < resp.length; i ++) {
        var link = $("<div><a href=\"javascript:getTestsForClassId(" + resp[i].classID + ")\">" + resp[i].className + "</a></div>");
        dataDiv.append(link);
    }
}


function onClassDisplayClick() {
        $.ajax({
            type: "GET",
            url: "http://localhost:32340/ITS/apis/userclass/user/" + userData.userID,
            contentType: "application/json",
            error : function(err) {doUserClassDisplay(err);},
            success : function(dataFromServer) {
                doUserClassDisplay(dataFromServer);
            },
            dataType : "application/json"
        });
    }
   

function onClassCreationClick(){
    $("#data-container").load("class-creation.html #container");   
}
