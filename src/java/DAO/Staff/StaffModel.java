/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Staff;

import Model.Staff.Staff;
import java.util.List;

public interface StaffModel {
     
    public Staff updateStaff(Staff user);
    public Staff getSpecificStaff(String userID);
    public List<Staff> getAllStaff();
    public void removeStaff(String userID);
    public String insertStaff(Staff user);
    public List<Staff> getAllStaffbyIDF(String IDF);
   
}
