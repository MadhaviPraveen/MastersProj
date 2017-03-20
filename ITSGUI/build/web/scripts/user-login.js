/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function doUICreation(data) {
    var resp = eval("(" + data['responseText'] + ')');
    userData = resp;
    if (typeof userData.userID != "undefined" && userData.userID != 0) {
     $("#content-holder").html("");
     createHomePage($("#content-holder"));
    } else {
        $("#login-error").html("<h3>The UserName or Password provided did not match with our records. Please try again.</h3>");
    }
    
}
function getUserInfoFromForm() {
     var userId = $("#userId").val();
   var password = $("#password").val();
   
   var data = {};
   data.userId = userId;
   data.password = password;
  // alert("userId : " + userId + " password : " + password);
   
   $.ajax({
    type: "POST",
    url: "http://localhost:32340/ITS/apis/user",
    contentType: "application/json",
    data : JSON.stringify(data),
    error : function(err) {doUICreation(err);},
    success : function(dataFromServer) {
        doUICreation(dataFromServer);
    },
    dataType : "application/json"
    });
    
    /*$.ajax({
        url: 'http://localhost:32340/ITS/apis/user',
        contentType: "application/json",
        type: 'POST',
        data: 'post-form='+JSON.stringify(data),
        dataType: 'text',
        success: function(response, textStatus, jqXHR) {
          alert("Yay!");
        },
        error: function(jqXHR, textStatus, errorThrown){
          alert(textStatus, errorThrown);
       }
     });*/
}

$(document).ready(function() {
    $( "#submit" ).click(function() {
        getUserInfoFromForm();
    });
});
// starts jquery
