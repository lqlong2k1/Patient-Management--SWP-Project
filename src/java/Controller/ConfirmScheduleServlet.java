/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOFactory;
import Model.Schedule.Schedule;
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
@WebServlet(name = "ConfirmScheduleServlet", urlPatterns = {"/ConfirmScheduleServlet"})
public class ConfirmScheduleServlet extends HttpServlet {

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
            out.println("<title>Servlet ConfirmScheduleServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConfirmScheduleServlet at " + request.getContextPath() + "</h1>");
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
            switch (request.getParameter("action")) {
                case "accept":
                    String schIdUpdate = request.getParameter("id");
                    if (schIdUpdate != null) {
                        Schedule updatSchedule = DAOFactory.getScheduleDAO().getSpecificSchedule(Integer.parseInt(schIdUpdate));
                        updatSchedule.setConfirm("Confirmed");
                        DAOFactory.getScheduleDAO().updateSchedule(updatSchedule);
                        response.sendRedirect(request.getContextPath() + "/ViewScheduleServlet?action=viewschedules");
                    }   break;
                case "delete":
                    String schIdDelete = request.getParameter("id");
                    if (schIdDelete != null) {
                        DAOFactory.getScheduleDAO().removeSchedule(Integer.parseInt(schIdDelete));
                        response.sendRedirect(request.getContextPath() + "/ViewScheduleServlet?action=viewschedules");
                    }   break;
                default: 
                    break;
            }
        } catch (IOException e) {
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
