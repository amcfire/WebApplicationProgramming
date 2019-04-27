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
        <script>
            function conf(txt){
                var r = confirm(txt);
                if (r) {
                    window.location.href = 'ResetServlet';
                } 
            }       
        </script>
    </head>
    <body>
        <br>
        <br>
        <div class="quiz">
            <form method='post' action="NumberQuiz">
                <h1 id="tittle1">Have fun with NumberQuiz&excl;</h1>
                <% String score = (String)request.getAttribute("ActualScore"); %>
                <% String serie = (String)request.getAttribute("ActualSerie"); %>
                <% Integer attempt = Integer.parseInt((String)request.getAttribute("Actualtry")); %>
                <% String hint = (String)request.getAttribute("ActualHint"); %>
                <% Integer CorrectAnswer = Integer.parseInt((String)request.getAttribute("ActualAnswer")); %>
                <p>Your current score is: ${ActualScore}</p>
                <p>Your Age is: ${AAge}</p>
                <p>Attempt: ${Actualtry} &sol; 3</p>
                <p>Guess the next number in the sequence&excl;</p>
                <p>&lbrack; ${ActualSerie}<span id='sred'> &quest;</span> &rbrack;</p>
                <p>Your answer: <input type="text" name="ans"/> </p>
                <p><input type='submit' name='btnNext' value='Next'/>
                   <input type='button'  name='btnRestart' value='Restart' onclick="return conf('Do you want to start over?')"/></p>
                <% if((attempt>0)&&(attempt<3)) {%>
                    <p class='pred'>Your last answer was not correct&excl; Please try again</p>
                <% } else if(attempt==3){ %>
                    <p class='pred'>No more Attempt&excl; Correct answer is ${CorrectAnswer}</p>
                <% } %>
                <p><input type='button' name='btnHint' value='Hint' onclick="return confirm('${ActualHint}')"/></p>
            </form>
        </div>
            <p>intento ${Actualtry}</p>
            <p>respuesta ${Estadorespuesta}</p>
    </body>
</html>
