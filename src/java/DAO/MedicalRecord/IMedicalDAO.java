/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.MedicalRecord;

import Model.MedicalRecord.Disease;
import Model.MedicalRecord.Medical;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface IMedicalDAO {
    public void updateMedical (Medical medical);
    public String addMedical(Medical medical);
    public void removeMedical(String IDDI);
    public List<Medical> getAllMedicals ();
    public Medical getAnMedical(String IDMR);
}
