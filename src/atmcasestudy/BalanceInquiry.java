/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atmcasestudy;

/**
 *
 * @author kongnyu
 */

// Represents a balance inquiry ATM transaction
public class BalanceInquiry extends Transaction {
    
    // BalanceInquiry constructor
    public BalanceInquiry(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase)
    {
    super(userAccountNumber, atmScreen, atmBankDatabase);
    }// end BalanceInquiry constructor
    
    
    //performs the transaction
    @Override
    public void execute(){
    // get reference to bank database and screen
    BankDatabase bankDatabase = getBankDatabase();
    Screen screen = getScreen();
    
    //get the available balance for the account involved
    double availableBalace = bankDatabase.getAvailableBalance(getAccountNumber());
    
// get the total balance for the account involed 
double totalBalance = bankDatabase.getTotalBalance(getAccountNumber());

// display the balance information on the screen
    screen.displayMessageLine("\nBalance Information:");
    screen.displayMessage(" - Available balance:  ");
    screen.displayDollarAmount(availableBalace);
    screen.displayMessage("\n - Total balance: ");
    screen.displayDollarAmount(totalBalance);
    screen.displayMessageLine("");
    }// end methpd execute 
    
}// end class BalanceInquiry
