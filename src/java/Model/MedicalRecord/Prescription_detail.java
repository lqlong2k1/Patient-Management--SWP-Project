/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.MedicalRecord;

import DAO.DAOFactory;

/**
 *
 * @author DELL
 */
public class Prescription_detail {
    String IDPRE;
    String ID_MEDICAL;
    int quantity;

    public String getIDPRE() {
        return IDPRE;
    }

    public void setIDPRE(String IDPRE) {
        this.IDPRE = IDPRE;
    }

    public String getID_MEDICAL() {
        return ID_MEDICAL;
    }

    public void setID_MEDICAL(String ID_MEDICAL) {
        this.ID_MEDICAL = ID_MEDICAL;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMedicalName(){
        return DAOFactory.getMedicalDAO().getAnMedical(ID_MEDICAL).getMedicalName();
    }
    @Override
    public String toString() {
        return "Prescription_detail{" + "IDPRE=" + IDPRE + ", ID_MEDICAL=" + ID_MEDICAL + ", quantity=" + quantity + '}';
    }

    public Prescription_detail() {
    }
 
    public Prescription_detail(String IDPRE, String ID_MEDICAL, int quantity) {
        this.IDPRE = IDPRE;
        this.ID_MEDICAL = ID_MEDICAL;
        this.quantity = quantity;
    }
    
}
