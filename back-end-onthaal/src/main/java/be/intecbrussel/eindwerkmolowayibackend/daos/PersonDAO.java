package be.intecbrussel.eindwerkmolowayibackend.daos;

import be.intecbrussel.eindwerkmolowayibackend.datLayer.PersonRepository;
import be.intecbrussel.eindwerkmolowayibackend.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonDAO {

    @Autowired
    PersonRepository personRepository;


    public synchronized Person save(Person person) {
        return personRepository.save(person);
    }

    public synchronized List<Person> findAll() {
        return personRepository.findAll();
    }

    public synchronized Person findById(Long id) {
        return personRepository.findById(id).get();
    }

    public synchronized Person getPersonById(Long id) {
        return personRepository.getPersonById(id);
    }

    public synchronized void delete(Person person) {
        personRepository.delete(person);
    }

    public synchronized List<Person> findPersonByFirstName(String firstName) {
        return personRepository.findPersonByFirstName(firstName);
    }

    public synchronized List<Person> findPersonByLastName(String lastName) {
        return personRepository.findPersonByLastName(lastName);
    }

    public synchronized List<Person> findPeopleByNames(String firstName, String lastName) {
        return personRepository.findPersonByFirstNameAndAndLastName(firstName, lastName);
    }
}
