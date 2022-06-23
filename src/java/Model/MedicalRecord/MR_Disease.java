/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.MedicalRecord;

import DAO.DAOFactory;
import java.sql.Date;

/**
 *
 * @author DELL
 */
public class MR_Disease {
    int ID_MRD;
    String ID_MR;
    String ID_DISEASE;
    Date Date_Diagnose;

    public int getID_MRD() {
        return ID_MRD;
    }

    public void setID_MRD(int ID_MRD) {
        this.ID_MRD = ID_MRD;
    }

    public String getID_MR() {
        return ID_MR;
    }

    public void setID_MR(String ID_MR) {
        this.ID_MR = ID_MR;
    }

    public String getID_DISEASE() {
        return ID_DISEASE;
    }

    public void setID_DISEASE(String ID_DISEASE) {
        this.ID_DISEASE = ID_DISEASE;
    }

    public Date getDate_Diagnose() {
        return Date_Diagnose;
    }

    public void setDate_Diagnose(Date Date_Diagnose) {
        this.Date_Diagnose = Date_Diagnose;
    }

    public MR_Disease(int ID_MRD, String ID_MR, String ID_DISEASE, Date Date_Diagnose) {
        this.ID_MRD = ID_MRD;
        this.ID_MR = ID_MR;
        this.ID_DISEASE = ID_DISEASE;
        this.Date_Diagnose = Date_Diagnose;
    }

    public MR_Disease() {
    }
    
    public String getDiseaseName() {
        return DAOFactory.getDiseaseDAO().getADisease(ID_DISEASE).getDiseaseName();
    }

    @Override
    public String toString() {
        return "MR_Disease{" + "ID_MRD=" + ID_MRD + ", ID_MR=" + ID_MR + ", ID_DISEASE=" + ID_DISEASE + ", Date_Diagnose=" + Date_Diagnose + '}';
    }
    
}
