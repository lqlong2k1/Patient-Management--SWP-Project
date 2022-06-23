/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.MedicalRecord;

import DAO.DAOFactory;
import Model.MedicalRecord.MedicalRecord;
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
public class MedicalRecordDAO implements IMedicalRecordDAO {
    List<MedicalRecord> medicalRecords;

    private static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;

    @Override
    public void updateMedicalRecord(MedicalRecord medicalRecord) {
          
        try { 
           Class.forName(DAOFactory.DRIVER_NAME);
           con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);         
            String query = "  update MEDICAL_RECORD set SYMPTOM=?,DATE_CREATED=?,DOCTOR=?,PATIENT=? where ID_MR=?"; 
            ps = con.prepareStatement(query);
            ps.setString(1, medicalRecord.getSymtoms());
            ps.setDate(2, medicalRecord.getCreateDate());
            ps.setString(3, medicalRecord.getDoctor());
            ps.setString(4, medicalRecord.getPatient());
            ps.setString(5, medicalRecord.getMedicalRecordId());
            ps.executeUpdate();       
        } catch (ClassNotFoundException | SQLException e) {
        System.out.print(e);
        }
    }
    @Override
    public String addMedicalRecord(MedicalRecord medicalRecord){
       String ID_MR = "empty";
       
        try { 
           Class.forName(DAOFactory.DRIVER_NAME);
           con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);         
            String query = "insert into Medical_Record (SYMPTOM,DOCTOR,PATIENT) output inserted.ID_MR values(?,?,?)  ";  
            ps = con.prepareStatement(query);
            ps.setString(1, medicalRecord.getSymtoms());
            ps.setString(2, medicalRecord.getDoctor());
            ps.setString(3, medicalRecord.getPatient());
            rs = ps.executeQuery();
            if (rs.next()){
            ID_MR= rs.getString(1);
            }
            medicalRecord.setMedicalRecordId(ID_MR);
        } catch (ClassNotFoundException | SQLException e) {
        System.out.print(e);
        }
       return ID_MR;
    }
    @Override   
    public void removeMedicalRecord(String idmr) {
       boolean flag = false;
        ListIterator<MedicalRecord> MRInterator = getAllMedicalRecord().listIterator();
        while (MRInterator.hasNext()) {
            MedicalRecord removableMR = ((MedicalRecord) MRInterator.next());
            if (removableMR.getMedicalRecordId().equals(idmr)) {
                try {
                    Class.forName(DAOFactory.DRIVER_NAME);
                    con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
                    ps = con.prepareStatement("DELETE Medical_Record WHERE ID_MR = ?");
                    ps.setString(1,idmr );
                    ps.executeUpdate();
                    flag = true;
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(MedicalRecordDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (flag == false) {
           throw new RuntimeException("Remove Failed.");
        }
    }

    @Override
    public List<MedicalRecord> getAllMedicalRecord() {
        medicalRecords= new ArrayList();
        try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
            ps = con.prepareStatement("select * from Medical_Record");
            rs = ps.executeQuery();
            while (rs.next())
            {
               medicalRecords.add(new MedicalRecord(rs.getString(5), rs.getString(4), rs.getString(1), rs.getDate(2), rs.getString(3)));
            }
            DAOFactory.closeConnection(con, ps, rs);
            return  medicalRecords;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MedicalRecordDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public MedicalRecord getAnMedicalRecord(String IDMR) {
      ListIterator<MedicalRecord> MRInterator = getAllMedicalRecord().listIterator();

           while (MRInterator.hasNext())
        {
            MedicalRecord thisMR = ((MedicalRecord) MRInterator.next());
            if (thisMR.getMedicalRecordId().equals(IDMR)) {
                return  thisMR;
            }
        }
        return null;
    }

    @Override
    public List<MedicalRecord> getAllMedicalRecordByPatient(String IDpatient) {
          ListIterator<MedicalRecord> MRInterator = getAllMedicalRecord().listIterator();
      medicalRecords= new ArrayList();
           while (MRInterator.hasNext())
        {
            MedicalRecord thisMR = ((MedicalRecord) MRInterator.next());
            if (thisMR.getPatient().equals(IDpatient)) {
                medicalRecords.add(thisMR);
            }
        }
        return medicalRecords;
    }
    @Override
   public List<MedicalRecord> getAllMedicalRecordByDoctor(String IDdoctor) {
          ListIterator<MedicalRecord> MRInterator = getAllMedicalRecord().listIterator();
      medicalRecords= new ArrayList();
           while (MRInterator.hasNext())
        {
            MedicalRecord thisMR = ((MedicalRecord) MRInterator.next());
            if (thisMR.getDoctor().equals(IDdoctor)) {
                medicalRecords.add(thisMR);
            }
        }
        return medicalRecords;
    }
    public static void main(String[] args) {
        System.out.println(DAOFactory.getMedicalRecordDAO().getAllMedicalRecordByPatient("US00001"));
    }
  
}
  

