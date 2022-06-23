/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Doctor;

import DAO.DAOFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Doctors.Doctor;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phucl
 */
public class DoctorDaoImpl implements DoctorDao {
    private  List<Doctor> doctors;
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    
    @Override
    public String newDoctor(Doctor doctor) {
        String doctorId = "";
        try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
            ps = con.prepareStatement("INSERT INTO USER_DATA (IDF, Phone, AddressUSER, "
                    + "GENDER, CCCD, EMAIL, "
                    + "USER_NAME, USER_AGE, DOB, USER_ROLE)"
                    + "OUTPUT INSERTED.ID_USER VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, doctor.getIdfaculty());
            ps.setString(2, doctor.getPhone());
            ps.setString(3, doctor.getAddressUser());
            ps.setBoolean(4, doctor.getGender());
            ps.setString(5, doctor.getCCCD());
            ps.setString(6, doctor.getEmail());
            ps.setString(7, doctor.getUser_Name());
            ps.setInt(8, doctor.getUser_AGE());
            ps.setDate(9, doctor.getDOB());
            ps.setString(10, doctor.getUser_ROLE());
            rs = ps.executeQuery();
            rs.next();
            doctorId = rs.getString(1);
            DAOFactory.closeConnection(con, ps, rs);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DoctorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DAOFactory.closeConnection(con, ps, rs);
        }
        return doctorId;
    }
    
    @Override
    public void updateDoctor(Doctor doctor){
        try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
            ps = con.prepareStatement("UPDATE Doctor SET IDF = ?, Phone = ?, "
                    + "AddressUser = ?, Gender = ?, cccd = ?, email = ?, user_name = ?, "
                    + "user_age = ?, DOB = ? WHERE ID_user = ?");
            ps.setString(1, doctor.getIdfaculty());
            ps.setString(2, doctor.getPhone());
            ps.setString(3, doctor.getAddressUser());
            ps.setBoolean(4, doctor.getGender());
            ps.setString(5, doctor.getCCCD());
            ps.setString(6, doctor.getEmail());
            ps.setString(7, doctor.getUser_Name());
            ps.setInt(8, doctor.getUser_AGE());
            ps.setDate(9, doctor.getDOB());
            ps.setString(10, doctor.getID_User());
            ps.executeUpdate();
            DAOFactory.closeConnection(con, ps, rs);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DoctorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void removeDoctor(String doctorId) {
        boolean flag = false;
        ListIterator<Doctor> doctorInterator = getAllDoctor().listIterator();
        while (doctorInterator.hasNext()) {
            Doctor removableDoctor = ((Doctor) doctorInterator.next());
            if (removableDoctor.getID_User().equals(doctorId)) {
                try {
                    Class.forName(DAOFactory.DRIVER_NAME);
                    con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
                    ps = con.prepareStatement("DELETE Doctor WHERE ID_user = ?");
                    ps.setString(1, doctorId);
                    ps.executeUpdate();
                    flag = true;
                      DAOFactory.closeConnection(con, ps, rs);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(DoctorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (flag == false) {
            System.out.println("Doctor Id: " + doctorId + " NOT FOUND!");
        }
    }
    
    @Override
    public List<Doctor> getAllDoctor()
    {
        doctors = new ArrayList<>();
        try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
            ps = con.prepareStatement("SELECT ID_user, IDF, Phone, AddressUser,"
                    + "Gender, cccd, email, user_name, user_age, DOB FROM Doctor");
            rs = ps.executeQuery();
            while (rs.next())
            {
                Doctor doctor = new Doctor();
                doctor.setID_User(rs.getString(1));
                doctor.setIdfaculty(rs.getString(2));
                doctor.setPhone(rs.getString(3));
                doctor.setAddressUser(rs.getString(4));
                doctor.setGender(rs.getBoolean(5));
                doctor.setCCCD(rs.getString(6));
                doctor.setEmail(rs.getString(7));
                doctor.setUser_Name(rs.getString(8));
                doctor.setUser_AGE(rs.getInt(9));
                doctor.setDOB(rs.getDate(10));
                doctor.setUser_ROLE("Doctor");
                doctors.add(doctor);
           }
            DAOFactory.closeConnection(con, ps, rs);
            return doctors;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DoctorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
       
    @Override
    public Doctor getSpecificDoctor(String doctorId) {
        ListIterator<Doctor> doctorInterator = getAllDoctor().listIterator();
        while (doctorInterator.hasNext())
        {
            Doctor thisDoctor = ((Doctor) doctorInterator.next());
            if (thisDoctor.getID_User().equals(doctorId)) {
                return thisDoctor;
            }
        }
        return null;
    }
    @Override
    public List<Doctor> searchbyName(String txtName){
         List<Doctor> list = new ArrayList<>();
          try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
            ps = con.prepareStatement("SELECT * FROM Doctor where user_name like ? ");
            ps.setString(1, "%"+txtName+"%");
            rs = ps.executeQuery();
            while (rs.next())
            {
                Doctor doctor = new Doctor();
                doctor.setID_User(rs.getString(1));
                  doctor.setIdfaculty(rs.getString(2));
                doctor.setPhone(rs.getString(3));
                doctor.setAddressUser(rs.getString(4));
                doctor.setGender(rs.getBoolean(5));
                doctor.setCCCD(rs.getString(6));
                doctor.setEmail(rs.getString(7));
                doctor.setUser_Name(rs.getString(8));
                doctor.setUser_AGE(rs.getInt(9));
                doctor.setDOB(rs.getDate(10));
                doctor.setUser_ROLE("Doctor");
                list.add(doctor);
           }
           con.close();
            return list;       
        } catch (Exception ex) {
            Logger.getLogger(DoctorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
         
        }
    public static void main(String[] args) {
        //1. Test newDoctor
//        faculty Faculty = new faculty();
//        
//                Doctor d = new Doctor();
//                d.setFaculty(Faculty);
//                d.setUser_Name("Phan Chau Trinh");
//                d.getFaculty().setFacultID("CXK");
//                d.setAddressUser("HCM City");
//                d.setCCCD("123490");
//                d.setPhone("12789");
//                d.setEmail("k@email");
//                d.setGender(true);
//                
//                DAOFactory.getDoctorDao().newDoctor(d);
        
//        //2. Test updateDoctor
//                Doctor d2 = new Doctor("US00011", "YHCT", "Phan Chu Trinh", "1234567890", "123456789", "HCM City", "k@email", 44, null, true);
//                 DAOFactory.getDoctorDao().updateDoctor(d2);
//
//        //3. Test removeDoctor
//                DAOFactory.getDoctorDao().removeDoctor("US00002");
//        
//        //4. Test getAllDoctor
  //    System.out.println(DAOFactory.getDoctorDao().searchbyName("Phi"));
////        
////        //5 Test getSpecificDoctor
         System.out.println(DAOFactory.getDoctorDao().getSpecificDoctor("US00005").getIdfaculty());
          
   }

    @Override
    public List<Doctor> getDoctorsByIDF(String IDF) {
        ArrayList<Doctor> dc = new ArrayList();
         ListIterator<Doctor> doctorInterator = getAllDoctor().listIterator();
        while (doctorInterator.hasNext())
        {
            Doctor thisDoctor = (Doctor) doctorInterator.next();
            if (thisDoctor.getIdfaculty().equals(IDF)) {
              
                dc.add(thisDoctor);
            }
        }
        return dc;
    }

}