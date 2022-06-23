/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Account;

import Model.Account.Account;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface AccountDAO {
    public int newAccount(Account acc);
    public void updatePasswordAccount(Account acc);
    public List<Account> getAllAccount();
    public Account getSpecificAccountbyUserID(String UserId);
}
