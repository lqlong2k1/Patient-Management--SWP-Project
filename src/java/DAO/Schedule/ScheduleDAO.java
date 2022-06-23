/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Schedule;

import DAO.DAOFactory;
import Model.Schedule.Schedule;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class ScheduleDAO implements IScheduleDAO {

    private static List<Schedule> schedule;
    private static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;

    @Override
    public Schedule getSpecificSchedule(int ID_SCHEDULE) {
        ListIterator<Schedule> ScheduleInterator = getAllSchedules().listIterator();

        while (ScheduleInterator.hasNext()) {
            Schedule thisSchedule = ((Schedule) ScheduleInterator.next());
            if (thisSchedule.getID_SCHEDULE()==ID_SCHEDULE) {
                return thisSchedule;
            }
        }
        return null;
    }

    @Override
    public List<Schedule> getAllSchedules() {
        schedule = new ArrayList();
        try {
           Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD); 
            ps = con.prepareStatement("select * from SCHEDULE");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                schedule.add(new Schedule(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getTime(7),rs.getTime(6),rs.getString(8)));
            }
            DAOFactory.closeConnection(con, ps, rs);
            return schedule;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int insertSchedule(Schedule schedule) {
        int ID_SCHEDULE = 0;

        try {
           Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
            String query = "INSERT INTO SCHEDULE(ID_SERVICE,STAFF,Patient,date_apm,START_TIME,END_TIME,CONFIRM) OUTPUT inserted.ID_SCHEDULE VALUES(?,?,?,?,?,?,?)";

            ps = con.prepareStatement(query);
            ps.setString(1, schedule.getServiceld());
            ps.setString(2, schedule.getID_Staff());
            ps.setString(3, schedule.getID_Patient());
            ps.setDate(4,  schedule.getDate_apm());
            ps.setTime(5, schedule.getStart_Time());
            ps.setTime(6, schedule.getEnd_Time());
            ps.setString(7, schedule.getConfirm());
            rs = ps.executeQuery();
            if (rs.next()) {
                ID_SCHEDULE = rs.getInt(1);
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.print(e);
        }
        return ID_SCHEDULE;
    }

    @Override
    public void updateSchedule(Schedule schedule) {

        try {
         Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
              String query = "Update SCHEDULE set ID_SERVICE=?, STAFF=?,Patient=?,date_apm=?,START_TIME=?,END_TIME=?,CONFIRM=? where ID_SCHEDULE=? ";

            ps = con.prepareStatement(query);
            ps.setString(1, schedule.getServiceld());
            ps.setString(2, schedule.getID_Staff());
            ps.setString(3, schedule.getID_Patient());
            ps.setDate(4, schedule.getDate_apm());
            ps.setTime(5, schedule.getStart_Time());
            ps.setTime(6, schedule.getEnd_Time());
            ps.setString(7, schedule.getConfirm());
            ps.setInt(8, schedule.getID_SCHEDULE());
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.print(e);
        }

    }

    ;
     @Override
    public void removeSchedule(int ID_SCHEDULE) {
        boolean flag = false;
        ListIterator<Schedule> ScheduleInterator = getAllSchedules().listIterator();
        while (ScheduleInterator.hasNext()) {
            Schedule removableSchedule = ((Schedule) ScheduleInterator.next());
            if (removableSchedule.getID_SCHEDULE()==ID_SCHEDULE) {
                try {
                  Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
              ps = con.prepareStatement("DELETE SCHEDULE WHERE ID_SCHEDULE = ?");
                    ps.setInt(1, ID_SCHEDULE);
                    ps.executeUpdate();
                    flag = true;
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(ScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (flag == false) {
            throw new RuntimeException("Remove Failed.");
        }
    }

    @Override
    public List<Schedule> getAllSchedulesfollowbyStaff(String IDStaff) {
        ListIterator<Schedule> ScheduleInterator = getAllSchedules().listIterator();
       schedule= new ArrayList();
        while (ScheduleInterator.hasNext()) {
            Schedule thisSchedule = ((Schedule) ScheduleInterator.next());
            if (thisSchedule.getID_Staff().equals(IDStaff)) {
                schedule.add(thisSchedule);
            }
        }
        return schedule;       
    }

    @Override
    public List<Schedule> getAllSchedulesfollowbyPatient(String IDPatient) {
        ListIterator<Schedule> ScheduleInterator = getAllSchedules().listIterator();
       schedule= new ArrayList();
        while (ScheduleInterator.hasNext()) {
            Schedule thisSchedule = ((Schedule) ScheduleInterator.next());
            if (thisSchedule.getID_Patient().equals(IDPatient)) {
                schedule.add(thisSchedule);
            }
        }
        return schedule;
    }
    public static void main(String[] args) {
        System.out.println(DAOFactory.getScheduleDAO().getAllSchedulesfollowbyStaff("US00001"));
    }
}