package com.thoughtworks.bank;

import org.junit.Test;
import java.util.Date;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertThat;

public class TransactionsTest {
    @Test
    public void mustRecordDebitTransactions(){
        Transactions transactions = new Transactions( );
        transactions.debit(1000,"Viraj");
        assertThat(transactions.transactionLog,hasItem(new DebitTransaction(new Date(),1000,"Viraj")));
    }

    @Test
    public void mustRecordCreditTransactions(){
        Transactions transactions = new Transactions( );
        transactions.credit(1000,"Viraj");
        assertThat(transactions.transactionLog,hasItem(new CreditTransaction(new Date(),1000,"Viraj")));
    }
}

