/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function doMessaging(data) {
    var resp = eval("(" + data['responseText'] + ')');
    
    if (true == resp ) {
      $("#classCreation-msg").html("<h3>Class information got inserted successfully.</h3>");
  
    } else {
        $("#classCreation-msg").html("<h3>Class Information did not get inserted . Please try again.</h3>");
    }
    
}
function getClassInfoFromForm() {
   var className = $("#className").val();
   var year = $("#year").val();
   var semester = $("#semester").val();
   
   var data = {};
   data.className = className;
   data.year = year;
   data.semester = semester;
   
   
   $.ajax({
    type: "PUT",
    url: "http://localhost:32340/ITS/apis/class",
    contentType: "application/json",
    data : JSON.stringify(data),
    error : function(err) {doMessaging(err);},
    success : function(dataFromServer) {
        doMessaging(dataFromServer);
    },
    dataType : "application/json"
    });
}

$(document).ready(function() {
    $( "#class-creation-submit" ).click(function() {
        getClassInfoFromForm();
    });
});
// starts jquery

function onStudentClassClick(){
  $("#data-container").html("");
$("#dataDiv").html("");
  $("#data-container").append("<div id=\"left-dataDiv\" style=\"display:block; float:left; width:50%;\"></div>"
                    + "<div id=\"right-dataDiv\" style=\"display:block; float:right; width:50%;\"></div>"
                    + "");
  $.ajax({
            type: "GET",
            url: "http://localhost:32340/ITS/apis/allUsers",
            contentType: "application/json",
            error : function(data) {displayStudentList(data);},
            success : function(dataFromServer) {
                displayStudentList(dataFromServer);
            },
            dataType : "application/json"
    });   
    
    $.ajax({
            type: "GET",
            url: "http://localhost:32340/ITS/apis/allClass",
            contentType: "application/json",
            error : function(data) {displayClassList(data);},
            success : function(dataFromServer) {
                displayClassList(dataFromServer);
            },
            dataType : "application/json"
    });
  
}


function displayStudentList(data){
    
    var resp = eval("(" + data['responseText'] + ')');
    
    for(var i=0; i<resp.length;i++){
        var student = JSON.stringify(resp[i]);
        var checkbox = $("<input name=\"studentList\" type= 'radio' id= 's-"+ resp[i].userID +"' value= '"+resp[i].userID+"'>");
        var label = $("<label id= 'label-"+ resp[i].userID +"'> "+ resp[i].fname +" "+ resp[i].lname +"</label>");
        var studentDiv = $("<div id='"+ resp[i].userID +"'></div>");
        
        studentDiv.append(checkbox);
        studentDiv.append(label);
        $("#left-dataDiv").append(studentDiv);
    }
}


function displayClassList(data){
    
    
         var resp = eval("(" + data['responseText'] + ')');
    
    
    for(var i=0; i<resp.length;i++){
        var className = JSON.stringify(resp[i]);
        
        var checkbox = $("<input type= 'checkbox' name=\"class\" id= 'c-"+ resp[i].classID +" ' value= '"+resp[i].classID+"'>");
        var label = $("<label id= 'label-"+ resp[i].classID +"'> "+ resp[i].className +" </label>");
        var classDiv = $("<div id=' "+ resp[i].classID +" '></div>");
        
        classDiv.append(checkbox);
        classDiv.append(label);
        $("#right-dataDiv").append(classDiv);
    }
    
    $("#data-container").append("<input type='button' value=\"Submit\" id=\"student-class-submit\" onClick=\"javascript:doMapStudentClassList();\">");
    
    $("#data-container").append("<div id='StudentClassMapping-msg'></div>");
    
   $("#left-dataDiv input:checkbox").change(function() {
    $("#left-dataDiv input:checkbox").attr("checked", false);
    $(this).attr("checked", true);
});
}

function doMapStudentClassList(){
    var studentSelected = $("#left-dataDiv").find("[type=radio]:checked");
    var classSelected = $("#right-dataDiv").find("[type=checkbox]:checked");
    
    var data = {};
    
    var user = -1;
    studentSelected.each(function(index, element){
        user = $(element).val();
    });
    
    var classIds = [];
    classSelected.each(function(index, element){
        classIds.push($(element).val());
    });
    
    data.userId = user;
    data.classIds = classIds;
    $.ajax({
        type: "PUT",
        url: "http://localhost:32340/ITS/apis/userclass",
        contentType: "application/json",
        data : JSON.stringify(data),
        error : function(err) {$("#StudentClassMapping-msg").html("");
           $("#StudentClassMapping-msg").append("<div style='text-align: left;padding-left: 15%;font-weight: bold;color: #fff;'>Student to Class is successfully mapped.</div>");
        },
        success : function(dataFromServer) {
            $("#StudentClassMapping-msg").html("");
            $("#StudentClassMapping-msg").append("<div>Student to Class is successfully mapped. </div>");
        },
        dataType : "application/json"
    });
    
    
}