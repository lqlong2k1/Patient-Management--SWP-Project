/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Account;

import DAO.DAOFactory;

import Model.Account.Account;
import Model.Account.Account_Log;
import java.sql.Connection;
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
public class AccountrDAOimplDAO implements AccountDAO {
   private static List<Account> Accounts;
    private static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;

    @Override
    public int newAccount(Account acc) {
        int ID_Account=-1;
       
        try { 
           Class.forName(DAOFactory.DRIVER_NAME);
           con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);         
            String query = "insert into ACCOUNT(USER_PASSWORD,ID_USER,STATE) output inserted.ID_ACCOUNT values(?,?,?)  "; 
         
            ps = con.prepareStatement(query);
            ps.setString(1, acc.getPassword());
            ps.setString(2,acc.getUser());
            ps.setString(2,acc.getUser());
            rs = ps.executeQuery();
            if (rs.next()){
            ID_Account= rs.getInt(1);
            }
            acc.setID_ACC(ID_Account);
            Account_Log account_Log= new Account_Log("Create Account", ID_Account);
            DAOFactory.getAccount_LogDAO().newAccount_Log(account_Log);
        } catch (ClassNotFoundException | SQLException e) {
        System.out.print(e);
        }
       return  ID_Account; 
    }

    @Override
    public void updatePasswordAccount(Account acc) {
       
        try { 
           Class.forName(DAOFactory.DRIVER_NAME);
           con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);         
            String query = "Update ACCOUNT set USER_PASSWORD=? where ID_USER=?"; 
           
            ps = con.prepareStatement(query);
            ps.setString(1, acc.getPassword());
            ps.setString(2,acc.getUser());
            ps.executeUpdate();
            Account_Log account_Log= new Account_Log("Update Password Account", acc.getID_ACC());
            DAOFactory.getAccount_LogDAO().newAccount_Log(account_Log);
        } catch (Exception e) {
        System.out.print(e);
        }
    }

    @Override
    public List<Account> getAllAccount() {
         Accounts = new ArrayList<>();
        try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
            ps = con.prepareStatement("select * from Account");
            rs = ps.executeQuery();
            while (rs.next())
            {
               Accounts.add(new Account(rs.getInt(1), rs.getString(3), rs.getString(2), rs.getBoolean(4)));
            }
            DAOFactory.closeConnection(con, ps, rs);
            return  Accounts;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AccountrDAOimplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Account getSpecificAccountbyUserID(String UserID) {
        ListIterator<Account> AccountsInterator = getAllAccount().listIterator();
           while (AccountsInterator.hasNext())
        {
            Account thisAccount = ((Account) AccountsInterator.next());
            if (thisAccount.getUser().equals(UserID)) {
              return thisAccount; 
            }
        }
        return null;
    }
  }
    

