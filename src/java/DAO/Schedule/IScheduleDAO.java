/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Schedule;

import Model.Schedule.Schedule;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface IScheduleDAO{
    public int insertSchedule(Schedule schedule);
    public Schedule getSpecificSchedule(int ID);
     public  void updateSchedule(Schedule schedule);
    public void removeSchedule(int ScheduleID);
    public  List<Schedule> getAllSchedules();
    public  List<Schedule> getAllSchedulesfollowbyStaff(String IDStaff);
    public  List<Schedule> getAllSchedulesfollowbyPatient(String IDPatient);
    

}
