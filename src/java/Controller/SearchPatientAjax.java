/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOFactory;
import Model.Patient.Patient;
import Model.Service.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name = "SearchPatientAjax", urlPatterns = {"/SearchPatientAjax"})
public class SearchPatientAjax extends HttpServlet {

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
        PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            String txtSearch= request.getParameter("txtSearch");
    
            List<Patient> patients ;
            if (txtSearch.equals("")==false) {
             patients= DAOFactory.getPatientDao().searchbyName(txtSearch);   
            } else {
                patients=DAOFactory.getPatientDao().getAllPatient();
            }
            for (Patient pa : patients){
               String genderString="";
                if (pa.getGender()){
                   genderString="Giới Tính Nam";
               } else {
                    genderString="Giới Tính Nữ";
                }
                out.println("   <div class=\"box\">\n" +
"                <img src=\"image/doc-1.jpg\" alt=\"\">\n" +
"                <h3>"+pa.getUser_Name()+"</h3>\n" +
"                <p>"+pa.getID_User()+"</p>\n" +
"                <span> "+genderString+"</span>\n" +
"                <div class=\"share\">\n" +
"                    <a href=\" /PatientMAnagement2/ViewListPatientServlet?action=viewpatientprofile&id="+pa.getID_User()+"\" class=\"fab fa-linkedin\"></a>\n" +
"                </div>\n" +
"            </div>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
