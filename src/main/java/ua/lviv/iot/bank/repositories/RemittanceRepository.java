package ua.lviv.iot.bank.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.lviv.iot.bank.models.Remittance;

public interface RemittanceRepository extends CrudRepository<Remittance, Integer> {
}
