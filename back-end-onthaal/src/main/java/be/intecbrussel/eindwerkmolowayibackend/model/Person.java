package be.intecbrussel.eindwerkmolowayibackend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "status", discriminatorType = DiscriminatorType.STRING)
@Component
@JsonDeserialize(using = PersonDeserializer.class)
public abstract class Person implements IPerson, Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String firstName;

  private String lastName;
  private String origin;
  private Timestamp birthDate;
  @Transient
  private StatusOfThePerson status;
  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private Contact contact;
  @JsonManagedReference(value = "message-sender")
  @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
  private List<Message> sent_messages;
  @JsonManagedReference
  @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
  private List<Message> received_messages;

  public Person() {
  }

  public Person(String firstName, String lastName, String origin, Timestamp birthDate, StatusOfThePerson status, Contact contact, List<Message> sent_messages, List<Message> received_messages) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.origin = origin;
    this.birthDate = birthDate;
    this.status = status;
    this.contact = contact;
    this.sent_messages = sent_messages;
    this.received_messages = received_messages;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  public Timestamp getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Timestamp birthDate) {
    this.birthDate = birthDate;
  }

  public StatusOfThePerson getStatus() {
    return status;
  }

  public void setStatus(StatusOfThePerson status) {
    this.status = status;
  }

  public Contact getContact() {
    return contact;
  }

  public void setContact(Contact contact) {
    this.contact = contact;
  }

  public List<Message> getSent_messages() {
    return sent_messages;
  }

  public void setSent_messages(List<Message> sent_messages) {
    this.sent_messages = sent_messages;
  }

  public List<Message> getReceived_messages() {
    return received_messages;
  }

  public void setReceived_messages(List<Message> received_messages) {
    this.received_messages = received_messages;
  }

  @Override
  public String toString() {
    return "Person{" +
      "firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      ", origin='" + origin + '\'' +
      ", birthDate=" + birthDate +
      ", status=" + status +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Person person = (Person) o;

    if (!getFirstName().equals(person.getFirstName())) return false;
    if (!getLastName().equals(person.getLastName())) return false;
    if (!getOrigin().equals(person.getOrigin())) return false;
    if (!getBirthDate().equals(person.getBirthDate())) return false;
    return getStatus() == person.getStatus();
  }

  @Override
  public int hashCode() {
    int result = getFirstName().hashCode();
    result = 31 * result + getLastName().hashCode();
    result = 31 * result + getOrigin().hashCode();
    result = 31 * result + getBirthDate().hashCode();
    result = 31 * result + getStatus().hashCode();
    return result;
  }

  public static Timestamp timestampFromAge(int age){
    long time = System.currentTimeMillis() - age*365*24*60*60*1000;
    return new Timestamp(time);
  }
}
