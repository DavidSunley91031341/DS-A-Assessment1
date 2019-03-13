/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExpressionValidation;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author dsunl
 */
public class ExpressionValidation {

    public boolean checkInput(String s){
        
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        
    Stack<Character> stack = new Stack<Character>();
    char[] charArray = s.toCharArray();
        for (Character c : charArray){
            if(map.keySet().contains(c)){
                stack.push(c);
            }
            else
                if(map.values().contains(c)){
                if(!stack.isEmpty() && map.get(stack.peek()) == c){
                    stack.pop();
                }
                else
                    return false;
                }
        }
        return stack.isEmpty();
    }
    
    
    public static void main(String[] args) {
        
        System.out.println("Welcome to the expression validating program.");
        
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter your expression:");
        String s = myObj.nextLine();
        
        ExpressionValidation ev = new ExpressionValidation();
        boolean check = ev.checkInput(s);
        if(check == true)
            System.out.println("The expression has been validated.");
        else
            System.out.println("Invalid expression.");
        
    }
}