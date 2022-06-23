/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Bill;

/**
 *
 * @author DELL
 */
public class Bill {
    String ID_BILL;
    String IDpatient;
    double total;

    public Bill() {
    }

    public Bill(String ID_BILL, String IDpatient, double total) {
        this.ID_BILL = ID_BILL;
        this.IDpatient = IDpatient;
        this.total = total;
    }

    public String getID_BILL() {
        return ID_BILL;
    }

    public void setID_BILL(String ID_BILL) {
        this.ID_BILL = ID_BILL;
    }

    public String getIDpatient() {
        return IDpatient;
    }

    public void setIDpatient(String IDpatient) {
        this.IDpatient = IDpatient;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
