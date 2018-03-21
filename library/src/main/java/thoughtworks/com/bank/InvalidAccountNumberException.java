package com.thoughtworks.bank;

public class InvalidAccountNumberException extends Exception {
    public InvalidAccountNumberException() {
        super( "Invalid Account Number : Ensure Account Number is in 0000-0000 format");
    }
}
