package be.intecbrussel.eindwerkmolowayibackend.controllers;

import be.intecbrussel.eindwerkmolowayibackend.daos.AdressDAO;
import be.intecbrussel.eindwerkmolowayibackend.model.Adress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/ngo")
public class AdressController {

    @Autowired
    AdressDAO adressDAO;

    @PostMapping(value = "/adress", produces = "application/json")
    public Adress createAdress(@RequestBody Adress adress) {
        return adressDAO.save(adress);
    }

    @GetMapping("/adress")
    public List<Adress> getAllAdresss() {
        return adressDAO.findAll();
    }

    @GetMapping(value = "/adress/{id}", produces = "application/json")
    public ResponseEntity<Adress> getAdressById(@PathVariable(value = "id") Long adressid) {

        Adress adress = adressDAO.findOne(adressid);

        if (adress == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(adress, HttpStatus.OK);
    }

    @PutMapping(value = "/adress/{id}", produces = "application/json")
    public ResponseEntity<Adress> updateAdress(@PathVariable(value = "id") Long adressid, @RequestBody Adress adressDetails) {

        Adress adress = adressDAO.findOne(adressid);
        if (adress == null) {
            return ResponseEntity.notFound().build();
        }

        adress.setCity(adressDetails.getCity());
        adress.setCountry(adressDetails.getCountry());
        adress.setNumber(adressDetails.getNumber());
        adress.setStreet(adressDetails.getStreet());
        adress.setZipCode(adressDetails.getZipCode());

        Adress updateAdress = adressDAO.save(adress);
        return ResponseEntity.ok().body(updateAdress);
    }

    @DeleteMapping("/adress/{id}")
    public ResponseEntity<Adress> deleteAdress(@PathVariable(value = "id") Long adressid) {

        Adress adress = adressDAO.findOne(adressid);
        if (adress == null) {
            return ResponseEntity.notFound().build();
        }
        adressDAO.delete(adress);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/adress/street/{str}")
    public List<Adress> findByStreet(@PathVariable(value = "str") String street) {
        return adressDAO.findByStreet(street);
    }
}
