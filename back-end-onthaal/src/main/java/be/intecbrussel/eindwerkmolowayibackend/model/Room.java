package be.intecbrussel.eindwerkmolowayibackend.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Component
public class Room implements IRoom, Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String number;
  @Enumerated(EnumType.STRING)
  private Funktion function;

  @JsonManagedReference
  @OneToMany(mappedBy = "room", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
  private List<Student> tenants;

  public Room() {
  }

  public Room(String number, Funktion function, List<Student> tenants) {
    this.number = number;
    this.function = function;
    this.tenants = tenants;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Funktion getFunction() {
    return function;
  }

  public void setFunction(Funktion function) {
    this.function = function;
  }

  public List<Student> getTenants() {
    return tenants;
  }

  public void setTenants(List<Student> tenants) {
    this.tenants = tenants;
  }

  @Override
  public String toString() {
    return "Room{" +
      "id=" + id +
      ", number='" + number + '\'' +
      ", function=" + function +
      '}';
  }
}
