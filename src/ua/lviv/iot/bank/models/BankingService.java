package ua.lviv.iot.bank.models;

public abstract class BankingService {

    private Currency currency;
    private Person client;
    private Person clerk;
    private String dateOfBeginningService;
    private String serviceTerm;
    private double serviceFee;

    public BankingService() {
    }

    public BankingService(Currency currency, Person client, Person clerk, String dateOfBeginningService, String serviceTerm, double serviceFee) {
        this.currency = currency;
        this.client = client;
        this.clerk = clerk;
        this.dateOfBeginningService = dateOfBeginningService;
        this.serviceTerm = serviceTerm;
        this.serviceFee = serviceFee;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Person getClient() {
        return client;
    }

    public void setClient(Person client) {
        this.client = client;
    }

    public Person getClerk() {
        return clerk;
    }

    public void setClerk(Person clerk) {
        this.clerk = clerk;
    }

    public String getDateOfBeginningService() {
        return dateOfBeginningService;
    }

    public void setDateOfBeginningService(String dateOfBeginningService) {
        this.dateOfBeginningService = dateOfBeginningService;
    }

    public String getServiceTerm() {
        return serviceTerm;
    }

    public void setServiceTerm(String serviceTerm) {
        this.serviceTerm = serviceTerm;
    }

    public double getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(double serviceFee) {
        this.serviceFee = serviceFee;
    }
}
