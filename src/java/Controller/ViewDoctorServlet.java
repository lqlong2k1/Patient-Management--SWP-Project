/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOFactory;
import Model.Account.Account;
import Model.Doctors.Doctor;
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
@WebServlet(name = "ViewDoctorServlet", urlPatterns = {"/ViewDoctorServlet"})
public class ViewDoctorServlet extends HttpServlet {

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
            out.println("<title>Servlet ViewDoctorServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewDoctorServlet at " + request.getContextPath() + "</h1>");
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
        try {
            if (request.getParameter("action").equals("viewdoctors"))
            {
                    
            List<Doctor> doctors = DAOFactory.getDoctorDao().getAllDoctor();
    
     
                Account account= (Account) request.getSession().getAttribute("acc");
                if (account!=null) {
                    Patient patient = DAOFactory.getPatientDao().getSpecificPatient(account.getUser());
                    Doctor doctor = DAOFactory.getDoctorDao().getSpecificDoctor(account.getUser());
                    Staff staff = DAOFactory.getStaffDAO().getSpecificStaff(account.getUser());
                if (patient!=null) {

                  
                 if (doctors.size() >= 0)
                {
                    request.setAttribute("listD", doctors);
                    nextUrl = "/DoctorListPatient.jsp";
                    getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                }
            } else if (staff!=null) {
         
                 if (doctors.size() >= 0)
                {
                     request.setAttribute("listD", doctors);
                    nextUrl = "/DoctorListStaff.jsp";
                    getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                }
            } else if (doctor!=null) {              
                 if (doctors.size() >= 0)
                {
                request.setAttribute("listD", doctors);
                    nextUrl = "/DoctorListDoctor.jsp";
                    getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                } 
            } else if (account.getUser().equals("admin")) {
                 if (doctors.size() >= 0)
                {
                    request.setAttribute("listD", doctors);
                    nextUrl = "/DoctorsListAdmin.jsp";
                    getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                }       
                    } 
                 
            }   
                   else{if (doctors.size() >= 0)
                               {
                    request.setAttribute("listD", doctors);
                    nextUrl = "/DoctorListVisitor.jsp";
                    getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                
                    
                           }
                        }
    
                
       }else if (request.getParameter("action").equals("viewDoctorDetail")) {
                String doctorID = request.getParameter("dID");
                  Doctor doctorDetail = DAOFactory.getDoctorDao().getSpecificDoctor(doctorID);
                     if (doctorDetail != null) {
                                           request.setAttribute("ddt", doctorDetail);
                     if (doctorDetail.getGender()) {request.setAttribute("male", "checked");
                
                } else {request.setAttribute("female", "checked");}            
                     }
                  Account account= (Account) request.getSession().getAttribute("acc"); 
                  if (account!=null) {
                    Patient patient = DAOFactory.getPatientDao().getSpecificPatient(account.getUser());
                    Doctor doctor = DAOFactory.getDoctorDao().getSpecificDoctor(account.getUser());
                    Staff staff = DAOFactory.getStaffDAO().getSpecificStaff(account.getUser());
                if (patient!=null) {
                    nextUrl = "/DoctorDetailPatient.jsp";
                    getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                
                                   } else if (staff!=null) {
         
                
                   
                                      nextUrl = "/DoctorDetailStaff.jsp";
                                      getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                
                                   } else if (doctor!=null) {              
                   
                                       nextUrl = "/DoctorDetailDoctor.jsp";
                                       getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                 
                                   } else if (account.getUser().equals("admin")) {
                          
                    nextUrl = "/DoctorDetailAdmin.jsp";
                    getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
            }
          
                  }
                  else {
                          nextUrl = "/DoctorDetailVisitor.jsp";
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
