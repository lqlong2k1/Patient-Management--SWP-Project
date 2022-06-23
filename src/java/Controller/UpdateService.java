/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOFactory;
import Model.Service.Service;
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
@WebServlet(name = "UpdateService", urlPatterns = {"/UpdateService"})
public class UpdateService extends HttpServlet {

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
            out.println("<title>Servlet UpdateService</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateService at " + request.getContextPath() + "</h1>");
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
       String serviceID = request.getParameter("serviceID");
          Service serviceDetail = DAOFactory.getServiceDAO().getSpecificService(serviceID);
                     if (serviceDetail != null) {
                                          request.setAttribute("IDService", serviceDetail.getIDService());
                                            request.setAttribute("nameService", serviceDetail.getNameService());
                                               request.setAttribute("priceService", serviceDetail.getPriceService());
                                             request.setAttribute("decsriptionService", serviceDetail.getDecsription());
    }
                     request.getRequestDispatcher("/UpdateService.jsp").forward(request, response);
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
       String serviceID = request.getParameter("IDService");
       String serviceName = request.getParameter("nameService");
       float servicePrice = Float.parseFloat(request.getParameter("priceService"));
       String description = request.getParameter("decsriptionService");
       Service service = new Service();
     
       service.setIDService(serviceID);
       service.setNameService(serviceID);
       service.setPriceService(servicePrice);
       service.setDecsription(description);
          System.out.println(service);
       DAOFactory.getServiceDAO().updateService(service);
        System.out.println(DAOFactory.getServiceDAO().getSpecificService(serviceID));
        response.sendRedirect("ViewServiceServlet?action=viewServiceDetail&serviceID="+serviceID);
       
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
