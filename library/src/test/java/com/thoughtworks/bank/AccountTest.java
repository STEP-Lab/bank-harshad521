package com.thoughtworks.bank;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest {

    private Account account;

    @Before
    public void setUp() throws InvalidAccountNumberException, MinimumBalanceException {
        account = Account.createAccount("1234-5678",2000.00,"Jack");
    }

    @Test
    public void checkBalance() {
        assertThat( account.getBalance(),is(2000.00));
    }


    @Test(expected = MinimumBalanceException.class)
    public void checkMinimumOpeningBalance () throws MinimumBalanceException, InvalidAccountNumberException {
        Account.createAccount("1234-5678" ,400.00,"Jack");
    }

}
