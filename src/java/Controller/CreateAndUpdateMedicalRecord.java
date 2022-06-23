/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOFactory;
import Model.Account.Account;
import Model.MedicalRecord.MedicalRecord;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name = "CreateAndUpdateMedicalRecord", urlPatterns = {"/CreateAndUpdateMedicalRecord"})
public class CreateAndUpdateMedicalRecord extends HttpServlet {

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
            out.println("<title>Servlet CreateMedicalRecord</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateMedicalRecord at " + request.getContextPath() + "</h1>");
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
       if (request.getParameter("action").equals("Create")){  
           String patientID=request.getParameter("patientID");
           request.setAttribute("patientID", patientID);
       request.getRequestDispatcher("CreateMR.jsp").forward(request, response);}
       else if (request.getParameter("action").equals("Update")){
           String idmr = request.getParameter("idmr");
           MedicalRecord mr =DAOFactory.getMedicalRecordDAO().getAnMedicalRecord(idmr);
           request.setAttribute("mr", mr);
           request.getRequestDispatcher("UpdateMR.jsp").forward(request, response);
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
        String button= request.getParameter("btn");
        String date = request.getParameter("DateCreated");
        Date dateCreated = Date.valueOf(date);
        String idPa = request.getParameter("IDPatient");
        String idDO= request.getParameter("IDDoctor");
        String Symptom=request.getParameter("Symptom");
         Account account= (Account) request.getSession().getAttribute("acc");
        if (button.equals("Create")) {
        MedicalRecord mr = new MedicalRecord();
        mr.setCreateDate(dateCreated);
        mr.setDoctor(idDO);
        mr.setPatient(idPa);
        mr.setSymtoms(Symptom);
        String idmr = DAOFactory.getMedicalRecordDAO().addMedicalRecord(mr);
       
        response.sendRedirect("ViewMedicalRecordServlet?action=viewMRDetail&userID="+account.getUser()+"&idmr="+idmr);            
        } else if( button.equals("Update")){
            String idmr =(String) request.getSession().getAttribute("IDMR");
        MedicalRecord mr = new MedicalRecord();
        mr.setCreateDate(dateCreated);
        mr.setDoctor(idDO);
        mr.setPatient(idPa);
        mr.setSymtoms(Symptom);
        mr.setMedicalRecordId(idmr);
        DAOFactory.getMedicalRecordDAO().updateMedicalRecord(mr);
         response.sendRedirect("ViewMedicalRecordServlet?action=viewMRDetail&userID="+account.getUser()+"&idmr="+idmr);  
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

}
