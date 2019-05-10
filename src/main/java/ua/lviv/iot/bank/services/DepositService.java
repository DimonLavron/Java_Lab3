package ua.lviv.iot.bank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.bank.models.Deposit;
import ua.lviv.iot.bank.repositories.DepositRepository;

import java.util.LinkedList;
import java.util.List;

@RestController
public class DepositService {

    @Autowired
    private DepositRepository repository;

    @RequestMapping(value = "/deposit/", method = RequestMethod.GET)
    public List<Deposit> getAllDeposits() {
        List<Deposit> deposits = new LinkedList<>();
        repository.findAll().forEach(deposits::add);
        if(deposits.isEmpty()) {
            return null;
        }
        return deposits;
    }

    @RequestMapping(value = "/deposit/{id}", method = RequestMethod.GET)
    public Deposit getDeposit(@PathVariable Integer id) {
        if (repository.findById(id).isPresent()) {
            return repository.findById(id).get();
        }
        return null;
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
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        }
    }
}
