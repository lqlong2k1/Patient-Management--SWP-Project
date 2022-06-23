/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Account;

import DAO.DAOFactory;
import Model.Account.Account_Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Account_LogDAOimpl implements Account_LogDAO{
    private List<Account_Log> Account_LOG;
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    @Override
    public int newAccount_Log(Account_Log acc) {
       int ID_Log=-1;
       Date date_log=null;
        try { 
           Class.forName(DAOFactory.DRIVER_NAME);
           con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);         
            String query = "insert into Account_log(NOTE_LOG,ID_ACCOUNT) output inserted.ID_LOG,inserted.Date_Log values (?,?)  "; 
            
            ps = con.prepareStatement(query);
            ps.setString(1, acc.getNote_Log());
            ps.setInt(2, acc.getID_Account());
            rs = ps.executeQuery();
            if (rs.next()){
            ID_Log= rs.getInt(1);
            date_log=rs.getDate(2);
            }
            acc.setId_log(ID_Log);
            acc.setDate(date_log);
        } catch (Exception e) {
        System.out.print(e);
        }
       return ID_Log; 
    }

    @Override
    public void updateAccount_Log(Account_Log acc) {
        try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
            ps = con.prepareStatement("Update ACCOUNT_LOG set NOTE_LOG=?,ID_ACCOUNT=?,Date_Log=? where ID_lOG=?");
            ps.setString(1, acc.getNote_Log());
            ps.setInt(2, acc.getID_Account());
            ps.setDate(3, (java.sql.Date) acc.getDate());
            ps.setInt(4,acc.getId_log() );
            ps.executeUpdate();
            DAOFactory.closeConnection(con, ps, rs);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Account_LogDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeAccount_Log(int accLogId) {
        boolean flag = false;
        ListIterator<Account_Log> AccountLogInterator = getAllAccount_Log().listIterator();
        while (AccountLogInterator.hasNext()) {
            Account_Log removableAccount_Log = ((Account_Log) AccountLogInterator.next());
            if (removableAccount_Log.getId_log()==accLogId) {
                try {
                    Class.forName(DAOFactory.DRIVER_NAME);
                    con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
                    ps = con.prepareStatement("DELETE Account_log WHERE ID_Log = ?");
                    ps.setInt(1, accLogId);
                    ps.executeUpdate();
                    flag = true;
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(Account_LogDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (flag == false) {
           throw new RuntimeException("Remove Failed.");
        }
    }

    @Override
    public List<Account_Log> getAllAccount_Log() {
       Account_LOG = new ArrayList<>();
        try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
            ps = con.prepareStatement("select ID_lOG,NOTE_LOG,ID_ACCOUNT,Date_Log from ACCOUNT_LOG");
            rs = ps.executeQuery();
            while (rs.next())
            {
               Account_LOG.add(new Account_Log(rs.getString(2),rs.getInt(1),rs.getDate(4),rs.getInt(3)));
            }
            DAOFactory.closeConnection(con, ps, rs);
            return  Account_LOG;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Account_LogDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Account_Log> getAllAccount_LogbyAccount_ID(int acc_ID) {
           ListIterator<Account_Log> Account_LogInterator = getAllAccount_Log().listIterator();
           List<Account_Log>   Account_LOGbyIDAcc = new ArrayList<>();
           while (Account_LogInterator.hasNext())
        {
            Account_Log thisAccount_Log = ((Account_Log) Account_LogInterator.next());
            if (thisAccount_Log.getID_Account()== acc_ID) {
                Account_LOGbyIDAcc.add(thisAccount_Log);
            }
        }
        return Account_LOGbyIDAcc;
    }

    @Override
    public Account_Log getSpecificAccount_Log(int acc_LogId) {
    ListIterator<Account_Log> Account_LogInterator = getAllAccount_Log().listIterator();
           while (Account_LogInterator.hasNext())
        {
            Account_Log thisAccount_Log = ((Account_Log) Account_LogInterator.next());
            if (thisAccount_Log.getId_log()== acc_LogId) {
              return thisAccount_Log; 
            }
        }
        return null;
    }
    
}









