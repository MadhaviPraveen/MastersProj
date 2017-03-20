

var questionCount = 1;
var optionCount = 1;

function addOption(questionHolder, questionCount) {
    if (questionHolder == null || typeof questionHolder == "undefined") {
        return;
    }
    $(questionHolder).append("<div option=\"option\" id=\"DivQ" + questionCount + "O" + optionCount +"\"><label id=\"Q" + questionCount + "O" + optionCount +"\">Option</label>\n\
    <input type=\"text\" option=\"option\" id=\"Q" + questionCount + "O" + (optionCount) +"\">\n\
    <label for=\"RQ" + questionCount + "O" + (optionCount) +"\">Correct ?</label>\n\
    <input type=\"radio\" correct=\"correct\" name=\"RQ" + questionCount + "\" id=\"RQ" + questionCount + "\">\n\
    <input type=\"button\" value=\"Remove\" onClick=\"remove(DivQ" + questionCount + "O" + optionCount +")\" ></div>");
    optionCount++;
}

function remove(id) {
    if (id != null) {
        id.innerHTML = "";
    }
}

function addQuestionAndOption() {
    var question = $("<div questionDiv=\"questionDiv\" id=\"QDiv" + questionCount + "\"><label for=\"Q" + questionCount + "\">Question " + questionCount +"</label>\n\
<input type=\"text\" question=\"question\" id=\"Q" + questionCount + "\"><div id=\"QODiv" + questionCount + "\">\n\
<input type=\"button\" id=\"button-id\" value= \"Add Option\" onClick=\"javascript:addOption(QODiv" + questionCount + ", " + questionCount + ")\">\n\
<input type=\"button\" value=\"Remove\" onClick=\"remove(QDiv" + questionCount +")\"></div>");
    var formFieldsHolder = $("#testHolder")
    formFieldsHolder.append(question);
    questionCount ++;
}

function gatherInfoOnSubmit() {
    var formFieldsHolder = $("#testHolder");
    if (formFieldsHolder == null || typeof formFieldsHolder == "undefined") {
        return;
    }
    
    var dataToBackEnd = {};
    var test = $("#test").val();
    dataToBackEnd.test = test;
    var questions = new Array();
    dataToBackEnd.questions = questions;
    
    var questionDivs = formFieldsHolder.find('[questionDiv="questionDiv"]');
    
    if (questionDivs != null && typeof questionDivs != "undefined") {
        questionDivs.each(function(index) {
            var questionInp = $(questionDivs[index]).find("[question=question]");
            if (questionInp != null && typeof questionInp != "undefined") {
                var questionText = $(questionInp).val();
                var questionData = {};
                questionData.question = questionText;
                var optionsDiv = $(questionDivs[index]).find("> div > div > input[type=text]");
                var optionsList = [];
                optionsDiv.each(function(index) {
                    if (optionsDiv[index] != null) {
                        var inp = optionsDiv[index];
                        optionsList.push($(inp).val());
                    }
                });
                
                var correctOptions = $(questionDivs[index]).find("> div > div > input[correct=correct]");
                var correctOption = "";
               
                correctOptions.each(function(index) {
                    if (correctOptions[index] != null && $(correctOptions[index]).is(':checked')) {
                        correctOption = index;                        
                    }
                });
                
                questionData.options = optionsList;
                questionData.correctOption = correctOption;
                questions.push(questionData);
            }
        });
    }
    
     $.ajax({
        type: "PUT",
        url: "http://localhost:32340/ITS/apis/questionOptions",
        dataType: 'text',
        contentType: "application/json",
        data : JSON.stringify(dataToBackEnd),
        error : function(err) {
            $("#questionOptionCreation-msg").html("");
            $("#questionOptionCreation-msg").append("<div style='text-align: left;padding-left: 15%;font-weight: bold;color: #fff;'>A record was inserted</div>");
        },
        success : function(dataFromServer) {
            $("#questionOptionCreation-msg").html("");
            $("#questionOptionCreation-msg").append("<div>A record was inserted</div>");
        },
        dataType : "application/json"
     });
    
}


function onQuestionOptionCreationClick(){
    $("#data-container").load("question-option-creation.html #container");   
}