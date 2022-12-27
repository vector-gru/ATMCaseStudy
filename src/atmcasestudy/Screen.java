/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atmcasestudy;

/**
 *
 * @author kongnyu
 */

// Represent the screen of the ATM
public class Screen {
    public void displayMessage(String message){
    System.out.print(message);
    }// end display message
    
    // display a message with a carriage return
    public void displayMessageLine(String message){
    System.out.println(message);
    }// end method displayMessageLine
    
    // display a dollar amount
    public void displayDollarAmount(Double amount){
    System.out.printf("$%, .2f", amount);
    }// end method displayDollarAmount
}// end class Screen
