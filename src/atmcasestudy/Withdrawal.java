/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atmcasestudy;

/**
 *
 * @author kongnyu
 */
// Represent a withdrawal ATM transaction
public class Withdrawal extends Transaction {
    private int amount; // amount to withdraw
    private Keypad keypad; // reference to keypad
    private CashDispenser cashDispenser; // reference to cash dispenser
    
    // constant correstponding to menu option to cancel
    private final static int CANCELED = 6;
    
    //Withdraw constructor
    public Withdrawal(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad, CashDispenser atmCashDispenser)
    {
    // initialize superclass variables
        super(userAccountNumber, atmScreen, atmBankDatabase);
        
        // initialize references to keypad and cash dispenser
        keypad = atmKeypad;
        cashDispenser = atmCashDispenser;
    }//end Withdrawal constructor
    
    @Override
    public void execute(){
    boolean cashDispensed = false; // cash was not dispensed yet
    double availableBalance; // amount available for withdrawal
    
    // get reference to bank database and screen
    BankDatabase bankDatabase = getBankDatabase();
    Screen screen = getScreen();
    
    //loop until cash is dispensed or the user cancels
    do
    {
    // obtain a chosen withdrawal amount from the user
        amount = displayMenuOfAmounts();
        
        // check whether user chose a withdrawal amount or canceled
        if (amount !=CANCELED){
        //get available balance of account involved
        availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());
        
        //check whether the user has enough money in the account
        if(amount <= availableBalance){
        // check whether the cash dispenser has enough money
        
        if(cashDispenser.isSufficientCashAvailable(amount))
        {
            // update the account involved to reflect the withdrawal
            bankDatabase.debit(getAccountNumber(), amount);
            
            cashDispenser.dispenseCash(amount);//dispense cash
            cashDispensed = true; // cash was dispensed
            
            // instruct user to take cash
            screen.displayMessageLine("\nYour cash has been dispensed. Please take your cash now");
        }//end if
        else //cash dispenser does not have enough cash
            screen.displayMessageLine("\nInssuficient cash available in the ATM. \n\nPlease choose a smaller amount.");
        }//end if
        else  // not enough money available in user's account
        {
        screen.displayMessageLine("\nInsufficient funds in your account. \n\n Please choose a smaller amount");
        }// end else
        }// end if
        else
        {
        screen.displayMessageLine("\nCanceling transaction...");
        return; // return to main menu because user cancled
        }// end else
    }//end do
    while(!cashDispensed);
    }//end execute
    
    //display a menu of withdrawal amounts and the option to cancle;
    // return the chose amount or 0 if the user chooses to cancel
    
    private int displayMenuOfAmounts(){
    
        int userChoice = 0; // local variable ti store return value
        
        Screen screen = getScreen(); // get screen reference
        
        // array of amounts to correspond to menu numbers
        int [] amounts = {0, 20, 40, 60, 100, 200};
        
        // loop while no valid choice has been made
        while(userChoice ==0){
        //display the withdrawal menu
        screen.displayMessageLine("\nWithdrawal Menu:");
        screen.displayMessageLine("1 - $20");
        screen.displayMessageLine("2 - $40");
        screen.displayMessageLine("3 - $60");
        screen.displayMessageLine("4 - $100");
        screen.displayMessageLine("5 - $200");
        screen.displayMessageLine("6 - Cancel transaction");
        screen.displayMessage("\nChoose a withdrawal amount:");
        
        int input = keypad.getInput(); // get user input through keypad
        
        // determine how to proceed based on the input value
        switch(input){
            case 1: //if the user chose a withdrawal amout
            case 2: // (i.e.., chose option 1,2,3,4 or 5), return the 
            case 3: // corresponding amount from amounts array
            case 4: 
            case 5: 
                userChoice = amounts[input]; // save user's choice
                break;
            default: // the user did not enter a value from 1-6
             screen.displayMessageLine("\nInvalid selection. Try again.");
        }//end switch
        }//end while
        return userChoice; //return withdrawal amount or CANCELED
    }//end method displayMenuOfAmounts
}//end class Withdrawal
