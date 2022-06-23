/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.MedicalRecord;

import DAO.DAOFactory;
import Model.MedicalRecord.Prescription;
import Model.MedicalRecord.Prescription_detail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Prescription_DetailDAO implements IPrescription_DetailDAO {

    private  List<Prescription_detail> predetails;
    private  Connection con;
    private PreparedStatement ps;
    private  ResultSet rs;
    @Override
    public void updatePrescription_Detail(Prescription_detail mrd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addPrescription_Detail(Prescription_detail mrd) {
         try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD); 
        
            ps= con.prepareStatement(" insert into prescription_detail(IDPRE,ID_MEDICAL,Quantity) values(?,?,?)");
          
            ps.setString(1, mrd.getIDPRE());
            ps.setString(2, mrd.getID_MEDICAL());
            ps.setInt(3, mrd.getQuantity());
            ps.executeUpdate();
          
            con.commit();
            con.close();
        } catch (Exception e) {
            Logger.getLogger(MR_DiseaseDAO.class.getName()).log(Level.SEVERE, null, e);
        }
  
    }

    @Override
    public List<Prescription_detail> getAllPrescription_Detail() {
         predetails = new ArrayList();
        try {
             Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD); 
            
            ps = con.prepareStatement("select * from prescription_detail");

             rs = ps.executeQuery();
            while (rs.next()) {
               predetails.add(new Prescription_detail(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
            con.close();
            return predetails;
        } catch (Exception ex) {
            Logger.getLogger(PrescriptionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;       
    }

    @Override
    public List<Prescription_detail> getPrescription_DetailByPres(String IDPRE) {
         List<Prescription_detail>   Pres = new ArrayList();
         List<Prescription_detail> Interator = getAllPrescription_Detail();

           Interator.stream().filter((thisMRD) -> (thisMRD.getIDPRE().equals(IDPRE))).forEachOrdered((thisMRD) -> {
               Pres.add(thisMRD);
    });
        return Pres;
    }
    public static void main(String[] args) {
        System.out.println(DAOFactory.getPrescription_DetailDAO().getPrescription_DetailByPres("PR00001"));
        System.out.println(DAOFactory.getPrescription_DetailDAO().getAllPrescription_Detail());
    }  
}
