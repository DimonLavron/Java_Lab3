package ua.lviv.iot.bank.database;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.lviv.iot.bank.models.Credit;
import ua.lviv.iot.bank.models.Currency;
import ua.lviv.iot.bank.models.Person;
import ua.lviv.iot.bank.models.TypeOfCredit;

@SpringBootApplication
public class DatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CreditRepository repository) {
		return (args) -> {
			repository.save(new Credit(Currency.EUR,
					new Person("Dima", "Lavrishyn"), new Person("Ivan", "Petrov"),
					"12.01.2019", 12, 12.5, 9.8, TypeOfCredit.CONSUMER));
			repository.save(new Credit(Currency.UAH,
					new Person("Alina", "Klochko"), new Person("Artem", "Sudakov"),
					"31.07.2018", 18, 7.5, 6.4, TypeOfCredit.MORTGAGE));
			repository.save(new Credit(Currency.RUB,
					new Person("Olena", "Gavrylyuk"),
					new Person("Melisa", "Harchenko"), "19.05.2016", 44, 11.3,
					16.1, TypeOfCredit.CAR));

			repository.findAll().forEach(credit -> System.out.println(credit));
		};
	}
}
