/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Schedule;

import DAO.DAOFactory;
import java.sql.Time;
import java.sql.Date;

/**
 *
 * @author nuoc viet
 */
public class Schedule {

    private int ID_SCHEDULE;
    private String serviceld;
    private String ID_Staff;
    private String ID_Patient;
    private Date date_apm;
    private Time end_Time;
    private Time start_Time;
    private String confirm;

    @Override
    public String toString() {
        return "Schedule{" + "ID_SCHEDULE=" + ID_SCHEDULE + ", serviceld=" + serviceld + ", ID_Staff=" + ID_Staff + ", ID_Patient=" + ID_Patient + ", date_apm=" + date_apm + ", end_Time=" + end_Time + ", start_Time=" + start_Time + ", confirm=" + confirm + '}';
    }

    public Schedule() {
    }

    public Schedule(int ID_SCHEDULE, String serviceld, String ID_Staff, String ID_Patient, Date date_apm, Time end_Time, Time start_Time, String confirm) {
        this.ID_SCHEDULE = ID_SCHEDULE;
        this.serviceld = serviceld;
        this.ID_Staff = ID_Staff;
        this.ID_Patient = ID_Patient;
        this.date_apm = date_apm;
        this.end_Time = end_Time;
        this.start_Time = start_Time;
        this.confirm = confirm;
    }

    public int getID_SCHEDULE() {
        return ID_SCHEDULE;
    }

    public void setID_SCHEDULE(int ID_SCHEDULE) {
        this.ID_SCHEDULE = ID_SCHEDULE;
    }

    public String getServiceld() {
        return serviceld;
    }

    public void setServiceld(String serviceld) {
        this.serviceld = serviceld;
    }

    public String getID_Staff() {
        return ID_Staff;
    }

    public void setID_Staff(String ID_Staff) {
        this.ID_Staff = ID_Staff;
    }

    public String getID_Patient() {
        return ID_Patient;
    }

    public void setID_Patient(String ID_Patient) {
        this.ID_Patient = ID_Patient;
    }

    public Date getDate_apm() {
        return date_apm;
    }

    public void setDate_apm(Date date_apm) {
        this.date_apm = date_apm;
    }

    public Time getEnd_Time() {
        return end_Time;
    }

    public void setEnd_Time(Time end_Time) {
        this.end_Time = end_Time;
    }

    public Time getStart_Time() {
        return start_Time;
    }

    public void setStart_Time(Time start_Time) {
        this.start_Time = start_Time;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getServiceName(){
        return DAOFactory.getServiceDAO().getSpecificService(serviceld).getNameService();
    }
}
