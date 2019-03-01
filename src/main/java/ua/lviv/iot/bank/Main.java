package ua.lviv.iot.bank;

import ua.lviv.iot.bank.managers.BankingServicesManagerImpl;
import ua.lviv.iot.bank.models.*;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(final String[] args) {
        BankingServicesManagerImpl manager = new BankingServicesManagerImpl();

        List<BankingService> listOfServices = new LinkedList<>();
        listOfServices.add(new Credit(Currency.EUR, new Person("Dima", "Lavrishyn"), new Person("Ivan", "Petrov"), "12.01.2019", 12, 12.5, 9.8, TypeOfCredit.CONSUMER));
        listOfServices.add(new Deposit(Currency.RUB, new Person("Ruslan", "Trest"), new Person("Ivan", "Petrov"), "25.10.2017", 36, 5.4, 11.3, TypeOfDeposit.WITH_REPLENISHMENT));
        listOfServices.add(new Credit(Currency.UAH, new Person("Alina", "Klochko"), new Person("Artem", "Sudakov"), "31.07.2018", 18, 7.5, 6.4, TypeOfCredit.MORTGAGE));
        listOfServices.add(new Remittance(Currency.USD, new Person("Nataliia", "Karpova"), new Person("Artem", "Sudakov"), "24.02.2016", 42, 11.7, new Person("Petro", "Karpov"), TypeOfRemittance.INTERNATIONAL));
        listOfServices.add(new Deposit(Currency.EUR, new Person("Viktoriia", "Shtank"), new Person("Vasyl", "Lyubomyrov"), "05.10.2017", 24, 15.0, 14.1, TypeOfDeposit.WITH_PARTIAL_REMOVAL));
        listOfServices.add(new Deposit(Currency.USD, new Person("Bogdan", "Tsvetkov"), new Person("Vasyl", "Lyubomyrov"), "11.04.2017", 20, 8.3, 10.8, TypeOfDeposit.WITHOUT_REMOVAL_AND_REPLENISHMENT));
        listOfServices.add(new Credit(Currency.RUB, new Person("Olena", "Gavrylyuk"), new Person("Melisa", "Harchenko"), "19.05.2016", 44, 11.3, 16.1, TypeOfCredit.CAR));
        listOfServices.add(new Remittance(Currency.UAH, new Person("Ilona", "Varan"), new Person("Melisa", "Harchenko"), "20.02.2019", 6, 4.5, new Person("Yulia", "Malahova"), TypeOfRemittance.UKRAINIAN));

        manager.setBankingServices(listOfServices);

        System.out.println(manager.getAvailableCredits());
        System.out.println(manager.getAvailableDeposits());
        System.out.println(manager.getAvailableCreditsSortedByServiceFee());
        System.out.println(manager.getAvailableDepositsSortedByServiceTerm());

        manager.sortByServiceFee(listOfServices, true);
        System.out.println(listOfServices);
        manager.sortByServiceFee(listOfServices, false);
        System.out.println(listOfServices);
    }
}
