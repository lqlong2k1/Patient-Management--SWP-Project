/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Faculty;

import Model.faculty.faculty;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface IFacultyDAO {
    public String insertFaculty(faculty fac);
    public void updateFaculty(faculty fac);
    public faculty getSpecificFaculty(String facID);
    public void removeFaculty(String facID);
    public  List<faculty> getAllFaculty();
}
