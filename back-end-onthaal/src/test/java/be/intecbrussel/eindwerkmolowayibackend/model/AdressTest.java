package be.intecbrussel.eindwerkmolowayibackend.model;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;

public class AdressTest extends TestCase {

  Adress adress;
  String message;

  @Before
  public void setUp() throws Exception {
    adress = new Adress("Alsace Lorraine", "33", "1050", "Bruxelles", "Belgique");
  }

  @After
  public void tearDown() throws Exception {
    System.out.println("End of test for Addres : " + message);
  }

  @Test
  @DisplayName("Test method getStreet()")
  public void testGetStreet() throws Exception {
    String rue = adress.getStreet();
    assertTrue("Le test de la rue n'a pas marché", rue.equalsIgnoreCase("Alsace Lorraine"));
    message = "getStreet()";
  }

  @Test
  @DisplayName("Test method setStreet()")
  public void testSetStreet() throws Exception {
    adress.setStreet("Tombalbaye");
    String rue = adress.getStreet();
    assertTrue("La rue n'a pas changé", rue.equalsIgnoreCase("Tombalbaye"));
    message = "setStreet()";

  }

}
