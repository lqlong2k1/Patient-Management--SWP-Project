/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.MedicalRecord;

import Model.MedicalRecord.Disease;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface IDiseaseDAO {
    public void updateDisease (Disease disease);
    public String addDisease(Disease disease);
    public void removeDisease(String IDDI);
    public List<Disease> getAllDiseases ();
    public Disease getADisease(String IDMR);
}
