/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Faculty;

import DAO.DAOFactory;
import DAO.Doctor.DoctorDaoImpl;


import Model.faculty.faculty;
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
 * @author DELL
 */
public class FacultyDAO implements IFacultyDAO{
 private List<faculty> facultys;
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    @Override
    public String insertFaculty(faculty fac) {
      String facID = "";
        try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
            ps = con.prepareStatement("Insert into FACULTY(IDF,FALCULTY_NAME) output inserted.IDF values (?,?)");
            ps.setString(1, fac.getFacultID());
            ps.setString(2, fac.getFacultyName());

            rs = ps.executeQuery();
            rs.next();
            facID = rs.getString(1);
            DAOFactory.closeConnection(con, ps, rs);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FacultyDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DAOFactory.closeConnection(con, ps, rs);
        }
        return facID;
    }

    @Override
    public void updateFaculty(faculty fac) {
       try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
            ps = con.prepareStatement("Update FACULTY set FALCULTY_NAME = ? where IDF=?");
            ps.setString(2, fac.getFacultID());
            ps.setString(1, fac.getFacultyName());
            ps.executeUpdate();
            DAOFactory.closeConnection(con, ps, rs);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DoctorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        
    } finally {
            DAOFactory.closeConnection(con, ps, rs);
        }
    }

    @Override
    public faculty getSpecificFaculty(String facID) {
         ListIterator<faculty> Interator = getAllFaculty().listIterator();

           while (Interator.hasNext())
        {
            faculty thisfac = ((faculty) Interator.next());
            if (thisfac.getFacultID().equals(facID)) {
                return  thisfac;
            }
        }
        return null;
    }
    

    @Override
    public void removeFaculty(String facID) {
       boolean flag = false;
        ListIterator<faculty> Interator = getAllFaculty().listIterator();
        while (Interator.hasNext()) {
            faculty removable = ((faculty) Interator.next());
            if (removable.getFacultID().equals(facID)) {
                try {
                    Class.forName(DAOFactory.DRIVER_NAME);
                    con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
                    ps = con.prepareStatement("delete FACULTY where IDF=?");
                    ps.setString(1,facID );
                    ps.executeUpdate();
                    flag = true;
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(FacultyDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (flag == false) {
           throw new RuntimeException("Remove Failed.");
        }
    }
 
    @Override
    public List<faculty> getAllFaculty() {
        facultys= new ArrayList();
        try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
            ps = con.prepareStatement("select * from FACULTY");
            rs = ps.executeQuery();
            while (rs.next())
            {
              faculty fac = new faculty();
              fac.setFacultID(rs.getString(1));
              fac.setFacultyName(rs.getString(2));
              fac.setTotalStaff(rs.getInt(3));
              facultys.add(fac);
            }
            DAOFactory.closeConnection(con, ps, rs);
            return  facultys;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FacultyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null; 
    }
    
}
