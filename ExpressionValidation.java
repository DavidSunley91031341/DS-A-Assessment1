/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expressionvalidation;

import java.util.Scanner;
import java.util.Stack;

/*
 * @author 91031341
 */
public class ExpressionValidation {
  
  /**
   * @param s: User string expression to be validated
   * @param open: Opening character of expression
   * @param close: Closing character of expression 
   * @returns false if first index of charArray != opening character 
   * @returns false if last index of charArray != closing character 
   * @returns false if stack !empty after loop
   */
  public boolean checkInput(String s, char open, char close) {
    
    //Creating a new stack
    Stack<Character> stack = new Stack<Character>();
    //Converting string s to a charArray
    char[] charArray = s.toCharArray();
    //
    for (int i = 0; i < charArray.length; i++) {

      char a = charArray[i];
      // If any character in the charArray
      if (a == open) {
        stack.push(open);
      }
      if (a == close) {
        stack.pop();
      }
      if (open != charArray[0]) {
        return false;
      }
      if (close != charArray[charArray.length - 1]) {
        return false;
      }
    }

    if (stack.isEmpty()) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {

    System.out.println("Welcome to the expression validating program.");
    
    //Expression string
    Scanner exp = new Scanner(System.in);
    System.out.println("Enter your expression:");
    String e = exp.nextLine();    
    
    //Opening character
    System.out.println("Enter the opening character to validate:");
    char o = exp.nextLine().charAt(0);    
    
    //Closing charcter
    System.out.println("Enter the closing character to validate:");
    char c = exp.nextLine().charAt(0);    
    
    //Instantiation of ExpressionValidation
    ExpressionValidation ev = new ExpressionValidation();
    
    //Instantiation of checkInput method
    boolean eCheck = ev.checkInput(e, o, c);    //

    if (eCheck == true) {
      System.out.println("The expression has been validated.");
    } else {
      System.out.println("Invalid expression.");
    }
  }
}
