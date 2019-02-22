package ua.lviv.iot.bank.managers;

import ua.lviv.iot.bank.models.BankingService;
import ua.lviv.iot.bank.models.Credit;
import ua.lviv.iot.bank.models.Deposit;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BankingServicesManagerImpl implements BankingServicesManager {

    List<BankingService> bankingServices;

    @Override
    public List<BankingService> getAvailableCredits() {
        return bankingServices.stream().filter(service -> service instanceof Credit).collect(Collectors.toList());
    }

    @Override
    public List<BankingService> getAvailableDeposits() {
        return bankingServices.stream().filter(service -> service instanceof Deposit).collect(Collectors.toList());
    }

    @Override
    public List<BankingService> getAvailableCreditsSortedByServiceFee() {
        List<BankingService> result = bankingServices.stream().filter(service -> service instanceof Credit).collect(Collectors.toList());
        result.sort(Comparator.comparing(BankingService::getServiceFee));
        return result;
    }

    @Override
    public List<BankingService> getAvailableDepositsSortedByServiceTerm() {
        List<BankingService> result = getAvailableDeposits();
        result.sort(Comparator.comparing(BankingService::getServiceTermInMonth));
        return result;
    }

    @Override
    public void sortByServiceFee(List<BankingService> services, boolean reverse) {
        if (reverse)
            services.sort(Comparator.comparing(BankingService::getServiceFee).reversed());
        services.sort(Comparator.comparing(BankingService::getServiceFee));
    }
}
