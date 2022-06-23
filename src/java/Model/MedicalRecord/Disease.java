/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.MedicalRecord;

/**
 *
 * @author Anh Tuan
 */
public class Disease {
    private String diseaseId;
    private String diseaseName;
    private String diseaseDescription;

    public Disease() {
    }

    public Disease(String diseaseId, String diseaseName, String diseaseDescription) {
        this.diseaseId = diseaseId;
        this.diseaseName = diseaseName;
        this.diseaseDescription = diseaseDescription;
    }

    public void setDiseaseId(String diseaseId) {
        this.diseaseId = diseaseId;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public void setDiseaseDescription(String diseaseDescription) {
        this.diseaseDescription = diseaseDescription;
    }

    public String getDiseaseId() {
        return diseaseId;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public String getDiseaseDescription() {
        return diseaseDescription;
    } 

    @Override
    public String toString() {
        return "Disease{" + "diseaseId=" + diseaseId + ", diseaseName=" + diseaseName + ", diseaseDescription=" + diseaseDescription + '}';
    }
    
}