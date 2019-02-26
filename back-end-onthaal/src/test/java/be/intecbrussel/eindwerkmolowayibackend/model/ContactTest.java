package be.intecbrussel.eindwerkmolowayibackend.model;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactTest extends TestCase {

  Adress adress;
  Contact contact;
  private String message;

  @Before
  public void setUp() throws Exception {
    adress = new Adress("Alsace Lorraine", "33", "1050", "Bruxelles", "Belgique");
    contact = new Contact("contact@contact.be", "+32477333444", null);
  }

  @After
  public void tearDown() throws Exception {
    System.out.println("End of the test for Contact : "+message);
  }

  @Test
  public void testGetAdress() throws Exception {
      Contact contact = new Contact(null, null, adress);
      assertEquals(adress, contact.getAdress());
    message = "getAdress()";

  }

  @Test
  public void testSetAdress() throws Exception {
    setUp();
    contact.setAdress(adress);
    assertEquals(adress, contact.getAdress());
    message = "setAdress()";
  }
}
