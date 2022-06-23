/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Service;

/**
 *
 * @author tlinh
 */
public class Service {
    private String IDService;
    private String NameService;
    private float PriceService;
    private String decsription;
    private String idf;

    public String getIdf() {
        return idf;
    }

    public void setIdf(String idf) {
        this.idf = idf;
    }

    public Service() {
    }

    public Service(String IDService, String NameService, float PriceService, String decsription, String idf) {
        this.IDService = IDService;
        this.NameService = NameService;
        this.PriceService = PriceService;
        this.decsription = decsription;
        this.idf = idf;
    }

   

    public String getDecsription() {
        return decsription;
    }

    public void setDecsription(String decsription) {
        this.decsription = decsription;
    }
   

    public String getIDService() {
        return IDService;
    }

    public void setIDService(String IDService) {
        this.IDService = IDService;
    }

    public String getNameService() {
        return NameService;
    }

    public void setNameService(String NameService) {
        this.NameService = NameService;
    }

    public float getPriceService() {
        return PriceService;
    }

    public void setPriceService(float PriceService) {
        this.PriceService = PriceService;
    }

    @Override
    public String toString() {
        return "Service{" + "IDService=" + IDService + ", NameService=" + NameService + ", PriceService=" + PriceService + ", decsription=" + decsription + ", idf=" + idf + "}";
    }

    
  
}