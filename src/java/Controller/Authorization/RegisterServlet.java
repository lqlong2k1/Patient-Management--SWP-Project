/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Authorization;



import DAO.Account.Account_LogDAO;
import DAO.DAOFactory;
import DAO.Patient.PatientDAO;
import Model.Account.Account;
import Model.Account.Account_Log;
import Model.Patient.Patient;
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
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

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
            out.println("<title>Servlet RegisterServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath() + "</h1>");
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
       request.getRequestDispatcher("Register.jsp").forward(request, response);
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
       String fullName = request.getParameter("fullName");
        int age = Integer.parseInt(request.getParameter("age"));

       
      
          String  dob=request.getParameter("dob");
        
        
        String address = request.getParameter("address");
        String tel = request.getParameter("tel");
        String email = request.getParameter("email");
        String cccd = request.getParameter("cccd");
        String career = request.getParameter("career");
        String bhyt = request.getParameter("bhyt");
        boolean gender;
        if (request.getParameter("gender").equals("male")) {
            gender = true;
        } else 
        {
            gender = false;
        }
        
        String password = request.getParameter("password");
        Patient patient = new Patient();
        patient.setUser_Name(fullName);
        patient.setUser_AGE(age);
        patient.setGender(gender);
        patient.setDOB(Date.valueOf(dob));
        patient.setAddressUser(address);
        patient.setPhone(tel);
        patient.setEmail(email);
        patient.setCCCD(cccd);
        patient.setPATIENT_CAREER(career);
        patient.setCODEBHYT(bhyt);
        patient.setUser_ROLE("Patient");
        System.out.println(patient);
    
 Account account = new Account();
     PatientDAO patientDao = DAOFactory.getPatientDao();
 account.setUser(patientDao.insertPatient(patient));  
 account.setPassword(password);
        int ID_Acc = DAOFactory.getAccountDAO().newAccount(account);
       Account_Log account_Log = (Account_Log) DAOFactory.getAccount_LogDAO();
       account_Log.setId_log(ID_Acc);
     account_Log.setNote_Log("Register");
        Account_LogDAO account_LogDAO = DAOFactory.getAccount_LogDAO();
        account_LogDAO.newAccount_Log(account_Log);

      request.setAttribute("MSG","Your UserID" + patient.getID_User());
      request.getRequestDispatcher("SuccessRegister.jsp").forward(request, response);
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
