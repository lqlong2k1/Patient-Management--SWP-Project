/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.MedicalRecord;

import DAO.DAOFactory;
import Model.MedicalRecord.MR_Disease;
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
public class MR_DiseaseDAO implements  IMR_DiseaseDAO{
private  List<MR_Disease> mR_Diseases;
    private  Connection con;
    private PreparedStatement ps;
    private  ResultSet rs;
    @Override
    public void updateMR_Disease(MR_Disease mrd) {
         try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD); 
            ps = con.prepareStatement("UPDATE MR_DISEASE set ID_DISEASE=?, ID_MR=? , DATE_DIAGNOSE=? where ID_MRD=?");
            ps.setString(1, mrd.getID_DISEASE());
            ps.setString(2, mrd.getID_MR());
            ps.setDate(3,  mrd.getDate_Diagnose());
            ps.executeUpdate();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(MR_DiseaseDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Invalid data");
        }
    }

    @Override
    public int addMR_Disease(MR_Disease mrd) {
        int IDmrDisease = 0;
        try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD); 
        
            ps= con.prepareStatement("Insert into MR_DISEASE(ID_DISEASE,ID_MR) output inserted.ID_MRD,inserted.DATE_DIAGNOSE values(?,?)");
            ps.setString(1, mrd.getID_DISEASE());
            ps.setString(2, mrd.getID_MR());
      
            rs = ps.executeQuery();
            if (rs.next()) {
                IDmrDisease = rs.getInt(1);
                mrd.setDate_Diagnose(rs.getDate(2));
            }
            mrd.setID_MRD(IDmrDisease);
            con.commit();
            con.close();
        } catch (Exception e) {
            Logger.getLogger(MR_DiseaseDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return IDmrDisease;
    }

    @Override
    public void removeMR_Disease(int IDMRD) {
        boolean flag = false;
        ListIterator<MR_Disease> Interator = getAllMR_Diseases().listIterator();
        while (Interator.hasNext()) {
            MR_Disease removable = ((MR_Disease) Interator.next());
            if (removable.getID_MRD()==IDMRD) {
                try {
                    Class.forName(DAOFactory.DRIVER_NAME);
                    con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
                    ps = con.prepareStatement("DElete MR_DISEASE where ID_MRD=?");
                    ps.setInt(1,IDMRD );
                    ps.executeUpdate();
                    flag = true;
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(MR_DiseaseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (flag == false) {
           throw new RuntimeException("Remove Failed.");
        }
    }

    @Override
    public List<MR_Disease> getAllMR_Diseases() {
          mR_Diseases = new ArrayList();
        try {
             Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD); 
            
            ps = con.prepareStatement("select * from MR_DISEASE");

             rs = ps.executeQuery();
            while (rs.next()) {
                mR_Diseases.add(new MR_Disease(rs.getInt(1),rs.getString(2) ,rs.getString(3),rs.getDate(4)));
            }
            con.close();
            return mR_Diseases;
        } catch (Exception ex) {
            Logger.getLogger(MR_DiseaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;       
    }

    @Override
    public MR_Disease getAMR_Disease(int IDMRD) {
        ListIterator<MR_Disease> Interator = getAllMR_Diseases().listIterator();

           while (Interator.hasNext())
        {
            MR_Disease thisMRD = ((MR_Disease) Interator.next());
            if (thisMRD.getID_MRD()==IDMRD) {
                return  thisMRD;
            }
        }
        return null;
    }
@Override
       public List<MR_Disease> getMR_DiseaseByMR(String IDMR) {
        List<MR_Disease>   MR_Diseases = new ArrayList();
           List<MR_Disease> Interator = getAllMR_Diseases();

           Interator.stream().filter((thisMRD) -> (thisMRD.getID_MR().equals(IDMR))).forEachOrdered((thisMRD) -> {
               MR_Diseases.add(thisMRD);
    });
        return MR_Diseases;
    }
       public static void main(String[] args) {
           System.out.println(DAOFactory.getMR_DiseaseDAO().getMR_DiseaseByMR("MR00001"));
    }
}
