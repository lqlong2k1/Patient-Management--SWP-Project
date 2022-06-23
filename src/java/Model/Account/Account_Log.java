/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Account;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class Account_Log {
    private String Note_Log;
    private int Id_log;
    private Date date; 
    private int ID_Account;

    public String getNote_Log() {
        return Note_Log;
    }

    public void setNote_Log(String Note_Log) {
        this.Note_Log = Note_Log;
    }

    public int getId_log() {
        return Id_log;
    }

    public void setId_log(int Id_log) {
        this.Id_log = Id_log;
    }

    public Account_Log(String Note_Log, int ID_Account) {
        this.Note_Log = Note_Log;
        this.ID_Account = ID_Account;
    }

    public Account_Log(String Note_Log, int Id_log, Date date, int ID_Account) {
        this.Note_Log = Note_Log;
        this.Id_log = Id_log;
        this.date = date;
        this.ID_Account = ID_Account;
    }

    public int getID_Account() {
        return ID_Account;
    }

    public void setID_Account(int ID_Account) {
        this.ID_Account = ID_Account;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Account_Log() {
    }
    
}
