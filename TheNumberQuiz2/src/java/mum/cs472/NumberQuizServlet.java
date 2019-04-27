/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.cs472;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author amcfire
 */
public class NumberQuizServlet extends HttpServlet {

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
        String bnext = request.getParameter("btnNext");
        if(bnext.equals("Next")){
            HttpSession session = request.getSession();
            String SAge = request.getParameter("ansAge");
            if(isNumeric(SAge)){
                session.setAttribute("AAge", (""+SAge));
                Integer nx= Integer.parseInt(SAge);
                if((nx<4)||(nx>100))
                {
                    RequestDispatcher dispatcher0 = request.getRequestDispatcher("quiz3.jsp");
                    dispatcher0.forward(request, response);   
                }
            }else{
                RequestDispatcher dispatcher0 = request.getRequestDispatcher("quiz3.jsp");
                dispatcher0.forward(request, response);   
            }
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
            Cookie cTry = new Cookie("NTry", BL.GetTry());
            cTry.setMaxAge(3600);
            response.addCookie(cTry);
            cScore.setValue(BL.GetActualScore());
            response.addCookie(cScore);
            RequestDispatcher dispatcher = request.getRequestDispatcher("quiz.jsp");
            request.setAttribute("ActualScore", BL.GetActualScore());
            request.setAttribute("ActualSerie", BL.GetNextSerie());
            request.setAttribute("Actualtry", BL.GetTry());
            request.setAttribute("ActualHint", BL.GetHint());
            request.setAttribute("ActualAnswer", BL.GetSAnswer());
            request.setAttribute("Estadorespuesta", BL.GetFlagAnswer());
            dispatcher.forward(request, response);    
        }
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
        String bnext = request.getParameter("btnNext");
        if(bnext.equals("Next")){
            String OtherAnswer=request.getParameter("ans");
            if((OtherAnswer.length()==0)||(!isNumeric(OtherAnswer))){
                OtherAnswer="-1";
            }
            Cookie[] cookies = request.getCookies();
            String CookieSerieActual="";
            String CookieScoreActual="";
            String CookieTryActual="";
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
                    if (cookie.getName().equals("NTry")){
                        CookieTryActual=cookie.getValue();
                    }
                }
            }
            BusinessLogic BL=new BusinessLogic(CookieSerieActual, OtherAnswer, CookieScoreActual, CookieTryActual);
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
                        if (cookie.getName().equals("NTry")){
                            cookie.setValue(BL.GetTry());
                            response.addCookie(cookie); 
                        }
                    }
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher("quiz.jsp");
                request.setAttribute("ActualScore", BL.GetActualScore());
                request.setAttribute("ActualSerie", BL.GetNextSerie());
                request.setAttribute("Actualtry", BL.GetTry());
                request.setAttribute("ActualHint", BL.GetHint());
                request.setAttribute("ActualAnswer", BL.GetSAnswer());
                request.setAttribute("Estadorespuesta", BL.GetFlagAnswer());
                dispatcher.forward(request, response);    
            }else
            {
                RequestDispatcher dispatcher = request.getRequestDispatcher("quiz2.jsp");
                request.setAttribute("ActualScore", BL.GetActualScore());
                dispatcher.forward(request, response);  
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
                        if (cookie.getName().equals("NTry")){
                            cookie.setValue(BL.GetTry());
                        }
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
