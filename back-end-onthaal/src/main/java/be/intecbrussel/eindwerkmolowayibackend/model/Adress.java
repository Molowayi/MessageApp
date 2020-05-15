package be.intecbrussel.eindwerkmolowayibackend.model;

import javax.persistence.Entity;
import java.io.Serializable;

// import com.sun.istack.internal.NotNull;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Component
public class Adress implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @NotNull
  private String street;
  @NotNull
  private String number;
  @NotNull
  private String zipCode;
  @NotNull
  private String city;
  @NotNull
  private String country;

  public Adress() {
  }

  public Adress(String street, String number, String zipCode, String city, String country) {
    this.street = street;
    this.number = number;
    this.zipCode = zipCode;
    this.city = city;
    this.country = country;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Adress adress = (Adress) o;
    return Objects.equals(street, adress.street) &&
      Objects.equals(number, adress.number) &&
      Objects.equals(zipCode, adress.zipCode) &&
      Objects.equals(city, adress.city) &&
      Objects.equals(country, adress.country);
  }

  @Override
  public int hashCode() {

    return Objects.hash(street, number, zipCode, city, country);
  }

  @Override
  public String toString() {
    return "\n\tAdress : " + number + ",  " + street + ", " + zipCode + " " + city + ", " + country;
  }
}

