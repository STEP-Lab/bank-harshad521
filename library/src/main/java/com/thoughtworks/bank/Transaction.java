package com.thoughtworks.bank;

import java.util.Date;
import java.util.Objects;

public class Transaction {
    private final Date date;
    private final double amount;
    private final String beneficiary;

    public Transaction(Date date, double amount, String beneficiary) {
        this.date = date;
        this.amount = amount;
        this.beneficiary = beneficiary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare( that.amount, amount ) == 0 &&
                Objects.equals( date.toString(), that.date.toString() ) &&
                Objects.equals( beneficiary, that.beneficiary );
    }

    @Override
    public int hashCode() {

        return Objects.hash( date.toString(), amount, beneficiary );
    }

    public Date getDate(){
        return this.date;

    }

}
