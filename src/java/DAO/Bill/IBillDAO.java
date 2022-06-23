/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Bill;

import Model.Bill.Bill;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface IBillDAO
{
    public String insertBill(Bill bill);
    public void updateBill(Bill bill);
    public Bill getSpecificBill(String BillID);
    public void removeBill(String userID);
    public  List<Bill> getAllBill();
    public  List<Bill> getAllBillbyUser(String IDuser);
    
}
