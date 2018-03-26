package com.thoughtworks.bank;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransactionTest {
    @Test
    public void mustRecordCorrectDebitTransactionDate() {
        Date date = new Date();
        Transaction transaction = new DebitTransaction(date, 1000,"Jack");
        assertThat(transaction.getDate(),is(date));
    }

    @Test
    public void mustRecordCorrectCreditTransaction() {
        Date date = new Date( );
        Transaction transaction = new CreditTransaction(date,5000,"Jack");
        assertThat( transaction.getDate(),is(date) );
    }
}
