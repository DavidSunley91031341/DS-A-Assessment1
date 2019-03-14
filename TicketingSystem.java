/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


  Analysis of data structure:
    Speed of various tasks
        - add
        - remove
    Memory efficiency
    Natural fit for model

 */
package ticketingsystem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author 91031341
 */
public class TicketingSystem {

  static Queue<Integer> queue = new LinkedList<>();

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    Timer timer = new Timer();
    timer.schedule(new SalesAssisstantTask(), 0, 5000); //run code in the SalesAssistantTask run() method every 3 seconds
    timer.schedule(new CustomerArrivalTask(), 0, 3000);

  }

  public static class SalesAssisstantTask extends TimerTask { //inner class

    public void run() {

      System.out.println("Sales Assistant is ready to see the next customer.");

      if (queue.isEmpty()) {
        System.out.println("There are no customers to see.");
      } else {
        System.out.println("The customer with ticket number " + queue.poll() + " will be seen");
        System.out.println("The customers with the following tickets are in the queue: " + queue);
      }
    }
  }

  public static class CustomerArrivalTask extends TimerTask { //inner class

    int customer = 0;

    public void run() {

      customer++;
      System.out.println("Customer with ticket " + customer + " is added to the queue");
      queue.add(customer);
      System.out.println("The customers with the following tickets are in the queue: " + queue);
    }
  }
}
