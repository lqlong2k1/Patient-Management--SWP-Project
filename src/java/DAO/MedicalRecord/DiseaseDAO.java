/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.MedicalRecord;

import DAO.DAOFactory;
import Model.MedicalRecord.Disease;

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
public class DiseaseDAO implements IDiseaseDAO{
    List<Disease> diseases;

    private static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;

    @Override
    public void updateDisease(Disease disease) {
         try { 
           Class.forName(DAOFactory.DRIVER_NAME);
           con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);         
            String query = "  update DISEASE set DIS_DESCRIPTION=?,DIS_NAME=? where ID_DISEASE=?"; 
            ps = con.prepareStatement(query);
            ps.setString(1,disease.getDiseaseDescription());
            ps.setString(2, disease.getDiseaseName());
            ps.setString(3, disease.getDiseaseId());
            ps.executeUpdate();       
        } catch (ClassNotFoundException | SQLException e) {
        System.out.print(e);
        }
    }

    @Override
    public String addDisease(Disease disease) {
        String ID_DI = "empty";
       
        try { 
           Class.forName(DAOFactory.DRIVER_NAME);
           con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);         
            String query = "insert into DISEASE(DIS_DESCRIPTION,DIS_NAME) output inserted.ID_DISEASE values(?,?) ";  
            ps = con.prepareStatement(query);
            ps.setString(1, disease.getDiseaseDescription());
            ps.setString(2, disease.getDiseaseName());
            rs = ps.executeQuery();
            if (rs.next()){
            ID_DI= rs.getString(1);
            }
            disease.setDiseaseId(ID_DI);
        } catch (ClassNotFoundException | SQLException e) {
        System.out.print(e);
        }
       return ID_DI;
    }

    @Override
    public void removeDisease(String IDDI) {
         boolean flag = false;
        ListIterator<Disease> Interator = getAllDiseases().listIterator();
        while (Interator.hasNext()) {
            Disease removableDI = ((Disease) Interator.next());
            if (removableDI.getDiseaseId().equals(IDDI)) {
                try {
                    Class.forName(DAOFactory.DRIVER_NAME);
                    con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
                    ps = con.prepareStatement("DELETE DISEASE WHERE ID_DISEASE = ?");
                    ps.setString(1,IDDI );
                    ps.executeUpdate();
                    flag = true;
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(DiseaseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (flag == false) {
           throw new RuntimeException("Remove Failed.");
        }
    }

    @Override
    public List<Disease> getAllDiseases() {
         diseases= new ArrayList();
        try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
            ps = con.prepareStatement("select * from Disease ");
            rs = ps.executeQuery();
            while (rs.next())
            {
               diseases.add(new Disease(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            DAOFactory.closeConnection(con, ps, rs);
            return  diseases;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DiseaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Disease getADisease(String IDDI) {
         ListIterator<Disease> DIInterator = getAllDiseases().listIterator();      
           while (DIInterator.hasNext())
        {
            Disease thisdisease = ((Disease) DIInterator.next());
            if (thisdisease.getDiseaseId().equals(IDDI)) {
                return  thisdisease;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(DAOFactory.getDiseaseDAO().getADisease("DI00001"));
    }
}
