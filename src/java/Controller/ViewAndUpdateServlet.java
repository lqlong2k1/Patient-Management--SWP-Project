/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOFactory;
import DAO.Doctor.DoctorDao;
import DAO.Patient.PatientDAO;
import DAO.Staff.StaffModel;
import Model.Account.Account;
import Model.Doctors.Doctor;
import Model.Patient.Patient;
import Model.Staff.Staff;
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
@WebServlet(name = "ViewAndUpdateServlet", urlPatterns = {"/ViewAndUpdateServlet"})
public class ViewAndUpdateServlet extends HttpServlet {

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
            out.println("<title>Servlet ViewAndUpdateServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewAndUpdateServlet at " + request.getContextPath() + "</h1>");
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
        Account acc= (Account) request.getSession().getAttribute("acc");
        PatientDAO patientDAO=DAOFactory.getPatientDao();  
        StaffModel staffModel=DAOFactory.getStaffDAO();
        DoctorDao doctorDao =DAOFactory.getDoctorDao();
        
        Patient patient = patientDAO.getSpecificPatient(acc.getUser());
        Staff staff= staffModel.getSpecificStaff(acc.getUser());
        Doctor doctor = doctorDao.getSpecificDoctor(acc.getUser());
        
        if (patient!=null) {
               
                request.setAttribute("UserID", patient.getID_User());
                request.setAttribute("Phone", patient.getPhone());
                request.setAttribute("Address", patient.getAddressUser());
                if (patient.getGender()) {request.setAttribute("male", "checked");
                
                } else {request.setAttribute("female", "checked");}
                request.setAttribute("cccd", patient.getCCCD());
                request.setAttribute("email", patient.getEmail());
                request.setAttribute("codebhyt", patient.getCODEBHYT());
                request.setAttribute("name", patient.getUser_Name());
                request.setAttribute("Age", patient.getUser_AGE());
                request.setAttribute("DOB", patient.getDOB());
                request.setAttribute("Career", patient.getPATIENT_CAREER());
                request.setAttribute("Password", acc.getPassword());
                request.getRequestDispatcher("ViewMyprofilePatient.jsp").forward(request, response);
            } else if (staff!=null) {
                request.setAttribute("UserID", staff.getID_User());
                request.setAttribute("FacultyID", staff.getFacultyID());
                request.setAttribute("Phone", staff.getPhone());
                request.setAttribute("Address", staff.getAddressUser());
                if (staff.getGender()) {request.setAttribute("male", "checked");
                
                } else {request.setAttribute("female", "checked");}
                request.setAttribute("cccd", staff.getCCCD());
                request.setAttribute("email", staff.getEmail());
                request.setAttribute("name", staff.getUser_Name());
                request.setAttribute("Age", staff.getUser_AGE());
                request.setAttribute("DOB", staff.getDOB());
                request.setAttribute("Password", acc.getPassword());
                request.getRequestDispatcher("ViewMyprofileStaff.jsp").forward(request, response);
            } else if (doctor!=null) {              
                 request.setAttribute("UserID", doctor.getID_User());
                request.setAttribute("FacultyID", doctor.getIdfaculty());
                request.setAttribute("Phone", doctor.getPhone());
                request.setAttribute("Address", doctor.getAddressUser());
                if (doctor.getGender()) {request.setAttribute("male", "checked");
                
                } else {request.setAttribute("female", "checked");}
                request.setAttribute("cccd", doctor.getCCCD());
                request.setAttribute("email", doctor.getEmail());
                request.setAttribute("name", doctor.getUser_Name());
                request.setAttribute("Age", doctor.getUser_AGE());
                request.setAttribute("DOB", doctor.getDOB());
                request.setAttribute("Password", acc.getPassword());
                request.getRequestDispatcher("ViewMyprofileDoctor.jsp").forward(request, response);
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
        String UserID = request.getParameter("UserID");
        String UserName = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("Age"));
        String DOB = request.getParameter("DOB");
        String Address =request.getParameter("Address");
        String Phone = request.getParameter("Phone");
        String email = request.getParameter("email");
        String cccd = request.getParameter("cccd");
        boolean gender;
        if (request.getParameter("gender").equals("male")) {
            gender = true;
        } else 
        {
            gender = false;
        }
        String password = request.getParameter("Password");
        Account account = (Account) request.getSession().getAttribute("acc");
        account.setPassword(password);
        DAOFactory.getAccountDAO().updatePasswordAccount(account);
         PatientDAO patientDAO=DAOFactory.getPatientDao();  
        StaffModel staffModel=DAOFactory.getStaffDAO();
        DoctorDao doctorDao =DAOFactory.getDoctorDao();
        
        Patient patient = patientDAO.getSpecificPatient(UserID);
        Staff staff= staffModel.getSpecificStaff(UserID);
        Doctor doctor = doctorDao.getSpecificDoctor(UserID);
        if (patient!=null){
            String Career = request.getParameter("Career");
            String bhyt = request.getParameter("codebhyt");
            patient.setAddressUser(Address);
            patient.setCCCD(cccd);
            patient.setCODEBHYT(bhyt);
            patient.setDOB(Date.valueOf(DOB));
            patient.setEmail(email);
            patient.setGender(gender);
            patient.setID_User(UserID);
            patient.setPATIENT_CAREER(Career);
            patient.setPhone(Phone);
            patient.setUser_AGE(age);
            patient.setUser_Name(UserName);
            patient.setUser_ROLE("Patient");
            DAOFactory.getPatientDao().updatePatient(patient);
        } else if (staff!=null) {
            String IDFaculty = request.getParameter("FacultyID");
            staff.setAddressUser(Address);
            staff.setCCCD(cccd);
            staff.setFacultyID(IDFaculty);
            staff.setDOB(Date.valueOf(DOB));
            staff.setEmail(email);
            staff.setGender(gender);
            staff.setID_User(UserID);        
            staff.setPhone(Phone);
            staff.setUser_AGE(age);
            staff.setUser_Name(UserName);

            staff.setUser_ROLE("Staff");
            DAOFactory.getStaffDAO().updateStaff(staff);
        } else if (doctor!=null){
             String IDFaculty = request.getParameter("FacultyID");
            doctor.setAddressUser(Address);
            doctor.setCCCD(cccd);
            doctor.setIdfaculty(IDFaculty);
            doctor.setDOB(Date.valueOf(DOB));
            doctor.setEmail(email);
            doctor.setGender(gender);
            doctor.setID_User(UserID);
            doctor.setPhone(Phone);
            doctor.setUser_AGE(age);
            doctor.setUser_Name(UserName);
            doctor.setUser_ROLE("Doctor");
            DAOFactory.getDoctorDao().updateDoctor(doctor);
        }
        response.sendRedirect("ViewAndUpdateServlet");
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
