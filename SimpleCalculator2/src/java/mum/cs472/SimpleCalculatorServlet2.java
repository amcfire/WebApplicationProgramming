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

/**
 *
 * @author amcfire
 */
public class SimpleCalculatorServlet2 extends HttpServlet {

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
//            out.println("<title>Servlet SimpleCalculatorServlet2</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet SimpleCalculatorServlet2 at " + request.getContextPath() + "</h1>");
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
        int vs1=0;
        int vs2=0;
        int vsr=0;
        int vm1=0;
        int vm2=0;
        int vmr=0;
        boolean flagS=true;
        boolean flagM=true;
        String st1;
        if((s1.length()>0)&&(isNumeric(s1))){
            vs1=Integer.parseInt(s1);
            st1="<input type='text' name='s1' value='"+s1+"' /> ";
        }else{
            st1="<input type='text' name='s1'/> ";
            flagS=false;
        }
        String st2;    
        if((s2.length()>0)&&(isNumeric(s2))){
            vs2=Integer.parseInt(s2);
            st2="<input type='text' name='s2' value='"+s2+"' /> ";
        }else{
            st2="<input type='text' name='s2'/> ";  
            flagS=false;
        }
        String st3="<input type='text' name='sr' /><br>";
        if(flagS){
            vsr=(vs1+vs2);
            st3="<input type='text' name='sr' value='"+vsr+"' /><br>";        
        }
        
        String st4;
        if((m1.length()>0)&&(isNumeric(m1))){
            vm1=Integer.parseInt(m1);
            st4="<input type='text' name='m1' value='"+m1+"' /> ";
        }else{
            st4="<input type='text' name='m1'/> ";
            flagM=false;
        }
        String st5;    
        if((m2.length()>0)&&(isNumeric(m2))){
            vm2=Integer.parseInt(m2);
            st5="<input type='text' name='m2' value='"+m2+"' /> ";
        }else{
            st5="<input type='text' name='m2'/> "; 
            flagM=false;
        }
        String st6="<input type='text' name='mr' /><br>";
        if(flagM){
            vmr=(vm1*vm2);
            st6="<input type='text' name='mr' value='"+vmr+"' /><br>";        
        }
        
        out.print("<html><head><title>Test</title></head>");
        out.print("<body><div><br><form method='get' action='Calculator2'>");
        out.print("<p>Please Enter Numbers:</p><br>");
        out.print(st1);  
        out.print("&plus;");
        out.print(st2);                 
        out.print("=");
        out.print(st3); 
        out.print(st4); 
        out.print("&ast;");
        out.print(st5); 
        out.print("=");
        out.print(st6); 
        out.print("<input type='submit' value='Calculate'/>");
        out.print("</form></div></body></html>");
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
        int vs1=0;
        int vs2=0;
        int vsr=0;
        int vm1=0;
        int vm2=0;
        int vmr=0;
        boolean flagS=true;
        boolean flagM=true;
        String st1;
        if((s1.length()>0)&&(isNumeric(s1))){
            vs1=Integer.parseInt(s1);
            st1="<input type='text' name='s1' value='"+s1+"' /> ";
        }else{
            st1="<input type='text' name='s1'/> ";
            flagS=false;
        }
        String st2;    
        if((s2.length()>0)&&(isNumeric(s2))){
            vs2=Integer.parseInt(s2);
            st2="<input type='text' name='s2' value='"+s2+"' /> ";
        }else{
            st2="<input type='text' name='s2'/> ";  
            flagS=false;
        }
        String st3="<input type='text' name='sr' /><br>";
        if(flagS){
            vsr=(vs1+vs2);
            st3="<input type='text' name='sr' value='"+vsr+"' /><br>";        
        }
        
        String st4;
        if((m1.length()>0)&&(isNumeric(m1))){
            vm1=Integer.parseInt(m1);
            st4="<input type='text' name='m1' value='"+m1+"' /> ";
        }else{
            st4="<input type='text' name='m1'/> ";
            flagM=false;
        }
        String st5;    
        if((m2.length()>0)&&(isNumeric(m2))){
            vm2=Integer.parseInt(m2);
            st5="<input type='text' name='m2' value='"+m2+"' /> ";
        }else{
            st5="<input type='text' name='m2'/> "; 
            flagM=false;
        }
        String st6="<input type='text' name='mr' /><br>";
        if(flagM){
            vmr=(vm1*vm2);
            st6="<input type='text' name='mr' value='"+vmr+"' /><br>";        
        }
        
        out.print("<html><head><title>Test</title></head>");
        out.print("<body><div><br><form method='get' action='Calculator2'>");
        out.print("<p>Please Enter Numbers:</p><br>");
        out.print(st1);  
        out.print("&plus;");
        out.print(st2);                 
        out.print("=");
        out.print(st3); 
        out.print(st4); 
        out.print("&ast;");
        out.print(st5); 
        out.print("=");
        out.print(st6); 
        out.print("<input type='submit' value='Calculate'/>");
        out.print("</form></div></body></html>");
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

    private static boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
}
