package ua.lviv.iot.bank.models;

public class Credit extends BankingService {

    private double interestRate;
    private TypeOfCredit type;

    public Credit() {
    }

    public Credit(Currency currency, Person client, Person clerk, String dateOfBeginningService, String dateOfEndingService, double serviceFee, double interestRate, TypeOfCredit type) {
        super(currency, client, clerk, dateOfBeginningService, dateOfEndingService, serviceFee);
        this.interestRate = interestRate;
        this.type = type;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public TypeOfCredit getType() {
        return type;
    }

    public void setType(TypeOfCredit type) {
        this.type = type;
    }
}
