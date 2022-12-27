/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atmcasestudy;

/**
 *
 * @author kongnyu
 */

// Represent a bank account

public class Account {
    private int accountNumber; // account number
    private int pin; // PIN for authentication
    private double availableBalance; // funds available for withdrawal
    private double totalBalance; // funds available + pending deposits
    
    // Account constructor initializes attribues
    public Account(int theAccountNumber, int thePIN, double theAvailableBalance, double theTotalBalance){
    
        accountNumber = theAccountNumber;
        pin = thePIN;
        availableBalance = theAvailableBalance;
        totalBalance = theTotalBalance;
    }// end constructor 
    
    // determines whether a user-specified PIN matches PIN in Account
    
    public boolean validatePIN(int userPIN){
    if (userPIN == pin)
        return true;
    else 
        return false;
    }// end method validatePIN
    
    // returns available balance
    public double getAvailableBalance(){
    return availableBalance;
    }// end method getAvailableBalance
    
    // return the total balance
    public double getTotalBalance(){
    return totalBalance;
    }// end method getTotlalBalance
    
    // credits an amount to the account
    public void credit(double amount){
    totalBalance += amount; // add to total balance
    }// end method credit
    
    //debits an amount from the account
    public void debit(double amount){
    availableBalance -= amount; // subtract from available balance
    totalBalance -= amount; // subtract from the total balance
    }// end method debit
    
    //return account number
    public int getAccountNumber(){
    return accountNumber;
    }// end method getAccountNumber 
}// end class Account
