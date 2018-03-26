package com.thoughtworks.bank;

import java.util.ArrayList;

public class Transactions {
    protected ArrayList <Transaction> transactionLog;
    Transactions(){
        transactionLog = new ArrayList();
    }
    public void debit(double amount, String beneficiay){
        transactionLog.add(new DebitTransaction(amount,beneficiay));
    }


}
