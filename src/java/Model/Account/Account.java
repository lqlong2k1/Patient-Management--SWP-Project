/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Account;

import DAO.DAOFactory;
import Model.Doctors.Doctor;
import Model.Patient.Patient;
import Model.Staff.Staff;

/**
 *
 * @author DELL
 */
public class Account {
    private int ID_ACC;
    private String user;
    private String password;
    private boolean state;

    public Account() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getID_ACC() {
        return ID_ACC;
    }

    public void setID_ACC(int ID_ACC) {
        this.ID_ACC = ID_ACC;
    }

    public Account(int ID_ACC, String user, String password, boolean state) {
        this.ID_ACC = ID_ACC;
        this.user = user;
        this.password = password;
        this.state = state;
    }

    public Account(int ID_ACC, String user, String password) {
        this.ID_ACC = ID_ACC;
        this.user = user;
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.ID_ACC;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (this.ID_ACC != other.ID_ACC) {
            return false;
        }
        return true;
    }
 public String getNameuser(){
     Patient patient =DAOFactory.getPatientDao().getSpecificPatient(user);
     Doctor doctor = DAOFactory.getDoctorDao().getSpecificDoctor(user);
     Staff staff = DAOFactory.getStaffDAO().getSpecificStaff(user);
     if (patient != null) { return patient.getUser_Name();
         
     } else if (doctor != null) {
          return doctor.getUser_Name();
     } else if (staff != null) {
         return staff.getUser_Name();
     } else {
         return "admin";
     }
    
 }
    @Override
    public String toString() {
        return "Account{" + "ID_ACC=" + ID_ACC + ", user=" + user + ", password=" + password + ", state=" + state + '}';
    }

    
}
