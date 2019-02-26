package be.intecbrussel.eindwerkmolowayibackend.datLayer;

import be.intecbrussel.eindwerkmolowayibackend.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    public List<Person> findPersonByFirstName(String street);
    public List<Person> findPersonByLastName(String street);
    public List<Person> findPersonByFirstNameAndAndLastName(String firstName, String lastName);
    public Optional<Person> findById(Long id);
    public Person getPersonById(Long id);
}
