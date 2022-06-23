/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Doctor;


import java.util.List;
import Model.Doctors.Doctor;

/**
 *
 * @author phucl
 */
public interface DoctorDao {
    public String newDoctor(Doctor doctor);
    public void updateDoctor(Doctor doctor);
    public void removeDoctor(String doctorId);
    public List<Doctor> getAllDoctor();
    public Doctor getSpecificDoctor(String doctorId);
    public List<Doctor> searchbyName(String txtName);
    public List<Doctor> getDoctorsByIDF(String IDF);
}
