/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Patient;

import DAO.DAOFactory;
import Model.Patient.Patient;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class PatientlmplDAO implements PatientDAO {
    private static List<Patient> Patients;
    private static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;
    

    /**
     *
     * @param patient
    
     * @return
     */
 
     @Override
    public  String insertPatient(Patient patient){
      String ID_PATIENT="";
        try { 
           Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);         
            String query = " Insert into Patient(Phone,AddressUSER,GENDER,CCCD,EMAIL,codebhyt,USER_NAME,USER_AGE,USER_ROLE,DOB,PATIENT_CAREER) "
                    + "output inserted.ID_USER \n" +
                     "values(?,?,?,?,?,?,?,?,?,?,?)  ";   
            ps = con.prepareStatement(query);
            ps.setString(1, patient.getPhone());
            ps.setString(2, patient.getAddressUser());
            ps.setBoolean(3, patient.getGender());
            ps.setString(4, patient.getCCCD());
            ps.setString(5,patient.getEmail());
            ps.setString(6,patient.getCODEBHYT());
            ps.setString(7,patient.getUser_Name());
            ps.setInt(8, patient.getUser_AGE());
            ps.setString(9, patient.getUser_ROLE());
            ps.setDate(10, patient.getDOB());
            ps.setString(11, patient.getPATIENT_CAREER());
           rs = ps.executeQuery();
            if (rs.next())
            ID_PATIENT= rs.getString(1);
                
        } catch (Exception e) {
        System.out.print(e);
        }
       return ID_PATIENT;
    }      
    
    
     @Override
    public void removePatient(String userID){
           try {  
             Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);         
         
            String query = "Delete FROM PATIENT where ID_USER=?  ";       
            ps = con.prepareStatement(query);
            ps.executeUpdate(); 
            
          
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
     @Override
    public  List<Patient> getAllPatient(){
      Patients = new ArrayList<>();
        try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
            ps = con.prepareStatement("SELECT * FROM Patient");
            rs = ps.executeQuery();
            while (rs.next())
            {
                Patient acc = new Patient();
               acc.setID_User(rs.getString(1));
                acc.setPhone(rs.getString(2));
                acc.setAddressUser(rs.getString(3));
                acc.setGender(rs.getBoolean(4));
                acc.setCCCD(rs.getString(5));
                acc.setEmail(rs.getString(6));
                acc.setCODEBHYT(rs.getString(7));
                acc.setUser_Name(rs.getString(8));
                acc.setUser_AGE(rs.getInt(9));
                acc.setDOB(rs.getDate(10));
                acc.setPATIENT_CAREER(rs.getString(11));
                acc.setUser_ROLE(rs.getString(12));  
                Patients.add(acc);
           }
            DAOFactory.closeConnection(con, ps, rs);
            return Patients;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PatientlmplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
     
    }

     @Override
   public Patient getSpecificPatient(String userID){
 
               ListIterator<Patient> patientInterator = getAllPatient().listIterator();
               
        while (patientInterator.hasNext())
        {
            Patient thisPatient = ((Patient) patientInterator.next());
            
            if (thisPatient.getID_User().equals(userID)) {
                return thisPatient;
            }
        }
        return null;

    }
       
    
     @Override
    public  Patient updatePatient(Patient patient){
             try {
       
              Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);         
        
            String query = " Update Patient set PAtient_Career=?,AddressUser=?,Phone=?,Gender=?,cccd=?,email=?,codebhyt=?,user_name=?,user_age=?,DOB=? where ID_user=?"; 

            ps = con.prepareStatement(query);
            ps.setString(1, patient.getPATIENT_CAREER());
            ps.setString(2, patient.getAddressUser());
            ps.setString(3, patient.getPhone());
            ps.setBoolean(4, patient.getGender());
            ps.setString(5, patient.getCCCD());
            ps.setString(6, patient.getEmail());
            ps.setString(7, patient.getCODEBHYT());
            ps.setString(8, patient.getUser_Name());
            ps.setInt(9, patient.getUser_AGE());

            ps.setDate(10, patient.getDOB());
            ps.setString(11, patient.getID_User());
            ps.executeUpdate();
            
         
        } catch (Exception e) {
        System.out.print(e);
        }
       return patient;
        
    }
    
    @Override
    public List<Patient> searchbyName(String txtName){
       List<Patient> list = new ArrayList<>();
          try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
            ps = con.prepareStatement("SELECT * FROM Patient where user_name like ? ");
            ps.setString(1, "%"+txtName+"%");
            rs = ps.executeQuery();
            while (rs.next())
            {
                Patient patient = new Patient();                
                patient.setID_User(rs.getString(1));
                patient.setPhone(rs.getString(2));
                patient.setAddressUser(rs.getString(3));
                patient.setGender(rs.getBoolean(4));
                patient.setCCCD(rs.getString(5));
                patient.setEmail(rs.getString(6));
                patient.setCODEBHYT(rs.getString(7));
                patient.setUser_Name(rs.getString(8));
                patient.setUser_AGE(rs.getInt(9));
                patient.setDOB(rs.getDate(10));
                patient.setPATIENT_CAREER(rs.getString(11));
                patient.setUser_ROLE(rs.getString(12));
                list.add(patient);
           }
           con.close();
            return list;       
        } catch (Exception ex) {
            Logger.getLogger(PatientlmplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
         
        }
    @Override
           public List<Patient> searchbyID(String txtId){
         List<Patient> list = new ArrayList<>();
          try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
            ps = con.prepareStatement("SELECT * FROM Patient where ID_user like ? ");
            ps.setString(1, "%"+txtId+"%");
            rs = ps.executeQuery();
            while (rs.next())
            {
                Patient patient = new Patient();                
                patient.setID_User(rs.getString(1));
                patient.setPhone(rs.getString(2));
                patient.setAddressUser(rs.getString(3));
                patient.setGender(rs.getBoolean(4));
                patient.setCCCD(rs.getString(5));
                patient.setEmail(rs.getString(6));
                patient.setCODEBHYT(rs.getString(7));
                patient.setUser_Name(rs.getString(8));
                patient.setUser_AGE(rs.getInt(9));
                patient.setDOB(rs.getDate(10));
                patient.setPATIENT_CAREER(rs.getString(11));
                patient.setUser_ROLE(rs.getString(12));
                list.add(patient);
           }
           con.close();
            return list;       
        } catch (Exception ex) {
            Logger.getLogger(PatientlmplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
         
        }
    
public static void main(String[] args) throws ParseException{
 Patient patient = new Patient();
 patient.setCODEBHYT("123213");
 patient.setAddressUser("HTK");
 patient.setPATIENT_CAREER("thuthu");
 patient.setCCCD("123123");
 patient.setGender(true);
 patient.setEmail("a@gmail");
 patient.setUser_Name("chinh");
 patient.setUser_AGE(12);
 patient.setUser_ROLE("Patient");
 patient.setDOB(Date.valueOf("2001-2-23"));
//    System.out.println(DAOFactory.getPatientDao().getSpecificPatient("US00001"));
//    System.out.println(DAOFactory.getPatientDao().getAllPatient());
System.out.println(patient);
}

   
}
