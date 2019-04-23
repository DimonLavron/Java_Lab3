package ua.lviv.iot.bank;

import org.springframework.data.repository.CrudRepository;
import ua.lviv.iot.bank.models.Credit;

public interface CreditRepository extends CrudRepository<Credit, Integer> {
}
