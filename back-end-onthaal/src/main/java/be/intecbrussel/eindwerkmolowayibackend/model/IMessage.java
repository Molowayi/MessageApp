package be.intecbrussel.eindwerkmolowayibackend.model;

import java.sql.Timestamp;

public interface IMessage {

    public void setId(long id);

    public Timestamp getPostTime();

    public void setPostTime(Timestamp postTime);

    public String getTitle();

    public void setTitle(String title);

    public String getContent();

    public void setContent(String content);

    public Person getSender();

    public void setSender(Person sender);

    public Person getReceiver();

    public void setReceiver(Person receiver);
}
