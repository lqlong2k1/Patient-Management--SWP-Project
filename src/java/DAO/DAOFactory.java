/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import DAO.Account.AccountDAO;
import DAO.Account.Account_LogDAO;
import DAO.Account.Account_LogDAOimpl;
import DAO.Account.AccountrDAOimplDAO;
import DAO.Bill.BillDAO;
import DAO.Bill.IBillDAO;
import DAO.Doctor.DoctorDao;
import DAO.Patient.PatientDAO;
import DAO.Doctor.DoctorDaoImpl;
import DAO.Faculty.FacultyDAO;
import DAO.Faculty.IFacultyDAO;
import DAO.MedicalRecord.DiseaseDAO;
import DAO.MedicalRecord.IDiseaseDAO;
import DAO.MedicalRecord.IMR_DiseaseDAO;
import DAO.MedicalRecord.IMedicalDAO;
import DAO.MedicalRecord.IMedicalRecordDAO;
import DAO.MedicalRecord.IPrescriptionDAO;
import DAO.MedicalRecord.IPrescription_DetailDAO;
import DAO.MedicalRecord.MR_DiseaseDAO;
import DAO.MedicalRecord.MedicalDAO;
import DAO.MedicalRecord.MedicalRecordDAO;
import DAO.MedicalRecord.PrescriptionDAO;
import DAO.MedicalRecord.Prescription_DetailDAO;
import DAO.Patient.PatientlmplDAO;
import DAO.Schedule.IScheduleDAO;
import DAO.Schedule.ScheduleDAO;
import DAO.Service.IServiceDao;
import DAO.Service.ServiceDao;
import DAO.Staff.StaffImplModel;
import DAO.Staff.StaffModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/**
 *
 * @author phucl
 */
public class DAOFactory {
 
    public static final String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static final String DATABASE_NAME = "PatientManagement";
    public static final String USER_ID = "sa";
    public static final String PASSWORD = "123";
    public static final String URL = "jdbc:sqlserver://DESKTOP-0P7INPS\\SQLEXPRESS:1433;databaseName=PatientManagement" ;
    
    public static Connection createConnection() {
        try {
            InitialContext initialContext = new InitialContext();
            Context context = (Context) initialContext.lookup("java:comp/env");
            //The JDBC Data source that we just created
            DataSource ds = (DataSource) context.lookup("jdbc/mydb");
            return ds.getConnection();
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
        public static void closeConnection(Connection con, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public static DoctorDao getDoctorDao() {
        return new DoctorDaoImpl();
    }
    
    // get Any Object here
         public static PatientDAO getPatientDao() {
        return new PatientlmplDAO() ;
    }
       public static Account_LogDAO getAccount_LogDAO() {
        return new  Account_LogDAOimpl() ;
    }
       public static AccountDAO getAccountDAO() {
        return new  AccountrDAOimplDAO() ;
    }
       public static IBillDAO getBillDAO() {
        return new  BillDAO() ;
    }
      public static StaffModel getStaffDAO() {
        return new  StaffImplModel() ;
    }
       public static IServiceDao getServiceDAO() {
        return new  ServiceDao() ;
    }
    public static IMedicalRecordDAO getMedicalRecordDAO() {
        return new  MedicalRecordDAO() ;
    }
      public static IMedicalDAO getMedicalDAO() {
        return new  MedicalDAO() ;
    }
        public static IDiseaseDAO getDiseaseDAO() {
        return new  DiseaseDAO() ;
    }
        public static IScheduleDAO getScheduleDAO(){
            return new ScheduleDAO();
        }
        public static IFacultyDAO getFacultyDAO(){
            return new FacultyDAO();
        }
           public static IMR_DiseaseDAO getMR_DiseaseDAO(){
            return new MR_DiseaseDAO();
        }
           public static IPrescriptionDAO getPrescriptionDAO(){
               return new PrescriptionDAO();
           }
           public static IPrescription_DetailDAO getPrescription_DetailDAO(){
               return new Prescription_DetailDAO();
           }
}
