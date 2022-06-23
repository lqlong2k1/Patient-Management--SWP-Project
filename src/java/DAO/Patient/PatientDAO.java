/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Patient;
import Model.Patient.Patient;
import java.util.List;

/**
 *
 * @author PC
 */
public interface PatientDAO {
    public String insertPatient(Patient user);
   public  Patient updatePatient(Patient patient);
    public Patient getSpecificPatient(String userID);
    public void removePatient(String userID);
    public  List<Patient> getAllPatient();
     public List<Patient> searchbyID(String txtId);
       public List<Patient> searchbyName(String txtName);
    
}