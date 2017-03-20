/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//function doMessaging(data) {
//    var resp = eval("(" + data['responseText'] + ')');
//    if (true == resp ) {
//      $("#testCreation-msg").html("<h3>Test information got inserted successfully.</h3>");
//    } else {
//        $("#testCreation-msg").html("<h3>Test Information did not get inserted . Please try again.</h3>");
//    }
//}
//
//function getTestInfoFromForm() {
//   var testName = $("#testName").val();
//      
//   var data = {};
//   data.testName = testName;
//   
//   $.ajax({
//    type: "PUT",
//    url: "http://localhost:32340/ITS/apis/test",
//    contentType: "application/json",
//    data : JSON.stringify(data),
//    error : function(err) {doMessaging(err);},
//    success : function(dataFromServer) {
//        doMessaging(dataFromServer);
//    },
//    dataType : "application/json"
//    });
//}
//
//$(document).ready(function() {
//    $( "#test-creation-submit" ).click(function() {
//        getTestInfoFromForm();
//    });
//});
//
function onTestsClassClick(){
 $("#dataDiv").html("");
 $("#data-container").html("");
  $("#data-container").append("<div id=\"left-dataDiv\" style=\"display:block; float:left; width:50%;\"></div>"
                    + "<div id=\"right-dataDiv\" style=\"display:block; float:right; width:50%;\"></div>"
                    + "");
  $.ajax({
            type: "GET",
            url: "http://localhost:32340/ITS/apis/allTests",
            contentType: "application/json",
            error : function(data) {displayTestsList(data);},
            success : function(dataFromServer) {
                displayTestsList(dataFromServer);
            },
            dataType : "application/json"
    });   
    
    $.ajax({
            type: "GET",
            url: "http://localhost:32340/ITS/apis/allClass",
            contentType: "application/json",
            error : function(data) {displayTestClassList(data);},
            success : function(dataFromServer) {
                displayTestClassList(dataFromServer);
            },
            dataType : "application/json"
    });   
    
}
function displayTestsList(data){
    
    var resp = eval("(" + data['responseText'] + ')');
    
    for(var i=0; i<resp.length;i++){
        var checkbox = $("<input type='radio' name='test' id= 's-"+ resp[i].testID +"' value= '"+resp[i].testID+"'>");
        var label = $("<label id= 'label-"+ resp[i].testID +"'> "+ resp[i].testName +"</label>");
        var testDiv = $("<div id='"+ resp[i].testID +"'></div>");
        
        testDiv.append(checkbox);
        testDiv.append(label);
        $("#left-dataDiv").append(testDiv);
    }
}
//
//
function displayTestClassList(data){
    
    var resp = eval("(" + data['responseText'] + ')');
    
    for(var i=0; i<resp.length;i++){
        var className = JSON.stringify(resp[i]);
        
        var checkbox = $("<input type='radio' name=\"class\" id= 'c-"+ resp[i].classID +"' value= '"+resp[i].classID+"'>");
        var label = $("<label id= 'label-"+ resp[i].classID +"'> "+ resp[i].className +" </label>");
        var classDiv = $("<div id='"+ resp[i].classID +"'></div>");
        
        classDiv.append(checkbox);
        classDiv.append(label);
        $("#right-dataDiv").append(classDiv);
    }
    
    $("#data-container").append("<input type='button' value=\"Submit\" id=\"test-class-submit\" onClick=\"javascript:doMapTestClassList();\">");
    $("#data-container").append("<div id='TestClassMapping-msg'></div>");
}

//$(document).ready(function() {
//    $( "#tests-class-submit" ).click(function() {
//        doMapTestClassList();
//    });
//});

function doMapTestClassList(){
    var testSelected = $("#left-dataDiv").find("[type=radio]:checked");
    var classSelected = $("#right-dataDiv").find("[type=radio]:checked");
    
    var data = {};
    
    var test = -1;
    testSelected.each(function(index, element){
        test = $(element).val();
    });
    
    var classId = -1;
    classSelected.each(function(index, element){
        classId = $(element).val();
    });
    
    data.testID = test;
    data.classID = classId;
    data.testName = "";
    
    $.ajax({
        type: "PUT",
        url: "http://localhost:32340/ITS/apis/classtest",
        contentType: "application/json",
        data : JSON.stringify(data),
        
        error : function(err) {$("#TestClassMapping-msg").html("");
           $("#TestClassMapping-msg").html("");
           $("#TestClassMapping-msg").append("<div style='text-align: left;padding-left: 15%;font-weight: bold;color: #fff;'>Student to Class is successfully mapped.</div>");
        },
        success : function(dataFromServer) {
            $("#TestClassMapping-msg").html("");
            $("#TestClassMapping-msg").append("<div>Student to Class is successfully mapped. </div>");
        },
        dataType : "application/json"
    });
}