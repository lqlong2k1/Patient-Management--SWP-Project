/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.MedicalRecord;

/**
 *
 * @author DELL
 */
public class Medical {
    private String medicalId;
    private String medicalName;
    private String medicalDescription;
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Medical(String medicalId, String medicalName, String medicalDescription, double price) {
        this.medicalId = medicalId;
        this.medicalName = medicalName;
        this.medicalDescription = medicalDescription;
        this.price = price;
    }

    public Medical() {
    }

   

    public String getMedicalId() {
        return medicalId;
    }

    public String getMedicalName() {
        return medicalName;
    }

    public String getMedicalDescription() {
        return medicalDescription;
    }

    public void setMedicalId(String medicalId) {
        this.medicalId = medicalId;
    }

    public void setMedicalName(String medicalName) {
        this.medicalName = medicalName;
    }

    public void setMedicalDescription(String medicalDescription) {
        this.medicalDescription = medicalDescription;
    }
    
    
}
