package ua.lviv.iot.bank;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.lviv.iot.bank.models.*;
import ua.lviv.iot.bank.repositories.CreditRepository;
import ua.lviv.iot.bank.repositories.DepositRepository;
import ua.lviv.iot.bank.repositories.RemittanceRepository;

@SpringBootApplication
public class BankApplication {

	public static void main(final String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

	@Bean
	public CommandLineRunner creditBean(final CreditRepository repository) {
		return (args) -> {
			repository.save(new Credit(Currency.EUR,
                    new Person("Dima", "Lavrishyn"),
                    new Person("Ivan", "Petrov"), "12.01.2019", 12, 12.5, 9.8,
                    TypeOfCredit.CONSUMER));
			repository.save(new Credit(Currency.UAH,
					new Person("Alina", "Klochko"),
                    new Person("Artem", "Sudakov"), "31.07.2018", 18, 7.5,
                    6.4, TypeOfCredit.MORTGAGE));
			repository.save(new Credit(Currency.RUB,
					new Person("Olena", "Gavrylyuk"),
					new Person("Melisa", "Harchenko"), "19.05.2016", 44, 11.3,
					16.1, TypeOfCredit.CAR));

			repository.findAll().forEach(credit -> System.out.println(credit));
		};
	}

	@Bean
	public CommandLineRunner depositBean(final DepositRepository repository) {
		return (args) -> {
			repository.save(new Deposit(Currency.RUB,
					new Person("Ruslan", "Trest"),
                    new Person("Ivan", "Petrov"), "25.10.2017", 36, 5.4, 11.3,
					TypeOfDeposit.WITH_REPLENISHMENT));
			repository.save(new Deposit(Currency.EUR,
					new Person("Viktoriia", "Shtank"),
					new Person("Vasyl", "Lyubomyrov"), "05.10.2017", 24, 15.0,
					14.1, TypeOfDeposit.WITH_PARTIAL_REMOVAL));
			repository.save(new Deposit(Currency.USD,
					new Person("Bogdan", "Tsvetkov"),
					new Person("Vasyl", "Lyubomyrov"), "11.04.2017", 20, 8.3,
					10.8, TypeOfDeposit.WITHOUT_REMOVAL_AND_REPLENISHMENT));

			repository.findAll().forEach(deposit ->
                    System.out.println(deposit));
		};
	}

	@Bean
	public CommandLineRunner remittanceBean (
	        final RemittanceRepository repository) {
		return (args) -> {
			repository.save(new Remittance(Currency.USD,
					new Person("Nataliia", "Karpova"),
					new Person("Artem", "Sudakov"), "24.02.2016", 42, 11.7,
					new Person("Petro", "Karpov"),
                    TypeOfRemittance.INTERNATIONAL));
			repository.save(new Remittance(Currency.UAH,
					new Person("Ilona", "Varan"),
					new Person("Melisa", "Harchenko"), "20.02.2019", 6, 4.5,
					new Person("Yulia", "Malahova"),
                    TypeOfRemittance.UKRAINIAN));

			repository.findAll().forEach(remittance ->
                    System.out.println(remittance));
		};
	}
}