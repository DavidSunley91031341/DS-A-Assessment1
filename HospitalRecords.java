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
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    HospitalRecords myHospital = new HospitalRecords();
    myHospital.obtainRecords();

    while (true) {
      String choice = myHospital.userInteraction("Press S for search, Press E for exit");

      Patient delete = null;
      Boolean found = false;

      if (choice.equals("S")) {
        System.out.println("Searcing...");
        String patientID = myHospital.userInteraction("Enter Patient ID to search");
        for (Patient pID : myHospital.patientRecords) {
          if (pID.getPatientID().equals(patientID)) {
            found = true;
            System.out.println("\n" + pID);
            System.out.println("Would you like to remove the patient's record(s)?");
            String deleteID = myHospital.userInteraction("Y or N?\n");
            if (deleteID.equals("Y")) {
              delete = pID;
            } else {
              break;
            }
          }
        }
        if (!found) {
          System.out.println("The search found no matching patient.");
        }

        if (delete != null) {
          myHospital.patientRecords.remove(delete);
          System.out.println("Record(s) removed successfully\n");
        }

      } else if (choice.equals("E")) {
        System.out.println("Goobye.");
        break;
      }
    }
  }

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
      //FileReader reads the file’s contents
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

  public String userInteraction(String userInput) {
    System.out.println(userInput);
    Scanner choice = new Scanner(System.in);
    String userChoice = choice.nextLine();
    return userChoice;
  }
}
