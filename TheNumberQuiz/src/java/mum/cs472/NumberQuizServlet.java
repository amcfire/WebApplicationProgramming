/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.cs472;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author amcfire
 */
public class NumberQuizServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NumberQuizServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NumberQuizServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String FirstAnswer=request.getParameter("ans");
        if((FirstAnswer.length()==0)||(!isNumeric(FirstAnswer))){
            FirstAnswer="-1";
        }
        BusinessLogic BL=new BusinessLogic(FirstAnswer);
        Cookie cScore = new Cookie("Score", "0");
        cScore.setMaxAge(3600);
        response.addCookie(cScore);                    
        Cookie cActualSerie = new Cookie("ASerie", BL.GetSerie());
        cActualSerie.setMaxAge(3600);
        response.addCookie(cActualSerie);
        Cookie cNextSerie = new Cookie("NSerie", BL.GetNextSerie());
        cNextSerie.setMaxAge(3600);
        response.addCookie(cNextSerie);
        cScore.setValue(BL.GetActualScore());
        response.addCookie(cScore);
        PrintWriter out = response.getWriter();
        out.print("<html>");
        out.print("<head>");
        out.print("<title>The Number Quiz</title>");
        out.print("<meta charset='UTF-8'>");
        out.print("<link href='styleQuiz.css' type='text/css' rel='stylesheet' />");
        out.print("</head>");
        out.print("<body><br><br>");
        out.print("<div class='quiz'>");
        out.print("<form method='post' action='NumberQuiz'>");
        out.print("<h1 id='tittle1'>The Number Quiz</h1>");
        out.print("<p>Your current score is: "+BL.GetActualScore()+"</p>");
        out.print("<p>Guess the next number in the sequence.</p>");
        out.print("<p>"+BL.GetNextSerie()+"</p>");
        out.print("<p>Your answer: <input type='text' name='ans'/> </p>");
        out.print("<p><input type='submit' value='SUBMIT'/></p>");
        out.print("</form></div>");
//        out.print("<p>Method: GET</p>");
//        out.print("<p>Serie: "+BL.GetSerie()+"</p>");             
//        out.print("<p>Answer: "+BL.GetAnswer()+"</p>");             
//        out.print("<p>NextSerie: "+BL.GetNextSerie()+"</p>");             
//        out.print("<p>Score: "+BL.GetActualScore()+"</p>");   
//        out.print("<p>Serie Size: "+BL.GetSeriesSize()+"</p>");
//        out.print("<p>Index: "+BL.GetIndex()+"</p>");
//        out.print("<p>NextIndex: "+BL.GetNextIndex()+"</p>");
//        out.print("<p>CookieSerieActual: "+cActualSerie.getValue()+"</p>");
//        out.print("<p>CookieScoreActual: "+cScore.getValue()+"</p>");
        out.print("</body></html>");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String OtherAnswer=request.getParameter("ans");
        if((OtherAnswer.length()==0)||(!isNumeric(OtherAnswer))){
            OtherAnswer="-1";
        }
        Cookie[] cookies = request.getCookies();
        String CookieSerieActual="";
        String CookieScoreActual="";
        if (cookies != null)
        {
            for (Cookie cookie : cookies)
            {
                if (cookie.getName().equals("NSerie")){
                    CookieSerieActual=cookie.getValue();
                }
                if (cookie.getName().equals("Score")){
                    CookieScoreActual=cookie.getValue();
                }
            }
        }
        BusinessLogic BL=new BusinessLogic(CookieSerieActual, OtherAnswer, CookieScoreActual);
        if(BL.GetNextIndex()>0){
            if (cookies != null)
            {
                for (Cookie cookie : cookies)
                {
                    if (cookie.getName().equals("ASerie")){
                        cookie.setValue(BL.GetSerie());
                        response.addCookie(cookie);  
                    }
                    if (cookie.getName().equals("NSerie")){
                        cookie.setValue(BL.GetNextSerie());
                        response.addCookie(cookie); 
                    }
                    if (cookie.getName().equals("Score")){
                        cookie.setValue(BL.GetActualScore());
                        response.addCookie(cookie); 
                    }
                }
            }
            PrintWriter out = response.getWriter();
            out.print("<html>");
            out.print("<head>");
            out.print("<title>The Number Quiz</title>");
            out.print("<meta charset='UTF-8'>");
            out.print("<link href='styleQuiz.css' type='text/css' rel='stylesheet' />");
            out.print("</head>");
            out.print("<body><br><br>");
            out.print("<div class='quiz'>");
            out.print("<form method='post' action='NumberQuiz'>");
            out.print("<h1 id='tittle1'>The Number Quiz</h1>");
            out.print("<p>Your current score is: "+BL.GetActualScore()+"</p>");
            out.print("<p>Guess the next number in the sequence.</p>");
            out.print("<p>"+BL.GetNextSerie()+"</p>");
            out.print("<p>Your answer: <input type='text' name='ans'/> </p>");
            out.print("<p><input type='submit' value='SUBMIT'/></p>");
            out.print("</form></div>");
//            out.print("<p>Method: POST</p>");
//            out.print("<p>Serie: "+BL.GetSerie()+"</p>");             
//            out.print("<p>Answer: "+BL.GetAnswer()+"</p>");             
//            out.print("<p>NextSerie: "+BL.GetNextSerie()+"</p>");             
//            out.print("<p>Score: "+BL.GetActualScore()+"</p>");   
//            out.print("<p>Serie Size: "+BL.GetSeriesSize()+"</p>");
//            out.print("<p>Index: "+BL.GetIndex()+"</p>");
//            out.print("<p>NextIndex: "+BL.GetNextIndex()+"</p>");
//            out.print("<p>CookieSerieActual: "+CookieSerieActual+"</p>");
//            out.print("<p>CookieScoreActual: "+CookieScoreActual+"</p>");
            out.print("</body></html>");
        }else
        {
            PrintWriter out = response.getWriter();
            out.print("<html>");
            out.print("<head>");
            out.print("<title>The Number Quiz Result</title>");
            out.print("<meta charset='UTF-8'>");
            out.print("<link href='styleQuiz.css' type='text/css' rel='stylesheet' />");
            out.print("</head>");
            out.print("<body><br><br>");
            out.print("<div class='quiz'>");
            out.print("<h1 id='tittle1'>The Number Quiz</h1>");
            out.print("<p>Your current score is: "+BL.GetActualScore()+"</p>");
            out.print("<p>You have completed the number Quiz, with a score of "+BL.GetActualScore()
                    +" out of "+BL.GetSeriesSize()+"</p>");
            out.print("</div>");
            out.print("</body></html>"); 
            if (cookies != null)
            {
                for (Cookie cookie : cookies)
                {
                    if (cookie.getName().equals("ASerie")){
                        cookie.setValue(BL.GetNextSerie());
                    }
                    if (cookie.getName().equals("NSerie")){
                        cookie.setValue(BL.GetNextSerie());
                    }
                    if (cookie.getName().equals("Score")){
                        cookie.setValue("0");
                    }
                }
            }           
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    
}
