/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Doctor;

import DAO.DAOFactory;
import Model.Patient.Patient;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
@WebServlet(name = "ViewListPatientServlet", urlPatterns = {"/ViewListPatientServlet"})
public class ViewListPatientServlet extends HttpServlet {

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
            out.println("<title>Servlet ViewListPatientServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewListPatientServlet at " + request.getContextPath() + "</h1>");
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
        /*
         * simplify this so that it always requires two parameters, userid and action
         * action is view or edit. If edit then the userID of the session(user) must be same as userID for profile
         * since you can only edit your own.
         * all urls coming to this page must contain both parameters or get error.
         */
        String nextUrl = "/error.jsp";
//        HttpSession session = request.getSession();
//        
//        
//        //get user out of session. If they don't exist then send them back to the login page.
//		//kill the session while you're at it.
//
//        if (session.getAttribute("acc") == null)
//     {
//          nextUrl = "/login.jsp";
//          session.invalidate();
//           response.sendRedirect(request.getContextPath() + nextUrl);
//           return; // return prevents an error
//        }
//        
        // Send list patient if action = view patients
        try {
            if (request.getParameter("action").equals("viewpatients"))
            {
                List<Patient> patients = DAOFactory.getPatientDao().getAllPatient();
                if (patients.size() >= 0)
                {
                    request.setAttribute("patients", patients);
                    nextUrl = "/PatientList.jsp";
                    getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                }
            } else     if (request.getParameter("action").equals("viewpatientprofile")) {
                String userId = request.getParameter("id");
                if (userId != null) {
                    Patient patient = DAOFactory.getPatientDao().getSpecificPatient(userId);            
                    request.setAttribute("patient", patient);
                    nextUrl = "/ViewPatientProfile.jsp";
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

    @Override
    public String getServletInfo() {
        return "Doctor action will come here.";
    }// </editor-fold>

}
