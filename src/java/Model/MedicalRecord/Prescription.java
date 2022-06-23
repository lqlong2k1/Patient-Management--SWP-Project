/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.MedicalRecord;

import java.sql.Date;

/**
 *
 * @author DELL
 */
public class  Prescription {
    String IDPRE;
    String IDMR;
    Date date_createDate;

    public Prescription() {
    
    }

    public String getIDPRE() {
        return IDPRE;
    }

    public void setIDPRE(String IDPRE) {
        this.IDPRE = IDPRE;
    }

    public String getIDMR() {
        return IDMR;
    }

    public void setIDMR(String IDMR) {
        this.IDMR = IDMR;
    }

    public Date getDate_createDate() {
        return date_createDate;
    }

    public void setDate_createDate(Date date_createDate) {
        this.date_createDate = date_createDate;
    }

    public Prescription(String IDPRE, String IDMR, Date date_createDate) {
        this.IDPRE = IDPRE;
        this.IDMR = IDMR;
        this.date_createDate = date_createDate;
    }
    
}
