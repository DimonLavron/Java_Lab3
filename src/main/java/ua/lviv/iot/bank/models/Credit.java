package ua.lviv.iot.bank.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Credit extends BankingService {

    private double interestRate;

    @Enumerated(EnumType.STRING)
    private TypeOfCredit type;

    public Credit() {
    }

    public Credit(final Currency currency,
                  final Person client, final Person clerk,
                  final String dateOfBeginningService,
                  final int serviceTermInMonth, final double serviceFee,
                  final double interestRate, final TypeOfCredit type) {
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

    public final TypeOfCredit getType() {
        return type;
    }

    public final void setType(final TypeOfCredit type) {
        this.type = type;
    }

    @Override
    public final String getHeaders() {
        return super.getHeaders() + ", type, interestRate";
    }

    @Override
    public final String toCSV() {
        return super.toCSV() + ", " + getType() + ", " + getInterestRate();
    }

    @Override
    public final String toString() {
        return "Credit{" + super.toString()
                + "interestRate=" + interestRate
                + ", type=" + type + '}';
    }
}