package be.intecbrussel.eindwerkmolowayibackend;

import be.intecbrussel.eindwerkmolowayibackend.model.AdressTest;
import be.intecbrussel.eindwerkmolowayibackend.model.ContactTest;
import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

  public static Test suite() {
    TestSuite suite = new TestSuite("Test for org.totalbeginner.tutorial");
//$JUnit-BEGIN$
    suite.addTestSuite(AdressTest.class);
    suite.addTestSuite(ContactTest.class);
//$JUnit-END$
    return suite;
  }
}
