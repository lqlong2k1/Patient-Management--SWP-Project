/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOFactory;
import Model.MedicalRecord.Prescription;
import Model.MedicalRecord.Prescription_detail;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name = "CreatePrescription", urlPatterns = {"/CreatePrescription"})
public class CreatePrescription extends HttpServlet {

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
  request.getRequestDispatcher("CreatePrescription.jsp").forward(request, response);
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
         String[] idme = request.getParameterValues("IDME");
        String[] quantity = request.getParameterValues("quantity");
        String IDMR = (String) request.getSession().getAttribute("IDMR");
        int i = 0;
        
        // tạo toa thuốc
        Prescription mrd = new Prescription();
        mrd.setIDMR(IDMR);
        String IDPRE = DAOFactory.getPrescriptionDAO().addPrescription(mrd);
        // tạo chi tiết toa thuốc
        for (String id :idme){
            Prescription_detail predetail = new Prescription_detail(IDPRE,id,Integer.parseInt(quantity[i]));         
           DAOFactory.getPrescription_DetailDAO().addPrescription_Detail(predetail);
        i++;
        }
        response.sendRedirect("ViewPrescriptionServlet?action=viewPres&IDMR="+IDMR);
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
