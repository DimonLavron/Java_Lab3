package ua.lviv.iot.bank.models;

public class Remittance extends BankingService {

    private Person receiver;
    private TypeOfRemittance type;

    public Remittance() {
    }

    public Remittance(final Currency currency, final Person client,
                      final Person clerk,
                      final String dateOfBeginningService,
                      final int serviceTermInMonth, final double serviceFee,
                      final Person receiver, final TypeOfRemittance type) {
        super(currency, client, clerk, dateOfBeginningService,
                serviceTermInMonth, serviceFee);
        this.receiver = receiver;
        this.type = type;
    }

    public final Person getReceiver() {
        return receiver;
    }

    public final void setReceiver(final Person receiver) {
        this.receiver = receiver;
    }

    public final TypeOfRemittance getType() {
        return type;
    }

    public final void setType(final TypeOfRemittance type) {
        this.type = type;
    }
}
