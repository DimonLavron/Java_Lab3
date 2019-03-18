package ua.lviv.iot.bank.managers;

import ua.lviv.iot.bank.models.BankingService;
import ua.lviv.iot.bank.models.Credit;
import ua.lviv.iot.bank.models.Deposit;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BankingServicesManagerImpl implements BankingServicesManager {

    private List<BankingService> bankingServices = new LinkedList<>();

    public BankingServicesManagerImpl() {
    }

    public
    BankingServicesManagerImpl(final List<BankingService> bankingServices) {
        this.bankingServices = bankingServices;
    }

    public final List<BankingService> getBankingServices() {
        return bankingServices;
    }

    public final void
    setBankingServices(final List<BankingService> bankingServices) {
        this.bankingServices = bankingServices;
    }

    @Override
    public final List<BankingService> getAvailableCredits() {
        return bankingServices.stream().filter(service ->
                service instanceof Credit).collect(Collectors.toList());
    }

    @Override
    public final List<BankingService> getAvailableDeposits() {
        return bankingServices.stream().filter(service ->
                service instanceof Deposit).collect(Collectors.toList());
    }

    @Override
    public final List<BankingService> getAvailableCreditsSortedByServiceFee() {
        List<BankingService> result = bankingServices.stream().filter(service ->
                service instanceof Credit).collect(Collectors.toList());
        result.sort(Comparator.comparing(BankingService::getServiceFee));
        return result;
    }

    @Override
    public final List<BankingService>
    getAvailableDepositsSortedByServiceTerm() {
        List<BankingService> result = getAvailableDeposits();
        result.sort(Comparator.comparing(BankingService::
                getServiceTermInMonth));
        return result;
    }

    @Override
    public final void sortByServiceFee(final List<BankingService> services,
                                       final boolean reverse) {
        if (reverse) {
            services.sort(Comparator.comparing(BankingService::getServiceFee).
                    reversed());
        } else {
            services.sort(Comparator.comparing(BankingService::getServiceFee));
        }
    }
}
