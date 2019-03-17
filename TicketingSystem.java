/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    // Creating a queue (LinkedList implementation)
    static Queue<Integer> queue = new LinkedList<>();

  /**
   * Program that has customers added to a queue every 3 seconds, with a sales assistant that can
   * see a customer every 5 seconds. Once a customer has been seen, they are removed from the queue.
   */
  public static void main(String[] args) {

    Timer timer = new Timer();
    // Run code in the SalesAssistantTask run() method every 5 seconds
    timer.schedule(new SalesAssisstantTask(), 0, 5000); 
    // Run code in the CustomerArrivalTask run() method every 3 seconds
    timer.schedule(new CustomerArrivalTask(), 0, 3000);

  }

  public static class SalesAssisstantTask extends TimerTask { //inner class

    public void run() {

      System.out.println("Sales Assistant is ready to see the next customer.");

      if (queue.isEmpty()) {
        System.out.println("There are no customers to see.");
      } else {
        // Returns and removes element at front of queue
        System.out.println("The customer with ticket number " + queue.poll() + " will be seen");
        // Display elements in queue
        System.out.println("The customers with the following tickets are in the queue: " + queue);
      }
    }
  }

  public static class CustomerArrivalTask extends TimerTask { //inner class
    
    // Customer variable  
    int customer = 0;

    public void run() {

      // Increment customer by 1, adds customer to the queue
      customer++;
      System.out.println("Customer with ticket " + customer + " is added to the queue");
      queue.add(customer);
    }
  }
}
