package be.intecbrussel.eindwerkmolowayibackend.model.dbSeeder;

import be.intecbrussel.eindwerkmolowayibackend.daos.MessageDAO;
import be.intecbrussel.eindwerkmolowayibackend.daos.PersonDAO;
import be.intecbrussel.eindwerkmolowayibackend.datLayer.AdressRepository;
import be.intecbrussel.eindwerkmolowayibackend.datLayer.ContactRepository;
import be.intecbrussel.eindwerkmolowayibackend.datLayer.StaffRepository;
import be.intecbrussel.eindwerkmolowayibackend.datLayer.StudentRepository;
import be.intecbrussel.eindwerkmolowayibackend.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

//@Component
public class DbSeeder implements CommandLineRunner {

  @Autowired
  AdressRepository adressRepository;
  @Autowired
  ContactRepository contactRepository;
  @Autowired
  StudentRepository studentRepository;
  @Autowired
  StaffRepository staffRepository;

  @Autowired
  PersonDAO personDAO;
  @Autowired
  MessageDAO messageDAO;

  @Override
  public void run(String... args) throws Exception {
//    this.adressRepository.deleteAll();
//    this.contactRepository.deleteAll();

    Adress adress1 = ((new Adress("Alsace Lorraine", "33", "1050", "Ixelles", "Belgique")));
    Adress adress2 = ((new Adress("Londres", "5", "1050", "Ixelles", "Belgique")));
    Adress adress3 = ((new Adress("Place Roupe", "15", "1000", "Bruxelles", "Belgique")));
    Adress adress4 = ((new Adress("Franklin Rooselvelt", "75", "1050", "Ixelles", "Belgique")));
    Adress adress5 = ((new Adress("Haute", "33", "1000", "Bruxelles", "Belgique")));

    Contact contact1 = ((new Contact("james@yahoo.fr", "+32475212663", adress1)));
    Contact contact2 = ((new Contact("georges@yahoo.fr", "+32475212664", adress2)));
    Contact contact3 = ((new Contact("gilles@yahoo.fr", "+32475212665", adress3)));
    Contact contact4 = ((new Contact("luc@yahoo.fr", "+32475212666", adress4)));
    Contact contact5 = ((new Contact("peter@yahoo.fr", "+32475212667", adress5)));

//    List<Adress> adresses = adressRepository.findAll();
//    List<Contact> contacts = contactRepository.findAll();
//    adresses.stream().forEach(System.out::println);
//    contacts.stream().forEach(System.out::println);

    Department departement1= new Department("CLEANING");
    Department departement2= new Department("ADMINISTRATION");
    Department departement3= new Department("ACOUNTING");

    Room room1 = new Room("1001", Funktion.SLEEPROOM, null);
    Room room2 = new Room("1101", Funktion.SLEEPROOM, null);
    Room room3 = new Room("1102", Funktion.SLEEPROOM, null);

    Person person1 = studentRepository.save(new Student("John", "Banderman", "Belgium", Person.timestampFromAge(18), StatusOfThePerson.STUDENT, contact1, null, null, "ULB", "Economics", room1));
    Person person2 = studentRepository.save(new Student("James", "Momo", "Belgium", Person.timestampFromAge(20), StatusOfThePerson.STUDENT, contact2, null, null, "ULB", "Economics", room2));
    Person person3 = studentRepository.save(new Student("Jack", "Abbot", "Belgium", Person.timestampFromAge(19), StatusOfThePerson.STUDENT, contact3, null, null, "ULB", "Economics", room3));
    Person person4 = staffRepository.save(new Staff("Jim", "Doe", "Belgium", Person.timestampFromAge(26), StatusOfThePerson.STAFF, contact4, null, null, Role.CLEANER, departement1));
    Person person5 = staffRepository.save(new Staff("Jane", "Doe", "Belgium", Person.timestampFromAge(29), StatusOfThePerson.STAFF, contact5, null, null, Role.MAINTENANCE, departement2));

    Person sender = personDAO.getPersonById(1L);
    Person receiver = personDAO.getPersonById(2L);

    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    Message message = new Message(timestamp,
      "Initial message from command line runner",
      "This message will be sent right after the program get ready",
      sender,
      receiver);
    messageDAO.save(message);
  }
}
