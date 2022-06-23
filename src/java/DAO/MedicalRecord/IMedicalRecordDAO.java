/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.MedicalRecord;

import Model.MedicalRecord.MedicalRecord;
import java.util.List;



/**
 *
 * @author Anh Tuan
 */
public interface IMedicalRecordDAO {
    
    public void updateMedicalRecord (MedicalRecord medicalRecord);
    public String addMedicalRecord(MedicalRecord medicalRecord);
    public void removeMedicalRecord(String IDmr);
    public List<MedicalRecord> getAllMedicalRecord ();
    public MedicalRecord getAnMedicalRecord(String IDMR);
    public List<MedicalRecord> getAllMedicalRecordByPatient(String IDpatient);
  public List<MedicalRecord> getAllMedicalRecordByDoctor(String IDdoctor);    
}