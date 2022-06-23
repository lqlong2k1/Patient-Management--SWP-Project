/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Bill;

import DAO.DAOFactory;
import Model.Account.Account;
import Model.Account.Account_Log;
import Model.Bill.Bill;
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
public class BillDAO implements  IBillDAO{
 private static List<Bill> bills;
    private static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;

    @Override
    public String insertBill(Bill bill) {
       String ID_Bill = "empty";
       
        try { 
           Class.forName(DAOFactory.DRIVER_NAME);
           con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);         
            String query = "insert into Bill(Patient,Total) output inserted.ID_Bill values(?,?)  "; 
            
            ps = con.prepareStatement(query);
            ps.setString(1, bill.getIDpatient());
            ps.setDouble(2,bill.getTotal());
            rs = ps.executeQuery();
            if (rs.next()){
            ID_Bill= rs.getString(1);
            }
            
        } catch (ClassNotFoundException | SQLException e) {
        System.out.print(e);
        }
       return ID_Bill;
    }

    @Override
    public void updateBill(Bill bill) {
      
       
        try { 
           Class.forName(DAOFactory.DRIVER_NAME);
           con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);         
            String query = "Update BILL set PATIENT=?, TOTAL =? where ID_BILL=?)  "; 
            
            ps = con.prepareStatement(query);
            ps.setString(1, bill.getIDpatient());
            ps.setDouble(2,bill.getTotal());
            ps.setString(3, bill.getID_BILL());
            ps.executeUpdate();       
        } catch (ClassNotFoundException | SQLException e) {
        System.out.print(e);
        }
   
    }
    

    @Override
    public Bill getSpecificBill(String IDBill) {
         ListIterator<Bill> BillInterator = getAllBill().listIterator();
         
           while (BillInterator.hasNext())
        {
            Bill thisBill = ((Bill) BillInterator.next());
            if (thisBill.getID_BILL().equals(IDBill)) {
                return  thisBill;
            }
        }
        return null;
    }

    @Override
    public void removeBill(String ID_BILL) {
        boolean flag = false;
        ListIterator<Bill> BillInterator = getAllBill().listIterator();
        while (BillInterator.hasNext()) {
            Bill removableBill = ((Bill) BillInterator.next());
            if (removableBill.getID_BILL().equals(ID_BILL)) {
                try {
                    Class.forName(DAOFactory.DRIVER_NAME);
                    con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
                    ps = con.prepareStatement("DELETE Bill WHERE ID_BILL = ?");
                    ps.setString(1,ID_BILL );
                    ps.executeUpdate();
                    flag = true;
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (flag == false) {
           throw new RuntimeException("Remove Failed.");
        }
    }

    @Override
    public List<Bill> getAllBill() {
        bills= new ArrayList();
        try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
            ps = con.prepareStatement("select * from BILL");
            rs = ps.executeQuery();
            while (rs.next())
            {
               bills.add(new Bill(rs.getString(1),rs.getString(2),rs.getDouble(3)));
            }
            DAOFactory.closeConnection(con, ps, rs);
            return  bills;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Bill> getAllBillbyUser(String IDUser) {
         ListIterator<Bill> BillInterator = getAllBill().listIterator();
           List<Bill>   getAllBillbyUser = new ArrayList<>();
           while (BillInterator.hasNext())
        {
            Bill thisBill = ((Bill) BillInterator.next());
            if (thisBill.getIDpatient().equals(IDUser)) {
                getAllBillbyUser.add(thisBill);
            }
        }
        return getAllBillbyUser;
    }
    
}
