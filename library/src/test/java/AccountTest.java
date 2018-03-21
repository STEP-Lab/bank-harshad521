import com.thoughtworks.bank.Account;
import com.thoughtworks.bank.InvalidAccountNumberException;
import com.thoughtworks.bank.MinimumBalanceException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest {

    private Account account;

    @Before
    public void setUp() throws Exception {
        account = new Account("1234-5678",2000.00);
    }

    @Test
    public void checkBalance() {
        assertThat( account.getBalance(),is(2000.00));
    }

    @Test
    public void checkAccountNumber() {
        assertThat( account.getAccountNumber(),is("1234-5678") );
    }

    @Test(expected = MinimumBalanceException.class)
    public void checkMinimumOpeningBalance () throws MinimumBalanceException, InvalidAccountNumberException {
        new Account("1234-5678" ,400.00);
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void valiadteAccountNumber() throws InvalidAccountNumberException, MinimumBalanceException {
        new Account( "12345678",1000.00 );
    }

    @Test
    public void creditMoney() throws MinimumBalanceException {
        assertThat( account.getBalance(),is( 2000.00 ));
        assertThat( account.credit(1000.00),is(3000.00) );
    }

    @Test
    public void debitMoney() throws MinimumBalanceException {
        assertThat( account.getBalance(),is(2000.00) );
        assertThat( account.debit(1000.00),is(1000.00) );
    }

    @Test(expected = MinimumBalanceException.class)
    public void validateIsAbleToCredit() throws MinimumBalanceException{
        assertThat( account.getBalance(),is( 2000.00 ) );
        account.credit( -1.00 );
    }

    @Test(expected = MinimumBalanceException.class)
    public void validateIsAbleToDebit() throws MinimumBalanceException{
        assertThat( account.getBalance(),is(2000.00) );
        account.debit(2000.54);
    }
}
