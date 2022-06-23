/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOFactory;
import Model.Account.Account;
import Model.Doctors.Doctor;
import Model.MedicalRecord.MedicalRecord;
import Model.Patient.Patient;
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
@WebServlet(name = "ViewMedicalRecordServlet", urlPatterns = {"/ViewMedicalRecordServlet"})
public class ViewMedicalRecordServlet extends HttpServlet {

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
            out.println("<title>Servlet ViewMedicalRecordServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewMedicalRecordServlet at " + request.getContextPath() + "</h1>");
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
        doPost(request, response);
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
         String nextUrl = "/error.jsp";
        Account acc= (Account) request.getSession().getAttribute("acc");
              
        try {
            if (request.getParameter("action").equals("viewlistMR")&&request.getParameter("userID").equals(acc.getUser()))
            {
                String userID = request.getParameter("userID");
             
                Patient patient = DAOFactory.getPatientDao().getSpecificPatient(userID);
                Doctor doctor = DAOFactory.getDoctorDao().getSpecificDoctor(userID);
             
                if (patient !=null) {
                     List<MedicalRecord> mrs = DAOFactory.getMedicalRecordDAO().getAllMedicalRecordByPatient(userID);
                     
                 if (mrs.size() >= 0)
                {
                    request.setAttribute("mrs", mrs);
                    nextUrl = "/MyMedicalRerordPaient.jsp";
                    getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                }
                } else if (doctor!=null){
                  List<MedicalRecord> mrs = DAOFactory.getMedicalRecordDAO().getAllMedicalRecordByDoctor(userID);
                    if (mrs.size() >= 0)
                {
                    request.setAttribute("mrs", mrs);
                    nextUrl = "/MyMedicalRerordDoctor.jsp";
                    getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                }
            }        
            } else if (request.getParameter("action").equals("viewMRDetail")&&request.getParameter("userID").equals(acc.getUser())) {
                   String idmr = request.getParameter("idmr");
                   MedicalRecord MR = DAOFactory.getMedicalRecordDAO().getAnMedicalRecord(idmr);
                   request.setAttribute("mr", MR);
                   
                   Account account= (Account) request.getSession().getAttribute("acc"); 
                  
                   Patient patient = DAOFactory.getPatientDao().getSpecificPatient(account.getUser());
                   Doctor doctor = DAOFactory.getDoctorDao().getSpecificDoctor(account.getUser());
                   if (patient!=null) {
                     nextUrl = "/MRDetailPatient.jsp";
                   getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                } else if (doctor!=null){
                    nextUrl = "/MRDetailDoctor.jsp";
                   getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                } else {
                    getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                }
                   
                  
            }
        } catch (IOException | ServletException e) {
            // print the exception so we can see it while testing the application
            // good idea to print to the console since it cosumes resources and will not
            // be seen.
            System.out.println(e);
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
