package ua.lviv.iot.bank.models;

public class Deposit extends BankingService {

    private double interestRate;
    private TypeOfDeposit type;

    public Deposit() {
    }

    public Deposit(Currency currency, Person client, Person clerk, String dateOfBeginningService, int serviceTermInMonth, double serviceFee, double interestRate, TypeOfDeposit type) {
        super(currency, client, clerk, dateOfBeginningService, serviceTermInMonth, serviceFee);
        this.interestRate = interestRate;
        this.type = type;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public TypeOfDeposit getType() {
        return type;
    }

    public void setType(TypeOfDeposit type) {
        this.type = type;
    }
}
