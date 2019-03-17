/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalrecords;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 91031341
 */
public class HospitalRecords {

  /**
   * Program that offers search and delete functionality for list of hospital patients
   */
  public static void main(String[] args) {
    HospitalRecords myHospital = new HospitalRecords();
    myHospital.obtainRecords();

    while (true) {
      String choice = myHospital.userInteraction("Press S for search, Press E for exit");

      Patient delete = null; // variable to store patients that are to be deleted from records
      Boolean found = false; // boolean to be used when searching for patients

      if (choice.equals("S")) {
        System.out.println("Searcing...");
        String patientID = myHospital.userInteraction("Enter Patient ID to search");
        for (Patient pID : myHospital.patientRecords) { // Loop through patientRecords ArrayList
          if (pID.getPatientID().equals(patientID)) {
            found = true; // If patientID string matches any ID in the ListOfPatients, return true and display their information
            System.out.println("\n" + pID);
            System.out.println("Would you like to remove the patient's record(s)?");
            String deleteID = myHospital.userInteraction("Y or N?\n");
            if (deleteID.equals("Y")) {
              delete = pID; // Storing the patient in the 'delete' variable to be dealt with after the loop
            } else {
              break;
            }
          }
        }
        if (!found) {
          System.out.println("The search found no matching patient."); // patientID string has no match in the records
        }

        if (delete != null) {
          myHospital.patientRecords.remove(delete); // Remove any patient stored in 'delete' from ListOfPatients
          System.out.println("Record(s) removed successfully\n");
        }

      } else if (choice.equals("E")) {
        System.out.println("Goobye.");
        break;
      }
    }
  }
  
  // ArrayList to store patient records
  ArrayList<Patient> patientRecords = new ArrayList();

  public void obtainRecords() {
    String path = "src/hospitalrecords/ListOfPatients.txt";
    //Use path to the ListOfPatients.txt here
    LineNumberReader lr = null;
    //allows to read information from the file line by line
    String[] oneRecord = new String[4];
    //an array to store info about one patient
    Patient pat;
    try {
      //using try-catch for exception handling to catch
      //possible errors with i/o operations
      FileReader inputStream = new FileReader(path);
      //FileReader reads the fileâ€™s contents
      lr = new LineNumberReader(inputStream);
      String str;
      while ((str = lr.readLine()) != null) {
        //while the next line exists
        oneRecord = str.split(",");
        //dividing one file line by commas and assigning to array
        pat = new Patient(oneRecord[0], oneRecord[1], oneRecord[2], oneRecord[3]);

        patientRecords.add(pat);
        System.out.println(pat);
      }
    } catch (IOException ioe) {
      System.out.println("IOExcception occured");
    }
  }
  
  // Method for user input
  public String userInteraction(String userInput) {
    System.out.println(userInput);
    Scanner choice = new Scanner(System.in);
    String userChoice = choice.nextLine();
    return userChoice;
  }
}
