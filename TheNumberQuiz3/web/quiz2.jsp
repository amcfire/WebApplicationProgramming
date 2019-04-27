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
        <div class='quiz'>
        <h1 id='tittle1'>The Number Quiz 2</h1>
        <% String score = (String)request.getAttribute("ActualScore"); %>
        <% String maxscore = (String)request.getAttribute("MaxScore"); %>
        <p>Your current score is: <%= score %></p>
        <p>You have completed the number Quiz, with a score of <%= score %> out of <%= maxscore %></p>
        </div> 
    </body>
</html>