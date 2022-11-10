/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketquizserver;

/**
 *
 * @author Stephen Fyfe
 */
public class Account {
    private String accountNum;
    private String pin;
    private double balance;
    
    public Account(String aNum, String p, double bal) {
        accountNum = aNum;
        pin = p;
        balance = bal;
    }
    
    public String getAccountNum() {
        return accountNum;
    }
    
    public String getPin() {
        return pin;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        balance += amount;
    }
    
    public void withdraw(double amount) {
        balance -= amount;
    }
}
