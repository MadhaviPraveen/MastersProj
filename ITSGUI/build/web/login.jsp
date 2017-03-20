<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="scripts/jquery-3.1.1.min.js"></script>
        <script src="scripts/variables.js"></script>
        <script src="scripts/home-page.js"></script>
        <script src="scripts/user-login.js"></script>
        <script src="scripts/class-creation.js"></script>
        <script src="scripts/test-creation.js"></script>        
        <script src="scripts/question-option-creation.js"></script>
        
        <script src="scripts/class-display.js"></script>
        <link href= "css/styles.css" rel="stylesheet" type ="text/css" >
    </head>
    <body>
        <h1><span>Intelligent Teaching System</span></h1>
        <div id="content-holder">
            <form id="loginForm">
                <div style="display: block;">
                    <div><label for="userId">user Id:</label><input type="text" id="userId" name="userId"></div>
                    <div><label for="password"> Password: </label><input type="password" id="password" name="password"><div>
                    <div id="login-submit"><input type="button" value="submit" id="submit"></div> 
                </div>
            </form> 
            <div id="login-error"></div>
        </div>
    </body>
</html>
