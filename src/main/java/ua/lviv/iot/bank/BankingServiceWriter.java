package ua.lviv.iot.bank;

import ua.lviv.iot.bank.models.BankingService;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class BankingServiceWriter {

    public final void writeToFile(final List<BankingService> services) {

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("data.csv"), StandardCharsets.UTF_8))) {
            for (BankingService service : services) {
                writer.write(service.getHeaders() + "\n");
                writer.write(service.toCSV() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
