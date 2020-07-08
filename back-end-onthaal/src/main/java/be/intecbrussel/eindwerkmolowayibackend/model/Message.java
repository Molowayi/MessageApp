package be.intecbrussel.eindwerkmolowayibackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Component
public class Message implements IMessage, Serializable {

	private static final long serialVersionUID = 6660588230890187404L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Timestamp postTime = new Timestamp(System.currentTimeMillis());
	private String title;
	@Column(columnDefinition = "TEXT")
	private String content;
	@JsonBackReference(value = "message-sender")
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Person sender;
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Person receiver;

	public Message() {
	}

	public long getId() {
		return id;
	}

	public Message(Timestamp postTime, String title, String content, Person sender, Person receiver) {
		this.postTime = postTime;
		this.title = title;
		this.content = content;
		this.sender = sender;
		this.receiver = receiver;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getPostTime() {
		return postTime;
	}

	public void setPostTime(Timestamp postTime) {
		this.postTime = postTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Person getSender() {
		return sender;
	}

	public void setSender(Person sender) {
		this.sender = sender;
	}

	public Person getReceiver() {
		return receiver;
	}

	public void setReceiver(Person receiver) {
		this.receiver = receiver;
	}

	@Override
	public String toString() {
		return "Message : \n" + "Posted  on \n" + postTime + "\n" + "Title : \n" + title + "\n" + "Content :\n"
				+ content + "\n" + "Sender : " + sender.getFirstName() + " " + sender.getLastName() + "\n"
				+ "Receiver : " + receiver.getFirstName() + " " + receiver.getLastName();
	}
}
