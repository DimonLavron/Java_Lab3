package ua.lviv.iot.bank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.bank.models.Deposit;
import ua.lviv.iot.bank.repositories.DepositRepository;

@RestController
public class DepositService {

    @Autowired
    private DepositRepository repository;

    @RequestMapping(value = "/deposit/{id}", method = RequestMethod.GET)
    public Deposit getDeposit(@PathVariable Integer id) {
        return repository.findById(id).get();
    }

    @RequestMapping(value = "/deposit", method = RequestMethod.POST)
    public Deposit addDeposit(@RequestBody Deposit deposit) {
        return repository.save(deposit);
    }

    @RequestMapping(value = "/deposit", method = RequestMethod.PUT)
    public Deposit putDeposit(@RequestBody Deposit deposit) {
        return repository.save(deposit);
    }

    @RequestMapping(value = "/deposit/{id}", method = RequestMethod.DELETE)
    public void deleteDeposit(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
