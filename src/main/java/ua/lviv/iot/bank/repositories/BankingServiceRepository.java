package ua.lviv.iot.bank;

import org.springframework.data.repository.CrudRepository;
import ua.lviv.iot.bank.models.BankingService;

public interface BankingServiceRepository {//<T extends BankingService> extends CrudRepository<T, Integer> {
}
