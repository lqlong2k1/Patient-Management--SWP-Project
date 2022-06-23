/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Bill;

import Model.Bill.BillDetails;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface IBillDetailDAO{
    public int insertBillDetail(BillDetails billDetails);
    public void updateBillDetail(BillDetails billDetails);
    public BillDetails getSpecificBillDetails(int ID);
    public void removeBillDetails(String userID);
    public  List<BillDetails> getAllBillDetails();
    public  List<BillDetails> getAllBillDetailsbyIDBill();
}
