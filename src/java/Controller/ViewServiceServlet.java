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
import Model.Service.Service;
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
@WebServlet(name = "ViewServiceServlet", urlPatterns = {"/ViewServiceServlet"})
public class ViewServiceServlet extends HttpServlet {

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
            out.println("<title>Servlet ViewListServiceServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewListServiceServlet at " + request.getContextPath() + "</h1>");
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
        String nextUrl = "/error.jsp";
        try {
            if (request.getParameter("action").equals("viewservices"))
            {
                List<Service> services = DAOFactory.getServiceDAO().getAllService();
                Account account= (Account) request.getSession().getAttribute("acc");
                if (account!=null) {
                    Patient patient = DAOFactory.getPatientDao().getSpecificPatient(account.getUser());
                    Doctor doctor = DAOFactory.getDoctorDao().getSpecificDoctor(account.getUser());
                    Staff staff = DAOFactory.getStaffDAO().getSpecificStaff(account.getUser());
                if (patient!=null) {

                  
                 if (services.size() >= 0)
                {
                    request.setAttribute("services", services);
                    nextUrl = "/ServicesListPatient.jsp";
                    getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                }
            } else if (staff!=null) {
         
                 if (services.size() >= 0)
                {
                    request.setAttribute("services", services);
                    nextUrl = "/ServicesListStaff.jsp";
                    getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                }
            } else if (doctor!=null) {              
                 if (services.size() >= 0)
                {
                    request.setAttribute("services", services);
                    nextUrl = "/ServicesListDoctor.jsp";
                    getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                } 
            } else if (account.getUser().equals("admin")) {
                 if (services.size() >= 0)
                {
                    request.setAttribute("services", services);
                    nextUrl = "/ServicesListAdmin.jsp";
                    getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                }       
                    } 
                 
            }   
                   else{if (services.size() >= 0)
                               {
                    request.setAttribute("services", services);
                    nextUrl = "/ServicesListVisitor.jsp";
                    getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                
                    
                           }
                        }
    
                
            } else if (request.getParameter("action").equals("viewServiceDetail")) {
                String serviceID = request.getParameter("serviceID");
                  Service serviceDetail = DAOFactory.getServiceDAO().getSpecificService(serviceID);
                     if (serviceDetail != null) {
                                          request.setAttribute("IDService", serviceDetail.getIDService());
                                            request.setAttribute("nameService", serviceDetail.getNameService());
                                               request.setAttribute("priceService", serviceDetail.getPriceService());
                                             request.setAttribute("decsriptionService", serviceDetail.getDecsription());
                                           request.setAttribute("idf", serviceDetail.getIdf());
                                 }
                  Account account= (Account) request.getSession().getAttribute("acc"); 
                  if (account!=null) {
                    Patient patient = DAOFactory.getPatientDao().getSpecificPatient(account.getUser());
                    Doctor doctor = DAOFactory.getDoctorDao().getSpecificDoctor(account.getUser());
                    Staff staff = DAOFactory.getStaffDAO().getSpecificStaff(account.getUser());
                if (patient!=null) {

                  
             
             
                    nextUrl = "/ServiceDetailsPatient.jsp";
                    getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                
            } else if (staff!=null) {
         
                
                   
                    nextUrl = "/ServiceDetailsStaff.jsp";
                    getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                
            } else if (doctor!=null) {              
                   
                    nextUrl = "/ServiceDetailsDoctor.jsp";
                    getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                 
            } else if (account.getUser().equals("admin")) {
                          
                    nextUrl = "/ServiceDetailsAdmin.jsp";
                    getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
            }
          
                  }
                  else {
                          nextUrl = "/ServiceDetailsVisitor.jsp";
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
