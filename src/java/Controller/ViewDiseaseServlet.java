/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOFactory;
import Model.Account.Account;
import Model.Doctors.Doctor;
import Model.MedicalRecord.Disease;
import Model.MedicalRecord.MR_Disease;
import Model.Patient.Patient;

import Model.Staff.Staff;
import java.io.IOException;

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
@WebServlet(name = "ViewDiseaseServlet", urlPatterns = {"/ViewDiseaseServlet"})
public class ViewDiseaseServlet extends HttpServlet {

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
       String nextUrl = "/error.jsp"; 
        try {
           Account account = (Account) request.getSession().getAttribute("acc");
           Patient patient = DAOFactory.getPatientDao().getSpecificPatient(account.getUser());
           Staff staff = DAOFactory.getStaffDAO().getSpecificStaff(account.getUser());
           Doctor doctor = DAOFactory.getDoctorDao().getSpecificDoctor(account.getUser());
            if (request.getParameter("action").equals("viewdiseases")) {
                String IDMR = request.getParameter("IDMR");
                List<MR_Disease> mrdisease = DAOFactory.getMR_DiseaseDAO().getMR_DiseaseByMR(IDMR);
                if (doctor != null) {
                    if (mrdisease.size() >= 0) {
                        request.setAttribute("mrdisease", mrdisease);
                        request.getSession().setAttribute("IDMR", IDMR);
                        nextUrl = "/MRDiseaseListDoctor.jsp";
                        getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                    }
                }else if (patient !=null) {
                    
                    if (mrdisease.size() >= 0) {
                        System.out.println(mrdisease);
                        request.setAttribute("mrdisease", mrdisease);
                        nextUrl = "/MRDiseaseListPatient.jsp";
                        getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                    }
                }
    
          } else if (request.getParameter("action").equals("viewDiseasesDetail")) {
                               String DIID = request.getParameter("IDDI");
                    if (DIID != null) {
                        Disease disease = DAOFactory.getDiseaseDAO().getADisease(DIID);
                         if (doctor != null) {
                              
                                   request.setAttribute("disease", disease);
                                   
                                   nextUrl = "/MRDiseaseDetailsPatient.jsp";
                                   getServletContext().getRequestDispatcher(nextUrl).forward(request, response);        
                                    
                        } else if (staff !=null) {
                                    
                                   request.setAttribute("disease", disease);
                                   nextUrl = "/MRDiseaseDetailsPatient.jsp";
                                   getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                           
                        } else if (patient != null){
                                    
                                         request.setAttribute("disease", disease);
                                        nextUrl = "/MRDiseaseDetails.jsp";
                                        getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
                             
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
        processRequest(request, response);
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
        processRequest(request, response);
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
