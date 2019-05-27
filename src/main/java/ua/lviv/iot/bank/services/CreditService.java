package ua.lviv.iot.bank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.bank.models.Credit;
import ua.lviv.iot.bank.repositories.CreditRepository;

import java.util.LinkedList;
import java.util.List;

@RestController
public class CreditService {

    @Autowired
    private CreditRepository repository;

    @RequestMapping(value = "/credit/", method = RequestMethod.GET)
    public List<Credit> getAllCredits() {
        List<Credit> credits = new LinkedList<>();
        repository.findAll().forEach(credits::add);
        if(credits.isEmpty()) {
            return null;
        }
        return credits;
    }

    @RequestMapping(value = "/credit/{id}", method = RequestMethod.GET)
    public Credit getCredit(@PathVariable Integer id) {
        if (repository.findById(id).isPresent()) {
            return repository.findById(id).get();
        }
        return null;
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
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        }
    }
}
