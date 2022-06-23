/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Service;

import Model.Service.Service;
import java.util.List;

/**
 *
 * @author tlinh
 */
public interface IServiceDao {
    public String addService(Service Service);
    public Service updateService(Service Service);
    public Service getSpecificService(String userID);
    public void removeService(String userID);
    public  List<Service> getAllService();
        public  List<Service> getAllServicebyName(String name);
}