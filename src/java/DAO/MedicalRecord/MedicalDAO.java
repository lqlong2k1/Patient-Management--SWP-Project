/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.MedicalRecord;

import DAO.DAOFactory;
import Model.MedicalRecord.Medical;
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
public class MedicalDAO implements IMedicalDAO{
private  List<Medical> medicals;
    private  Connection con;
    private PreparedStatement ps;
    private  ResultSet rs;
    @Override
    public void updateMedical(Medical medical) {
       try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD); 
            ps = con.prepareStatement("Update MEDICAL set MED_NAME=?, MED_DESCRIPTION=? where ID_MEDICAL=?");
            ps.setString(1, medical.getMedicalName());
            ps.setString(2, medical.getMedicalDescription());
            ps.setString(3, medical.getMedicalId());
            ps.executeUpdate();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(MedicalDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Invalid data");
        }
    }

    @Override
    public String addMedical(Medical medical) {
        String ID_MEDICAL = "";
        try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD); 
        
            ps= con.prepareStatement("Insert into MEDICAL ( MED_NAME, MED_DESCRIPTION,PRICE)"
                    + "OUTPUT INSERTED.ID_MEDICAL VALUE(?,?,?)");
            ps.setString(1, medical.getMedicalName());
            ps.setString(2, medical.getMedicalDescription());
             ps.setDouble(3, medical.getPrice());
            rs = ps.executeQuery();
            if (rs.next()) {
                ID_MEDICAL = rs.getString(1);
            }
            medical.setMedicalId(ID_MEDICAL);
            con.commit();
            con.close();
        } catch (Exception e) {
            Logger.getLogger(MedicalDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return ID_MEDICAL;
    }

    @Override
    public void removeMedical(String IDM) {
        boolean flag = false;
        ListIterator<Medical> Interator = getAllMedicals().listIterator();
        while (Interator.hasNext()) {
            Medical removable = ((Medical) Interator.next());
            if (removable.getMedicalId().equals(IDM)) {
                try {
                    Class.forName(DAOFactory.DRIVER_NAME);
                    con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
                    ps = con.prepareStatement("Delete from MEDICAL where ID_MEDICAL =?");
                    ps.setString(1,IDM );
                    ps.executeUpdate();
                    flag = true;
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(MedicalDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (flag == false) {
           throw new RuntimeException("Remove Failed.");
        }
    }

    @Override
    public List<Medical> getAllMedicals() {
        medicals = new ArrayList();
        try {
             Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD); 
            
            ps = con.prepareStatement("Select * from MEDICAL");

             rs = ps.executeQuery();
            while (rs.next()) {
                medicals.add(new Medical(rs.getString(1), rs.getString(2),rs.getString(3),rs.getDouble(4)));
            }
            con.close();
            return medicals;
        } catch (Exception ex) {
            Logger.getLogger(MedicalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public Medical getAnMedical(String IDM) {
         ListIterator<Medical> Interator = getAllMedicals().listIterator();

           while (Interator.hasNext())
        {
            Medical thisMedical = ((Medical) Interator.next());
            if (thisMedical.getMedicalId().equals(IDM)) {
                return  thisMedical;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(DAOFactory.getMedicalDAO().getAnMedical("ME00001"));
    }
   
       
}
