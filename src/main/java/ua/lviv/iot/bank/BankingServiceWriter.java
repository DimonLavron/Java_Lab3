package ua.lviv.iot.bank;

import ua.lviv.iot.bank.models.BankingService;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class BankingServiceWriter {

    private BufferedWriter writer;

    public final void writeToFile(final List<BankingService> services) {

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("data.csv"), StandardCharsets.UTF_8));
            for (BankingService service : services) {
                writer.write(service.getHeaders() + "\n");
                writer.write(service.toCSV() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.flush();
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
