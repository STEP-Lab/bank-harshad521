package com.thoughtworks.bank;
import org.junit.Test;

public class AccountNumberTest {
    @Test(expected = InvalidAccountNumberException.class)
    public void accountNumberShouldHaveHypenInBetween() throws InvalidAccountNumberException {
        AccountNumber.validateAccountNumber("12345678");
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void accountNumberShoulldNotHaveAlphabets() throws InvalidAccountNumberException {
        AccountNumber.validateAccountNumber( "abcd-1234" );
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void accountNumberShouldNotHaveSymbolsExceptHypen() throws InvalidAccountNumberException{
        AccountNumber.validateAccountNumber( "&@12-5678" );
    }
}
