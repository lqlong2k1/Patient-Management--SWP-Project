/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Doctors;

import Model.User;
import Model.faculty.faculty;
import java.io.Serializable;

public class Doctor extends User implements Serializable {
    
    private String idfaculty;

    public String getIdfaculty() {
        return idfaculty;
    }

    public void setIdfaculty(String idfaculty) {
        this.idfaculty = idfaculty;
    }

    public Doctor(String idfaculty) {
        this.idfaculty = idfaculty;
    }

    public Doctor() {
    }


    
   

}

