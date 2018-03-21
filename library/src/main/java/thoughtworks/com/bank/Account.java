package com.thoughtworks.bank;

public class Account {
    private final String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) throws MinimumBalanceException,InvalidAccountNumberException {
        validateMinimumBalance(balance);
        if(!accountNumber.matches("\\d{4}-\\d{4}")){
            throw new InvalidAccountNumberException();
        }
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double credit(double amount) throws MinimumBalanceException {
        validateCreditTransaction(amount);
        balance += amount;
        return getBalance();
    }

    public double debit(double amount) throws MinimumBalanceException {
        validateDebitTransaction(amount);
        balance -= amount;
        return getBalance();
    }
    private void validateCreditTransaction(double amount)throws MinimumBalanceException{
        if(!(amount>0)){
            throw new MinimumBalanceException( "Invalid Amount : Enter valid amount to credit" );
        }
    }
    private void validateDebitTransaction(double amount)throws MinimumBalanceException{
        double balance = getBalance()-amount;
        validateMinimumBalance( balance );
    }
    private void validateMinimumBalance(double amount)throws MinimumBalanceException{
        if(amount<1000){
            throw new MinimumBalanceException( "Transaction Declined : Maintain minimum balance" );
        }
    }
}
