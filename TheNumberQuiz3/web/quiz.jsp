<%-- 
    Document   : quiz
    Created on : Dec 6, 2017, 9:42:38 AM
    Author     : amcfire
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>The Number Quiz 2</title>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styleQuiz.css" type="text/css" rel="stylesheet" />
    </head>
    <body>
        <br>
        <br>
        <div class="quiz">
            <h1 id="tittle1">The Number Quiz 2j</h1>
            <form method='post' action="NumberQuiz">
                <% String score = (String)request.getAttribute("ActualScore"); %>
                <% String serie = (String)request.getAttribute("ActualSerie"); %>
                <% String attempt = (String)request.getAttribute("Actualtry"); %>
                <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                <p>Your current score is: <%= score %></p>
                <p>Attempt: <%= attempt %> &sol;3</p>
                <p>Guess the next number in the sequence&excl;</p>
                <p>&lbrack;<%//= serie %>${ActualSerie}<em>&quest;</em>&rbrack;</p>
                <p><c:out value = "${'<tag> , &'}"/></p>
                <p><c:set var= "salary" scope = "session" value = "${2000*2}"/>
                <c:out value = "${salary}"/></p>
                <c:choose>
                <c:when test = "${salary > 2000}">
                    <p>My salary is:  <c:out value = "${salary}"/><p>
                </c:when>
                <c:otherwise>
                    <p>My salary is too bad.<c:out value = "${'!!!'}"/></p>
                </c:otherwise>
                </c:choose>
                <p>Your answer: <input type="text" name="ans"/> </p>
                <p><input type='submit' value='Next'/> <input type='submit' value='Restart'/></p>
                <p><input type='submit' value='Hint'/>
            </form>
                <%String [][] data = {{"Nov 6", "32", "26"},{"Nov 7", "32", "26"},{"Nov 8", "32", "26"}}; request.setAttribute ("temperatures", data);%>
                <table>
                    <tr><th>DATE</th><th>HIGH</th><th>LOW</th></tr>
                    <c:forEach var="daily" items="${temperatures}">
                    <tr><td>${daily[0]}</td><td>${daily[1]}</td><td>${daily[2]}</td></tr>
                    </c:forEach >
                </table>
        </div>
    </body>
</html>
