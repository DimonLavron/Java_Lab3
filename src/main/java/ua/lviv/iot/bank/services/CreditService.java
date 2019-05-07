package ua.lviv.iot.bank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.bank.models.Credit;
import ua.lviv.iot.bank.repositories.CreditRepository;

@RestController
public class CreditService {

    @Autowired
    private CreditRepository repository;

    @RequestMapping(value = "/credit/{id}", method = RequestMethod.GET)
    public Credit getCredit(@PathVariable Integer id) {
        return repository.findById(id).get();
    }

    @RequestMapping(value = "/credit", method = RequestMethod.POST)
    public Credit addCredit(@RequestBody Credit credit) {
        return repository.save(credit);
    }

    @RequestMapping(value = "/credit", method = RequestMethod.PUT)
    public Credit putCredit(@RequestBody Credit credit) {
        return repository.save(credit);
    }

    @RequestMapping(value = "/credit/{id}", method = RequestMethod.DELETE)
    public void deleteCredit(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
