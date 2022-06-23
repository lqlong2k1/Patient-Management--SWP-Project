/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.MedicalRecord;

import java.sql.Date;

/**
 *
 * @author Anh Tuan
 */
public class MedicalRecord {
    private String patient;
    private String doctor;
    private String medicalRecordId;
    private Date createDate;
    private String symtoms;

    public MedicalRecord() {
    }

    public MedicalRecord(String patient, String doctor, String medicalRecordId, Date createDate, String symtoms) {
        this.patient = patient;
        this.doctor = doctor;
        this.medicalRecordId = medicalRecordId;
        this.createDate = createDate;
        this.symtoms = symtoms;
     
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getMedicalRecordId() {
        return medicalRecordId;
    }

    public void setMedicalRecordId(String medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getSymtoms() {
        return symtoms;
    }

    public void setSymtoms(String symtoms) {
        this.symtoms = symtoms;
    }

    @Override
    public String toString() {
        return "MedicalRecord{" + "patient=" + patient + ", doctor=" + doctor + ", medicalRecordId=" + medicalRecordId + ", createDate=" + createDate + ", symtoms=" + symtoms + '}';
    }

    
}
