/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.faculty;

/**
 *
 * @author DELL
 */
public class faculty {
    String FacultID;
    int TotalStaff;
    String FacultyName ;

    public faculty() {
       //To change body of generated methods, choose Tools | Templates.
    }

    public void setFacultID(String FacultID) {
        this.FacultID = FacultID;
    }

    public void setTotalStaff(int TotalStaff) {
        this.TotalStaff = TotalStaff;
    }

    public void setFacultyName(String FacultyName) {
        this.FacultyName = FacultyName;
    }

    public String getFacultID() {
        return FacultID;
    }

    public int getTotalStaff() {
        return TotalStaff;
    }

    public String getFacultyName() {
        return FacultyName;
    }

    public faculty(String FacultID, int TotalStaff, String FacultyName) {
        this.FacultID = FacultID;
        this.TotalStaff = TotalStaff;
        this.FacultyName = FacultyName;
    }
}
