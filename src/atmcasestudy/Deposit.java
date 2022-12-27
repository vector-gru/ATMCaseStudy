/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atmcasestudy;

/**
 *
 * @author kongnyu
 */
// Represents a deposit ATM transaction
public class Deposit extends Transaction {
    private double amount; // amount to deposit
    private Keypad keypad; // reference to keypad
    private DepositSlot depositSlot; // reference to deposit slot
    private final static int CANCELED = 0; // constant for cancel option
    
    //Deposit constructor
    public Deposit(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad, DepositSlot atmDepositSlot)
    {
    //initialize superclass variables
        super(userAccountNumber, atmScreen, atmBankDatabase);
        
        // initialize reference to keypad and deposit slot
        keypad = atmKeypad;
        depositSlot = atmDepositSlot;
    }// end Deposit constructor
    
    @Override
    public void execute(){
    BankDatabase bankDatabase = getBankDatabase(); //get reference
    Screen screen = getScreen(); // get reference 
    
    amount = promptForDepositAmount(); // get deposit amount from user
    
    // check whether user entered a deposit amount or canceled
    if(amount != CANCELED){
    //request deposit envelope containing specified amount
    screen.displayDollarAmount(amount);
    screen.displayMessageLine(".");
    
    //received deposite envelope
    boolean envelopeReceived = depositSlot.isEnvelopeReceived();
    
    //check whether deposit envelope was received 
    if(envelopeReceived){
    screen.displayMessageLine("\nYour envelope has been received. \nNOTE: The"
            + "The money just deposited will not be available until we verify"
            + "the amount of any enclosed cash and your checks clear ");
    
    //credit account to reflect the deposit
    bankDatabase.credit(getAccountNumber(), amount);
    }//end if
    else {
    screen.displayMessageLine("\nYou did not insert an envelope, so the "
            + "ATM has canceled your transaction");
    }//end else
    }//end if
    else // user canceled instead of entering amount
    {
    screen.displayMessageLine("\nCanceling transaction...");
    }// end else
    }// end method execute
    
    //prompt user to enter a deposit amount in cents
    private double promptForDepositAmount(){
    Screen screen = getScreen(); // get reference to screen
    
    // display the prompt
    screen.displayMessage("\nPlease enter a deposit amount"
            + "in CENTS (or 0 to cancel");
    
    int input = keypad.getInput(); // receive input of deposit amount
    
    // check whether the user canceled or entered a valid amount
    if(input == CANCELED)
        return CANCELED;
    else
    {
    return (double) input/100; // return dollar amount
    }//end else
    }//end method promptForDepositAmount
    
}//end class Deposit
