package ua.lviv.iot.bank.models;

import javax.persistence.*;

@Entity
public class Remittance extends BankingService {

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "firstName",
                    column = @Column(name = "receiverFirstName")),
            @AttributeOverride (name = "surname",
                    column = @Column(name = "receiverSurname"))
    })
    private Person receiver;

    @Enumerated(EnumType.STRING)
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

    @Override
    public final String getHeaders() {
        return super.getHeaders() + ", type, receiver";
    }

    @Override
    public final String toCSV() {
        return super.toCSV() + ", " + getType() + ", " + getReceiver();
    }

    @Override
    public final String toString() {
        return "Remittance{" + super.toString()
                + "receiver=" + receiver
                + ", type=" + type + '}';
    }
}