package be.intecbrussel.eindwerkmolowayibackend.daos;

import be.intecbrussel.eindwerkmolowayibackend.datLayer.AdressRepository;
import be.intecbrussel.eindwerkmolowayibackend.model.Adress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdressDAO {

    @Autowired
    AdressRepository adressRepository;

    public synchronized Adress save(Adress adress) {
        return adressRepository.save(adress);
    }

    public synchronized List<Adress> findAll() {
        return adressRepository.findAll();
    }

    public  synchronized Adress findOne(Long id) {
        return adressRepository.getOne(id);
    }

    public  synchronized void delete(Adress adress) {
        adressRepository.delete(adress);
    }

    public  synchronized List<Adress> findByStreet(String street){
        return adressRepository.findAdressesByStreet(street);
    }
}
