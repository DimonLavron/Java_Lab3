package ua.lviv.iot.bank;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.bank.models.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BankingServiceWriterTest {

    List<BankingService> services = new LinkedList<>();
    BankingServiceWriter writer = new BankingServiceWriter();

    @BeforeEach
    void setUp() {
        services.add(new Credit(Currency.EUR,
                new Person("Dima", "Lavrishyn"), new Person("Ivan", "Petrov"),
                "12.01.2019", 12, 12.5, 9.8, TypeOfCredit.CONSUMER));
        services.add(new Deposit(Currency.USD,
                new Person("Bogdan", "Tsvetkov"),
                new Person("Vasyl", "Lyubomyrov"), "11.04.2017", 20, 8.3,
                10.8, TypeOfDeposit.WITHOUT_REMOVAL_AND_REPLENISHMENT));
        services.add(new Remittance(Currency.UAH,
                new Person("Ilona", "Varan"),
                new Person("Melisa", "Harchenko"), "20.02.2019", 6, 4.5,
                new Person("Yulia", "Malahova"), TypeOfRemittance.UKRAINIAN));
    }

    @AfterEach
    void tearDown() {
        services.clear();
    }

    @Test
    void writeToFile() {
        writer.writeToFile(services);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("data.csv"), StandardCharsets.UTF_8))) {
            assertEquals(reader.readLine(), BankingService.getHeaders());
            for (BankingService service : services) {
                assertEquals(reader.readLine(), service.toCSV());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}