package be.intecbrussel.eindwerkmolowayibackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@DiscriminatorValue("STAFF")
@JsonDeserialize(as = Staff.class)
public class Staff extends Person {

  @Enumerated(EnumType.STRING)
  private Role role;
  @JsonBackReference
  @ManyToOne(cascade = CascadeType.PERSIST)
  private Department department;

  public Staff() {
  }

  public Staff(Role role, Department department) {
    this.role = role;
    this.department = department;
  }

  public Staff(String firstName, String lastName, String origin, Timestamp birthDate, StatusOfThePerson status, Contact contact, List<Message> sent_messages, List<Message> received_messages, Role role, Department department) {
    super(firstName, lastName, origin, birthDate, status, contact, sent_messages, received_messages);
    this.role = role;
    this.department = department;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  @Override
  public String toString() {
    return "Staff{" +
      "role=" + role +
      ", department=" + department +
      '}';
  }
}
