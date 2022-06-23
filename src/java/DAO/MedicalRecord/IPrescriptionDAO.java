/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.MedicalRecord;

import Model.MedicalRecord.Prescription;
import Model.MedicalRecord.Prescription;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface IPrescriptionDAO {
    public void updatePrescription (Prescription prescription);
    public String addPrescription(Prescription mrd);
  
    public List<Prescription> getAllPrescriptions ();
    public Prescription getAPrescription(String IDPRE);
    public List<Prescription> getPrescriptionByMR(String IDMR);
}
