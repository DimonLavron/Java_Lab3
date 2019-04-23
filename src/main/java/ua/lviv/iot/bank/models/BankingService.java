package ua.lviv.iot.bank.models;

import javax.persistence.*;

@Entity
public abstract class BankingService {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Embedded
    @AttributeOverrides (value = {
        @AttributeOverride (name="firstName", column=@Column(name="clientFirstName")),
        @AttributeOverride (name="surname", column=@Column(name="clientSurname"))
    })
    private Person client;

    @Embedded
    @AttributeOverrides (value = {
            @AttributeOverride (name="firstName", column=@Column(name="clerkFirstName")),
            @AttributeOverride (name="surname", column=@Column(name="clerkSurname"))
    })
    private Person clerk;

    private String dateOfBeginningService;
    private int serviceTermInMonth;
    private double serviceFee;

    public BankingService() {
    }

    public BankingService(final Currency currency, final Person client,
                          final Person clerk,
                          final String dateOfBeginningService,
                          final int serviceTermInMonth,
                          final double serviceFee) {
        this.currency = currency;
        this.client = client;
        this.clerk = clerk;
        this.dateOfBeginningService = dateOfBeginningService;
        this.serviceTermInMonth = serviceTermInMonth;
        this.serviceFee = serviceFee;
    }

    public final Currency getCurrency() {
        return currency;
    }

    public final void setCurrency(final Currency currency) {
        this.currency = currency;
    }

    public final Person getClient() {
        return client;
    }

    public final void setClient(final Person client) {
        this.client = client;
    }

    public final Person getClerk() {
        return clerk;
    }

    public final void setClerk(final Person clerk) {
        this.clerk = clerk;
    }

    public final String getDateOfBeginningService() {
        return dateOfBeginningService;
    }

    public final void
    setDateOfBeginningService(final String dateOfBeginningService) {
        this.dateOfBeginningService = dateOfBeginningService;
    }

    public final int getServiceTermInMonth() {
        return serviceTermInMonth;
    }

    public final void setServiceTermInMonth(final int serviceTermInMonth) {
        this.serviceTermInMonth = serviceTermInMonth;
    }

    public final double getServiceFee() {
        return serviceFee;
    }

    public final void setServiceFee(final double serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeaders() {
        return "currency, client, clerk, dateOfBeginningService, "
                + "serviceTermInMonth, serviceFee";
    }

    public String toCSV() {
        return "" + getCurrency() + ", " + getClient() + ", " + getClerk()
                + ", " + getDateOfBeginningService() + ", "
                + getServiceTermInMonth() + ", " + getServiceFee();
    }
}
