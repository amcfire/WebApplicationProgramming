<%-- 
    Document   : quiz2
    Created on : Dec 6, 2017, 9:55:56 AM
    Author     : amcfire
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>The Number Quiz Result</title>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styleQuiz.css" type="text/css" rel="stylesheet" />
    </head>
    <body>
        <div class="quiz">
            <form action="index.html">
                <h1 id='tittle1'>Game Over</h1>
                <% String score = (String)request.getAttribute("ActualScore"); %>
                <% String grade = "A"; %>
                <% Integer Nscore = Integer.parseInt(score); %>
                <p>Your current score is: ${ActualScore}</p>
                <p>You current grade is:</p>
                <% if(Nscore<25) { grade="NC"; } %>
                <% if((Nscore>=25)&&(Nscore<35)) { grade="C"; } %>
                <% if((Nscore>=35)&&(Nscore<45)) { grade="B"; } %>
                <% if(Nscore>=45) { grade="A"; } %>        
                <p><span id='predb'><%= grade%></span></p>
                <p><input type='submit' name='btnStart' value='Start Over!' /></p> 
            </form>
        </div>
    </body>
</html>
