/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Authorization;

import DAO.Account.AccountDAO;
import DAO.DAOFactory;
import DAO.Doctor.DoctorDao;
import DAO.Patient.PatientDAO;
import DAO.Staff.StaffModel;
import Model.Account.Account;
import Model.Account.Account_Log;
import Model.Doctors.Doctor;
import Model.Patient.Patient;
import Model.Staff.Staff;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
       RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Login.jsp");
        dispatcher.forward(request, response);
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
        String userID= request.getParameter("UserID");
        String Pass= request.getParameter("Password");
        //
        
        AccountDAO accdao = DAOFactory.getAccountDAO();
        PatientDAO patientDAO=DAOFactory.getPatientDao();  
        StaffModel staffModel=DAOFactory.getStaffDAO();
        DoctorDao doctorDao =DAOFactory.getDoctorDao();
        //
        Account account = accdao.getSpecificAccountbyUserID(userID);
        //
        Patient patient = patientDAO.getSpecificPatient(userID);
        Staff staff= staffModel.getSpecificStaff(userID);
        Doctor doctor = doctorDao.getSpecificDoctor(userID);
        
        if (account.getPassword().equals(Pass)) {
            request.getSession().setAttribute("acc", account);
              if (patient!=null) {

           
                request.getRequestDispatcher("/TransactionPatient.jsp").forward(request, response);
            } else if (staff!=null) {
         
                request.getRequestDispatcher("/TransactionStaff.jsp").forward(request, response);
            } else if (doctor!=null) {              
                request.getRequestDispatcher("/TransactionDoctor.jsp").forward(request, response); 
            } else if (userID.equals("admin")){
                request.getRequestDispatcher("/TransactionAdmin.jsp").forward(request, response);
            }
        Account_Log acclog = new Account_Log("Log in", account.getID_ACC());   
        } else {
            request.setAttribute("MSG", "Login Failed");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
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
