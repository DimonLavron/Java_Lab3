package ua.lviv.iot.bank.managers;

import ua.lviv.iot.bank.models.BankingService;

import java.util.List;

public interface BankingServicesManager {
    List<BankingService> getAvailableCredits();
    List<BankingService> getAvailableDeposits();
    List<BankingService> getAvailableCreditsSortedByServiceFee();
    List<BankingService> getAvailableDepositsSortedByServiceTerm();
    void sortByServiceFee(List<BankingService> services, boolean reverse);
}
