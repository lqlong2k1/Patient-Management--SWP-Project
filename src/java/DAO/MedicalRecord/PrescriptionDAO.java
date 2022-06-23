/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.MedicalRecord;

import DAO.DAOFactory;
import Model.MedicalRecord.MR_Disease;
import Model.MedicalRecord.Prescription;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class PrescriptionDAO implements IPrescriptionDAO{
private  List<Prescription> prescriptions;
    private  Connection con;
    private PreparedStatement ps;
    private  ResultSet rs;
    @Override
    public void updatePrescription(Prescription prescription) {
       try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD); 
            ps = con.prepareStatement("update prescription set IDMR=? ,date_created=? where IDPRE=?");
            ps.setString(1, prescription.getIDMR());
            ps.setDate(2, prescription.getDate_createDate());
            ps.setString(3, prescription.getIDPRE());
            ps.executeUpdate();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(PrescriptionDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Invalid data");
        }
    }

    @Override
    public String addPrescription(Prescription mrd) {
       String IDPRE = "";
        try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD); 
        
            ps= con.prepareStatement("insert into prescription(IDMR) output inserted.IDPRE values(?)");
          
            ps.setString(1, mrd.getIDMR());
      
            rs = ps.executeQuery();
            if (rs.next()) {
                IDPRE = rs.getString(1);
                
            }
            mrd.setIDPRE(IDPRE);
            con.commit();
            con.close();
        } catch (Exception e) {
            Logger.getLogger(PrescriptionDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return IDPRE;
    }

    

    @Override
    public List<Prescription> getAllPrescriptions() {
           prescriptions = new ArrayList();
        try {
             Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD); 
            
            ps = con.prepareStatement("select * from prescription");

             rs = ps.executeQuery();
            while (rs.next()) {
                prescriptions.add(new Prescription(rs.getString(1), rs.getString(2), rs.getDate(3)));
            }
            con.close();
            return prescriptions;
        } catch (Exception ex) {
            Logger.getLogger(PrescriptionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;       
    }

    @Override
    public Prescription getAPrescription(String IDPRE) {
        ListIterator<Prescription> Interator = getAllPrescriptions().listIterator();

           while (Interator.hasNext())
        {
            Prescription thisPre = ((Prescription) Interator.next());
            if (thisPre.getIDPRE().equals(IDPRE)) {
                return  thisPre;
            }
        }
        return null;
    }

    @Override
    public List<Prescription> getPrescriptionByMR(String IDMR) {
       List<Prescription>   Pres = new ArrayList();
           List<Prescription> Interator = getAllPrescriptions();

           Interator.stream().filter((thisMRD) -> (thisMRD.getIDMR().equals(IDMR))).forEachOrdered((thisMRD) -> {
               Pres.add(thisMRD);
    });
        return Pres;
    }
    public static void main(String[] args) {
//        Prescription mrd = new Prescription();
//        mrd.setIDMR("MR00001");
//        System.out.println(DAOFactory.getPrescriptionDAO().addPrescription(mrd));
        System.out.println(DAOFactory.getPrescriptionDAO().getAllPrescriptions());
        System.out.println(DAOFactory.getPrescriptionDAO().getAPrescription("PR00001"));
        System.out.println(DAOFactory.getPrescriptionDAO().getPrescriptionByMR("MR00001"));
    }
}
