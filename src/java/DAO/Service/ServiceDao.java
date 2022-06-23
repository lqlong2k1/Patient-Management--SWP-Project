/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Service;

import DAO.DAOFactory;

import Model.Service.Service;
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
 * @author tlinh
 */
public class ServiceDao implements IServiceDao {

    private static List<Service> Service;
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public String addService(Service Service) {
        String ID_SERVICE = "";
        try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
            String query = " Insert into SERVICE_DATA(NAME_SERVICE,PRICE,description,IDF) "
                    + "output inserted.ID_SERVICE \n"
                    + "values(?,?,?,?)  ";
            
            ps = con.prepareStatement(query);
            
            ps.setString(1, Service.getNameService());
            ps.setFloat(2, Service.getPriceService());
            ps.setString(3, Service.getDecsription());
            ps.setString(4, Service.getIdf());
            rs = ps.executeQuery();
            if (rs.next()) {
                ID_SERVICE = rs.getString(1);
            }

        } catch (Exception e) {
            System.out.print(e);
        }
        return ID_SERVICE;
    }

    @Override
    public Service updateService(Service Service) {
        try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);

            String query = " Update SERVICE_DATA set NAME_SERVICE=?,PRICE=?, Description=?,idf=? where ID_SERVICE=?";
          
            ps = con.prepareStatement(query);
            
            ps.setString(1, Service.getNameService());
            ps.setFloat(2, Service.getPriceService());
            ps.setString(3, Service.getDecsription());
            ps.setString(4, Service.getIdf());
            ps.setString(5, Service.getIDService());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.print(e);
        }
        return Service;
    }

    @Override
    public Service getSpecificService(String userID) {
        ListIterator<Service> serviceInterator = getAllService().listIterator();
        while (serviceInterator.hasNext()) {
            Service thisservice = ((Service) serviceInterator.next());
            if (thisservice.getIDService().equals(userID)) {
                return thisservice;
            }
        }
        return null;
    }

    @Override
    public void removeService(String userID) {
       try {  
             Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);         
         
            String query = "Delete FROM SERVICE_DATA where ID_SERVICE=?  "; 
                 
            ps = con.prepareStatement(query);
            ps.executeUpdate();        
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    @Override
    public List<Service> getAllService() {
        Service = new ArrayList<>();
        try {
          
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
            ps = con.prepareStatement("SELECT * FROM SERVICE_DATA");
            rs = ps.executeQuery();
            while (rs.next()) {
                  Service service = new Service();
                service.setIDService(rs.getString(1));
                service.setNameService(rs.getString(2));
                service.setPriceService(rs.getFloat(3));
                service.setDecsription(rs.getString(4));
                service.setIdf(rs.getString(5));
                Service.add(service);
            }
            DAOFactory.closeConnection(con, ps, rs);
            return Service;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(IServiceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
public static  void main(String[] args){
      System.out.println(DAOFactory.getServiceDAO().getAllServicebyName("C"));
}

    @Override
    public List<Service> getAllServicebyName(String name) {
Service = new ArrayList<>();
        try {
          
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
            ps = con.prepareStatement("SELECT * FROM SERVICE_DATA Where Name_Service like ?");
            ps.setString(1, "%"+name+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                  Service service = new Service();
                service.setIDService(rs.getString(1));
                service.setNameService(rs.getString(2));
                service.setPriceService(rs.getFloat(3));
                service.setDecsription(rs.getString(4));
                service.setIdf(rs.getString(5));
                Service.add(service);
            }
            DAOFactory.closeConnection(con, ps, rs);
            return Service;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(IServiceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}