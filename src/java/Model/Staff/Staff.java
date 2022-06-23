/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Staff;
import Model.User;
import java.sql.Date;

/**
 *
 * @author Anh Tuan
 */
public class Staff extends User{
    
private String facultyID;

    @Override
    public String toString() {
        return "Staff{" + "faculty=" + facultyID + '}';
    }

    public Staff( String ID_User,String facultyID, String Phone, String addressUser, boolean gender, String CCCD, String Email, String User_Name, int User_AGE, Date DOB, String User_ROLE) {
        super(ID_User, Phone, addressUser, gender, CCCD, Email, User_Name, User_AGE, DOB, User_ROLE);
        this.facultyID = facultyID;
    }

   
 

    public Staff() {
    }

    public String getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(String facultyID) {
        this.facultyID = facultyID;
    }
    
   
}