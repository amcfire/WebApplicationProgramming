/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.cs472;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author amcfire
 */
public class SimpleCalculatorServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet SimpleCalculatorServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet SimpleCalculatorServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }

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
        PrintWriter out = response.getWriter();
        String s1 = request.getParameter("s1");
        String s2 = request.getParameter("s2");        
        String m1 = request.getParameter("m1");
        String m2 = request.getParameter("m2");
        String b1 = request.getParameter("bcalc");
        String b2 = request.getParameter("botro");
        int vs1=0;
        int vs2=0;
        int vsr=0;
        int vm1=0;
        int vm2=0;
        int vmr=0;
        if(s1.length()>0){
            vs1=Integer.parseInt(s1);}
        if(s2.length()>0){
            vs2=Integer.parseInt(s2);}
        if(m1.length()>0){
            vm1=Integer.parseInt(m1);}
        if(m2.length()>0){
            vm2=Integer.parseInt(m2);}
        boolean flagS=false;
        if((s1.length()>0)&&(s2.length()>0)){
            vsr=(vs1+vs2);
            flagS=true;
        }
        boolean flagM=false;
        if((m1.length()>0)&&(m2.length()>0)){
            vmr=(vm1*vm2);
            flagM=true;
        }
        String lS="<p>";
        if(flagS){
            lS=lS+vs1+"&plus;"+vs2+"="+vsr;
        } 
        lS=lS+"</p>";
        String lM="<p>";
        if(flagM){
            lM=lM+vm1+"&ast;"+vm2+"="+vmr;
        } 
        lM=lM+"</p><br>";
        out.print("<html><head><title>Test</title></head><body>");
        out.print("<p>Answer:</p>");
        out.print(lS);
        out.print(lM);
        out.print("<p>Method GET</p><br>");
        out.print("<p> Boton calculate:"+b1+"</p><br>");
        out.print("<p> Boton otro:"+b2+"</p><br>");
        if(b2!=null){
            HttpSession session = request.getSession();
            if(session.isNew()){
                out.print("<p> Sesion abierta por primera vez</p><br>");
            }else
            {
                out.print("<p> Sesion existente</p><br>");
                //session.invalidate();
                session.setMaxInactiveInterval(30);
            }
        }
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
        PrintWriter out = response.getWriter();
        String s1 = request.getParameter("s1");
        String s2 = request.getParameter("s2");        
        String m1 = request.getParameter("m1");
        String m2 = request.getParameter("m2");
        String b1 = request.getParameter("bcalc");
        String b2 = request.getParameter("botro");
        int vs1=0;
        int vs2=0;
        int vsr=0;
        int vm1=0;
        int vm2=0;
        int vmr=0;
        if(s1.length()>0){
            vs1=Integer.parseInt(s1);}
        if(s2.length()>0){
            vs2=Integer.parseInt(s2);}
        if(m1.length()>0){
            vm1=Integer.parseInt(m1);}
        if(m2.length()>0){
            vm2=Integer.parseInt(m2);}
        boolean flagS=false;
        if((s1.length()>0)&&(s2.length()>0)){
            vsr=(vs1+vs2);
            flagS=true;
        }
        boolean flagM=false;
        if((m1.length()>0)&&(m2.length()>0)){
            vmr=(vm1*vm2);
            flagM=true;
        }
        String lS="<p>";
        if(flagS){
            lS=lS+vs1+"&plus;"+vs2+"="+vsr;
        } 
        lS=lS+"</p>";
        String lM="<p>";
        if(flagM){
            lM=lM+vm1+"&ast;"+vm2+"="+vmr;
        } 
        lM=lM+"</p><br>";
        out.print("<html><head><title>Test</title></head><body>");
        out.print("<p>Answer:</p>");
        out.print(lS);
        out.print(lM);
        out.print("<p>Method POST</p><br>");
        out.print("<p> Boton calculate:"+b1+"</p><br>");
        out.print("<p> Boton otro:"+b2+"</p><br>");
       out.print("</body></html>");
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

}
