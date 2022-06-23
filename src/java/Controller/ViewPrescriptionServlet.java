/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOFactory;
import Model.Account.Account;
import Model.Doctors.Doctor;
import Model.MedicalRecord.Prescription;
import Model.MedicalRecord.Prescription_detail;
import Model.Patient.Patient;
import Model.Staff.Staff;
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
@WebServlet(name = "ViewPrescriptionServlet", urlPatterns = {"/ViewPrescriptionServlet"})
public class ViewPrescriptionServlet extends HttpServlet {

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
           Account account = (Account) request.getSession().getAttribute("acc");
           Patient patient = DAOFactory.getPatientDao().getSpecificPatient(account.getUser());
           Staff staff     = DAOFactory.getStaffDAO().getSpecificStaff(account.getUser());
           Doctor doctor   = DAOFactory.getDoctorDao().getSpecificDoctor(account.getUser());
        if (request.getParameter("action").equals("viewPres")) {
           
         String IDMR = request.getParameter("IDMR");
         List<Prescription> pres= DAOFactory.getPrescriptionDAO().getPrescriptionByMR(IDMR);
     
             if (doctor != null) {
                    if (pres.size() >= 0) {
                         request.getSession().setAttribute("IDMR", IDMR);
                          request.setAttribute("pres", pres);
                      request.getRequestDispatcher("MRPrescriptionListDoctor.jsp").forward(request, response);
                    }
                }else if (patient !=null) {
                    
                    if (pres.size() >= 0) {
                         request.setAttribute("pres", pres);
               request.getRequestDispatcher("MRPrescriptionListPatient.jsp").forward(request, response);
                    }
                }
            
        } else if (request.getParameter("action").equals("viewPresDetail")) {
            String IDPRE = request.getParameter("IDPRE");
            List<Prescription_detail> presDetail= DAOFactory.getPrescription_DetailDAO().getPrescription_DetailByPres(IDPRE);
            
            if (doctor != null) {
                    if (presDetail.size() >= 0) {
                           request.setAttribute("IDPRE", IDPRE);
                          request.setAttribute("presDetail", presDetail);
                          request.getRequestDispatcher("MRPrescriptionDetailsPatient.jsp").forward(request, response);
                    }
                }else if (patient !=null) {
                    
                    if (presDetail.size() >= 0) {
                         request.setAttribute("IDPRE", IDPRE);
                         request.setAttribute("presDetail", presDetail);
                         request.getRequestDispatcher("MRPrescriptionDetailsPatient.jsp").forward(request, response);
                    } 
                }
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
