package be.intecbrussel.eindwerkmolowayibackend.datLayer;

import be.intecbrussel.eindwerkmolowayibackend.model.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdressRepository extends JpaRepository<Adress, Long> {
    public List<Adress> findAdressesByStreet(String street);
}
