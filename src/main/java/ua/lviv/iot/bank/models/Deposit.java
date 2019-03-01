package ua.lviv.iot.bank.models;

public class Deposit extends BankingService {

    private double interestRate;
    private TypeOfDeposit type;

    public Deposit() {
    }

    public Deposit(final Currency currency, final Person client, final Person clerk, final String dateOfBeginningService, final int serviceTermInMonth, final double serviceFee, final double interestRate, final TypeOfDeposit type) {
        super(currency, client, clerk, dateOfBeginningService, serviceTermInMonth, serviceFee);
        this.interestRate = interestRate;
        this.type = type;
    }

    public final double getInterestRate() {
        return interestRate;
    }

    public final void setInterestRate(final double interestRate) {
        this.interestRate = interestRate;
    }

    public final TypeOfDeposit getType() {
        return type;
    }

    public final void setType(final TypeOfDeposit type) {
        this.type = type;
    }
}
