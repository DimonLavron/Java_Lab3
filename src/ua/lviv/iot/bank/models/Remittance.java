package ua.lviv.iot.bank.models;

public class Remittance extends BankingService {

    private Person receiver;
    private TypeOfRemittance type;

    public Remittance() {
    }

    public Remittance(Currency currency, Person client, Person clerk, String dateOfBeginningService, String dateOfEndingService, double serviceFee, Person receiver, TypeOfRemittance type) {
        super(currency, client, clerk, dateOfBeginningService, dateOfEndingService, serviceFee);
        this.receiver = receiver;
        this.type = type;
    }

    public Person getReceiver() {
        return receiver;
    }

    public void setReceiver(Person receiver) {
        this.receiver = receiver;
    }

    public TypeOfRemittance getType() {
        return type;
    }

    public void setType(TypeOfRemittance type) {
        this.type = type;
    }
}
