package ua.lviv.iot.bank.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Deposit extends BankingService {

    private double interestRate;

    @Enumerated(EnumType.STRING)
    private TypeOfDeposit type;

    public Deposit() {
    }

    public Deposit(final Currency currency,
                   final Person client, final Person clerk,
                   final String dateOfBeginningService,
                   final int serviceTermInMonth,
                   final double serviceFee, final double interestRate,
                   final TypeOfDeposit type) {
        super(currency, client, clerk, dateOfBeginningService,
                serviceTermInMonth, serviceFee);
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

    @Override
    public final String getHeaders() {
        return super.getHeaders()  + ", type, interestRate";
    }

    @Override
    public final String toCSV() {
        return super.toCSV() + ", " + getType() + ", " + getInterestRate();
    }

    @Override
    public final String toString() {
        return "Deposit{" + super.toString()
                + "interestRate=" + interestRate
                + ", type=" + type + '}';
    }
}