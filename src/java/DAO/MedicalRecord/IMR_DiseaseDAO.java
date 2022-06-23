/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.MedicalRecord;

import Model.MedicalRecord.Disease;
import Model.MedicalRecord.MR_Disease;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface IMR_DiseaseDAO {
    public void updateMR_Disease (MR_Disease mrd);
    public int addMR_Disease(MR_Disease mrd);
    public void removeMR_Disease(int IDMRD);
    public List<MR_Disease> getAllMR_Diseases ();
    public MR_Disease getAMR_Disease(int IDMRD);
    public List<MR_Disease> getMR_DiseaseByMR(String IDMR);
}
