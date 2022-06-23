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
public class BillDetails {
    int ID_BD;
    String ID_BILL;
    String ID_service;

    public BillDetails() {
    }

    public BillDetails(int ID_BD, String ID_BILL, String ID_service) {
        this.ID_BD = ID_BD;
        this.ID_BILL = ID_BILL;
        this.ID_service = ID_service;
    }

    public int getID_BD() {
        return ID_BD;
    }

    public void setID_BD(int ID_BD) {
        this.ID_BD = ID_BD;
    }

    public String getID_BILL() {
        return ID_BILL;
    }

    public void setID_BILL(String ID_BILL) {
        this.ID_BILL = ID_BILL;
    }

    public String getID_service() {
        return ID_service;
    }

    public void setID_service(String ID_service) {
        this.ID_service = ID_service;
    }
}
