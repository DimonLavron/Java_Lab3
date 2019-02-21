package ua.lviv.iot.bank.models;

public abstract class BankingService {

    private Currency currency;
    private Person client;
    private Person clerk;
    private String dateOfBeginningService;
    private int serviceTermInMonth;
    private double serviceFee;

    public BankingService() {
    }

    public BankingService(Currency currency, Person client, Person clerk, String dateOfBeginningService, int serviceTermInMonth, double serviceFee) {
        this.currency = currency;
        this.client = client;
        this.clerk = clerk;
        this.dateOfBeginningService = dateOfBeginningService;
        this.serviceTermInMonth = serviceTermInMonth;
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

    public int getServiceTermInMonth() {
        return serviceTermInMonth;
    }

    public void setServiceTermInMonth(int serviceTermInMonth) {
        this.serviceTermInMonth = serviceTermInMonth;
    }

    public double getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(double serviceFee) {
        this.serviceFee = serviceFee;
    }
}
