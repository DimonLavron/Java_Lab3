package ua.lviv.iot.bank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.bank.models.Remittance;
import ua.lviv.iot.bank.repositories.RemittanceRepository;

@RestController
public class RemittanceService {

    @Autowired
    private RemittanceRepository repository;

    @RequestMapping(value = "/remittance/{id}", method = RequestMethod.GET)
    public Remittance getRemittance(@PathVariable Integer id) {
        return repository.findById(id).get();
    }

    @RequestMapping(value = "/remittance", method = RequestMethod.POST)
    public Remittance addRemittance(@RequestBody Remittance remittance) {
        return repository.save(remittance);
    }

    @RequestMapping(value = "/remittance", method = RequestMethod.PUT)
    public Remittance putRemittance(@RequestBody Remittance remittance) {
        return repository.save(remittance);
    }

    @RequestMapping(value = "/remittance/{id}", method = RequestMethod.DELETE)
    public void deleteRemittance(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}