package com.thoughtworks.bank;
import org.junit.Test;

public class AccountNumberTest {
    @Test(expected = InvalidAccountNumberException.class)
    public void accountNumberShouldHaveHypenInBetween() throws InvalidAccountNumberException {
        new AccountNumber("12345678");
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void accountNumberShoulldNotHaveAlphabets() throws InvalidAccountNumberException {
        new AccountNumber( "abcd-1234" );
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void accountNumberShouldNotHaveSymbolsExceptHypen() throws InvalidAccountNumberException{
        new AccountNumber( "&@12-5678" );
    }
}
