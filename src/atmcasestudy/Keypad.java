/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atmcasestudy;

/**
 *
 * @author kongnyu
 */

// Keypad Represents the keyboard of the ATM
import java.util.Scanner; // program uses Scanner to obtain user input

public class Keypad {
    private Scanner input; // reads data from the command line
    
    // no-arguement constructor initializes the Scanner
    public Keypad(){
    input = new Scanner(System.in);
    }// end no-arguement Keypad constructor
    
    // return an integer value entered by user
    public int getInput(){
    return input.nextInt(); // we assume that the user enters an integer
    }// end method getInput
    
}// end class Keypad
