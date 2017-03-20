/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function doHomePageChanges(rootLocation) {
    $("#welcomeText").html("WELCOME " + userData.fname);  
    if ("Admin" == userData.userType) {
        $("#left-nav").load("admin-home.html #container");
    } else {
        $("#left-nav").load("student-home.html #container");
    }
}
//homepage
function createHomePage(rootLocation) {
    
    //var rawHomePage = "<h1>NOTHING LOADED</h1>";
    rootLocation.load( "home.html #container" , function() {
        doHomePageChanges(rootLocation);
    });
    //rootLocation.append(rawHomePage);
}