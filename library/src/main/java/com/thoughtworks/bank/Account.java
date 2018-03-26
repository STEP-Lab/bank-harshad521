package com.thoughtworks.bank;

public class Account {
    private final AccountNumber accountNumber;
    private double balance;
    private String accountHolder;

    public Account(AccountNumber accountNumber, double balance , String name){
        accountHolder = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public static Account createAccount(String number, double balance , String name) throws MinimumBalanceException, InvalidAccountNumberException {
        AccountNumber accountNumber = AccountNumber.validateAccountNumber(number);
        validateMinimumBalance(balance);
        return new Account( accountNumber,balance,name);
    }

    public double getBalance() {
        return balance;
    }

//    private void validateCreditTransaction(double amount)throws MinimumBalanceException{
//        if(!(amount>0)){
//            throw new MinimumBalanceException( "Invalid Amount : Enter valid amount to credit" );
//        }
//    }
//    private void validateDebitTransaction(double amount)throws MinimumBalanceException{
//        double balance = getBalance()-amount;
//        validateMinimumBalance( balance );
//    }
    private static void validateMinimumBalance(double amount)throws MinimumBalanceException{
        if(amount<1000){
            throw new MinimumBalanceException( "Transaction Declined : Maintain minimum balance" );
        }
    }
}
