/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.MedicalRecord;


import Model.MedicalRecord.Prescription_detail;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface IPrescription_DetailDAO {
    public void updatePrescription_Detail (Prescription_detail mrd);
    public void addPrescription_Detail(Prescription_detail mrd);
    public List<Prescription_detail> getAllPrescription_Detail ();
    public List<Prescription_detail> getPrescription_DetailByPres(String IDPRE);
}
