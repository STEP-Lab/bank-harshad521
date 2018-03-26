package com.thoughtworks.bank;

public class  AccountNumber {
    private String accountNumber;

    public AccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public static AccountNumber validateAccountNumber(String accountNumber) throws InvalidAccountNumberException {
        if(!accountNumber.matches("\\d{4}-\\d{4}")){
            throw new InvalidAccountNumberException();
        }
        return new AccountNumber(accountNumber);
    }
}
