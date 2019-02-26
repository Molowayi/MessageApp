package be.intecbrussel.eindwerkmolowayibackend.model;

import java.sql.Timestamp;
import java.util.List;

public interface IPerson {

    public String getFirstName();

    public void setFirstName(String firstName);

    public String getLastName();

    public void setLastName(String lastName);

    public String getOrigin();

    public void setOrigin(String origin);

    public Timestamp getBirthDate();

    public void setBirthDate(Timestamp birthDate);

    public StatusOfThePerson getStatus();

    public void setStatus(StatusOfThePerson status);

    public Contact getContact();

    public void setContact(Contact contact);

    public List<Message> getSent_messages();

    public void setSent_messages(List<Message> sent_messages);

    public List<Message> getReceived_messages();

    public void setReceived_messages(List<Message> received_messages);
}
