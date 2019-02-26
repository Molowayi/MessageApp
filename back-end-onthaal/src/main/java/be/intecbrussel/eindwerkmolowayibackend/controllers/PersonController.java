package be.intecbrussel.eindwerkmolowayibackend.controllers;

import be.intecbrussel.eindwerkmolowayibackend.daos.PersonDAO;
import be.intecbrussel.eindwerkmolowayibackend.daos.StudentDAO;
import be.intecbrussel.eindwerkmolowayibackend.model.Person;
import be.intecbrussel.eindwerkmolowayibackend.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/ngo")
public class PersonController {

  @Autowired
  PersonDAO personDAO;

  @PostMapping(value = "/person", produces = "application/json", consumes = "application/json")
  public Person createPerson(@RequestBody Person person) {
    return personDAO.save(person);
  }

  @GetMapping(value = "/person", produces = "application/json")
  public List<Person> getAllPersons() {
    return personDAO.findAll();
  }

  @GetMapping(value = "/person/{id}", produces = "application/json")
  public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") Long id) {

    HttpStatus status = HttpStatus.OK;
    Person person = personDAO.getPersonById(id);

    if (person == null) {
      status = HttpStatus.NOT_FOUND;
    }
    return new ResponseEntity<>(person, status);
  }

  @PutMapping(value = "/person/{id}", produces = "application/json")
  public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") Long personid, @RequestBody Person personDetails) {

    Person person = personDAO.findById(personid);
    if (person == null) {
      return ResponseEntity.notFound().build();
    }

    person.setFirstName(personDetails.getFirstName());  // make a method to do this work
    person.setLastName(personDetails.getLastName());
    person.setBirthDate(personDetails.getBirthDate());
    person.setSent_messages(personDetails.getSent_messages());
    person.setReceived_messages(personDetails.getReceived_messages());
    person.setContact(personDetails.getContact());
    person.setSent_messages(personDetails.getSent_messages());
    person.setStatus(personDetails.getStatus());

    Person updatePerson = personDAO.save(person);
    return ResponseEntity.ok().body(updatePerson);
  }

  @DeleteMapping(value = "/person/{id}", produces = "application/json")
  public ResponseEntity<Person> deletePerson(@PathVariable(value = "id") Long personid) {

    Person person = personDAO.findById(personid);
    if (person == null) {
      return ResponseEntity.notFound().build();
    }
    personDAO.delete(person);

    return ResponseEntity.ok().build();
  }

  @GetMapping(value = "/person/firstname/{fn}", produces = "application/json")
  public List<Person> findByFirstName(@PathVariable(value = "fn") String firstname) {
    return personDAO.findPersonByFirstName(firstname);
  }

  @GetMapping(value = "/person/lastname/{ln}", produces = "application/json")
  public List<Person> findByLastName(@PathVariable(value = "ln") String lastname) {
    return personDAO.findPersonByLastName(lastname);
  }

  @GetMapping(value = "/person/lastname/{fn}/{ln}", produces = "application/json")
  public List<Person> findByNames(@PathVariable(value = "fn") String firstname, @PathVariable(value = "ln") String lastname) {
    return personDAO.findPeopleByNames(firstname, lastname);
  }
}
