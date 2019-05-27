package ua.lviv.iot.bank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.bank.models.Remittance;
import ua.lviv.iot.bank.repositories.RemittanceRepository;

import java.util.LinkedList;
import java.util.List;

@RestController
public class RemittanceService {

    @Autowired
    private RemittanceRepository repository;

    @RequestMapping(value = "/deposit/", method = RequestMethod.GET)
    public List<Remittance> getAllDeposits() {
        List<Remittance> remittances = new LinkedList<>();
        repository.findAll().forEach(remittances::add);
        if(remittances.isEmpty()) {
            return null;
        }
        return remittances;
    }

    @RequestMapping(value = "/remittance/{id}", method = RequestMethod.GET)
    public Remittance getRemittance(@PathVariable Integer id) {
        if (repository.findById(id).isPresent()) {
            return repository.findById(id).get();
        }
        return null;
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
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        }
    }
}