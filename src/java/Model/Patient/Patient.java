/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Patient;

import Model.User;
import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class Patient extends User implements Serializable {
    private String CODEBHYT;
    private String PATIENT_CAREER;

    public String getCODEBHYT() {
        return CODEBHYT;
    }

    public void setCODEBHYT(String CODEBHYT) {
        this.CODEBHYT = CODEBHYT;
    }

    @Override
    public String toString() {
        return super.toString() + "Patient{" + "CODEBHYT=" + CODEBHYT + ", PATIENT_CAREER=" + PATIENT_CAREER + '}';
    }

    public String getPATIENT_CAREER() {
        return PATIENT_CAREER;
    }

    public void setPATIENT_CAREER(String PATIENT_CAREER) {
        this.PATIENT_CAREER = PATIENT_CAREER;
    }
    
}
