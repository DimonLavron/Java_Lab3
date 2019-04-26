package ua.lviv.iot.bank.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.lviv.iot.bank.models.Deposit;

public interface DepositRepository extends CrudRepository<Deposit, Integer> {
}
