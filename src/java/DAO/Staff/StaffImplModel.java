/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Staff;


import DAO.DAOFactory;
import DAO.MedicalRecord.MedicalDAO;
import Model.MedicalRecord.Medical;
import Model.Staff.Staff;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anh Tuan
 */
public class StaffImplModel implements StaffModel {

    private List<Staff> staffs ;
    private  Connection con;
    private PreparedStatement ps;
    private  ResultSet rs;
    
    @Override
    public Staff updateStaff(Staff user) {
        try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD); 
           ps = con.prepareStatement("Update Staff set Phone =?,set IDF=? , AddressUser =? , Gender =? , cccd=? , email=? , user_name=? , user_age=? , DOB=? , user_ROLE=? where userID =?");
            ps.setString(1, user.getPhone());
            ps.setString(2, user.getFacultyID());
            ps.setString(3, user.getAddressUser());
            ps.setBoolean(4, user.getGender());
            ps.setString(5, user.getCCCD());
            ps.setString(6, user.getEmail());
            ps.setString(7, user.getUser_Name());
            ps.setInt(8, user.getUser_AGE());
            ps.setDate(9, user.getDOB());
            ps.setString(10, user.getUser_ROLE());
            ps.setString(11, user.getID_User());
            ps.executeUpdate();
            con.close();
            return user;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StaffImplModel.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Invalid data");
        }
    }

    @Override
    public Staff getSpecificStaff(String userID) {
       ListIterator<Staff> Interator = getAllStaff().listIterator();

           while (Interator.hasNext())
        {
            Staff thisStaff = ((Staff) Interator.next());
            if (thisStaff.getID_User().equals(userID)) {
                return  thisStaff;
            }
        }
        return null;
    }

    // public User(String ID_User, String Phone, String addressUser, boolean gender, String CCCD, String Email, String User_Name, String User_AGE, Date DOB, String User_ROLE)
    @Override
    public List<Staff> getAllStaff() {
        staffs = new ArrayList<>();
        try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD); 
            ps = con.prepareStatement("Select * from Staff");
            rs = ps.executeQuery();
            while (rs.next()) {
                staffs.add(new Staff(rs.getString(1),rs.getString(2) ,rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getDate(10), rs.getString(11)));
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(StaffImplModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return staffs;
    }

    @Override
    public void removeStaff(String userID) {
       boolean flag = false;
        ListIterator<Staff> Interator = getAllStaff().listIterator();
        while (Interator.hasNext()) {
            Staff removable = ((Staff) Interator.next());
            if (removable.getID_User().equals(userID)) {
                try {
                    Class.forName(DAOFactory.DRIVER_NAME);
                    con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
                    ps = con.prepareStatement("Delete from Staff where ID_user =?");
                    ps.setString(1,userID );
                    ps.executeUpdate();
                    flag = true;
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(StaffImplModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (flag == false) {
           throw new RuntimeException("Remove Failed.");
        }
    }

    @Override
    public String insertStaff(Staff user) {
        String ID_Staff = "";
        user.setUser_ROLE("Staff");
        try {
           Class.forName(DAOFactory.DRIVER_NAME);
           con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD); 
           ps = con.prepareStatement("Insert into Staff (Phone, IDF , AddressUser , Gender , cccd , email , user_name , user_age , DOB , user_ROLE)"
                    + "OUTPUT INSERTED.ID_user VALUE(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, user.getPhone());
            ps.setString(2, user.getFacultyID());
            ps.setString(3, user.getAddressUser());
            ps.setBoolean(4, user.getGender());
            ps.setString(5, user.getCCCD());
            ps.setString(6, user.getEmail());
            ps.setString(7, user.getUser_Name());
            ps.setInt(8, user.getUser_AGE());
            ps.setDate(9, user.getDOB());
            ps.setString(10, user.getUser_ROLE());
            rs = ps.executeQuery();
            if (rs.next()) {
                ID_Staff = rs.getString(1);
            }
            con.commit();
            con.close();
        } catch (Exception e) {
            Logger.getLogger(StaffImplModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return ID_Staff;
    }

    @Override
    public List<Staff> getAllStaffbyIDF(String IDF) {
         ListIterator<Staff> Interator = getAllStaff().listIterator();
    staffs = new ArrayList();
           while (Interator.hasNext())
        {
            Staff thisStaff = ((Staff) Interator.next());
            if (thisStaff.getFacultyID().equals(IDF)) {
                staffs.add(thisStaff);
            }
        }
        return staffs;
    }


}
