/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalrecords;

/**
 *
 * @author 91031341
 */
public class Patient {

  private String patientID;
  private String name;
  private String checkInDate;
  private String assignedPersonnel;

  
  public String toString() {

    return "Patient ID: " + getPatientID()
            + "\nName: " + getName()
            + "\nCheck In Date: " + getCheckInDate()
            + "\nAssigned Personnel: " + getAssignedPersonnel() + "\n";
  }

  
  public Patient(String patientID, String name, String checkInDate, String assignedPersonnel) {
    this.patientID = patientID;
    this.name = name;
    this.checkInDate = checkInDate;
    this.assignedPersonnel = assignedPersonnel;
  }

  
  public String getPatientID() {
    return patientID;
  }

  
  public void setPatientID(String patientID) {
    this.patientID = patientID;
  }

  
  public String getName() {
    return name;
  }

  
  public void setName(String name) {
    this.name = name;
  }

  
  public String getCheckInDate() {
    return checkInDate;
  }

  
  public void setCheckInDate(String checkInDate) {
    this.checkInDate = checkInDate;
  }

  
  public String getAssignedPersonnel() {
    return assignedPersonnel;
  }

  
  public void setAssignedPersonnel(String assignedPersonnel) {
    this.assignedPersonnel = assignedPersonnel;
  }
}
