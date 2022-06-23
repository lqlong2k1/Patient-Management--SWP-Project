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
import Model.Schedule.Schedule;
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
@WebServlet(name = "ViewScheduleServlet", urlPatterns = {"/ViewScheduleServlet"})
public class ViewScheduleServlet extends HttpServlet {

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
            out.println("<title>Servlet ViewScheduleServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewScheduleServlet at " + request.getContextPath() + "</h1>");
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
           Account account = (Account) request.getSession().getAttribute("acc");
           Patient patient = DAOFactory.getPatientDao().getSpecificPatient(account.getUser());
           Staff staff = DAOFactory.getStaffDAO().getSpecificStaff(account.getUser());
           Doctor doctor = DAOFactory.getDoctorDao().getSpecificDoctor(account.getUser());
            if (request.getParameter("action").equals("viewschedules")) {
                    
                if (doctor != null) {
                    List<Schedule> schedules = DAOFactory.getScheduleDAO().getAllSchedulesfollowbyStaff(account.getUser());
                    System.out.println(schedules);
                    if (schedules.size() >= 0) {
                        request.setAttribute("schedules", schedules);
                        nextUrl = "/ScheduleListDoctor.jsp";
                        getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                    }
                } else if (staff !=null) {
                    List<Schedule> schedules = DAOFactory.getScheduleDAO().getAllSchedulesfollowbyStaff(account.getUser());
                    if (schedules.size() >= 0) {
                        request.setAttribute("schedules", schedules);
                        nextUrl = "/ScheduleListStaff.jsp";
                        getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                    }  
                }else if (patient !=null) {
                    List<Schedule> schedules = DAOFactory.getScheduleDAO().getAllSchedulesfollowbyPatient(account.getUser());
                    System.out.println(schedules);
                    if (schedules.size() >= 0) {
                        request.setAttribute("schedules", schedules);
                        nextUrl = "/ScheduleListPatient.jsp";
                        getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                    }
                }
    
          } else if (request.getParameter("action").equals("viewscheduledetail")) {
                               String scheduleId = request.getParameter("id");
                    if (scheduleId != null) {
                        Schedule schedule = DAOFactory.getScheduleDAO().getSpecificSchedule(Integer.parseInt(scheduleId));
                         if (doctor != null) {
                              if (doctor.getID_User().equals(schedule.getID_Staff()) || schedule.getID_Staff()==null) {
                                   System.out.println("1654654686");
                                   request.setAttribute("schedule", schedule);
                                   nextUrl = "/ScheduleDetailDoctor.jsp";
                                   getServletContext().getRequestDispatcher(nextUrl).forward(request, response);        
                             } else  {
                                 getServletContext().getRequestDispatcher(nextUrl).forward(request, response); 
                             }
                            
                        } else if (staff !=null) {
                                    if (staff.getID_User().equals(schedule.getID_Staff())|| schedule.getID_Staff()==null) {
                                        request.setAttribute("schedule", schedule);
                                        nextUrl = "/ScheduleDetailStaff.jsp";
                                        getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                             } else {
                                        getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                                    }
                        } else if (patient != null){
                                     if (patient.getID_User().equals(schedule.getID_Patient())) {
                                         request.setAttribute("schedule", schedule);
                                        nextUrl = "/ScheduleDetailPatient.jsp";
                                        getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                             } else {
                                         getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                                     }
                        }
                        
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
