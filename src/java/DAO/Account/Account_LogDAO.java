/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Account;

import Model.Account.Account_Log;
import java.util.List;



/**
 *
 * @author DELL
 */
public interface Account_LogDAO {
    
    public int newAccount_Log(Account_Log acc);
    public void updateAccount_Log(Account_Log acc);
    public void removeAccount_Log(int accId);
    public List<Account_Log> getAllAccount_Log();
    public List<Account_Log> getAllAccount_LogbyAccount_ID(int acc_Id);
    public Account_Log getSpecificAccount_Log(int acc_LogId);
}
