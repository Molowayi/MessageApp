package be.intecbrussel.eindwerkmolowayibackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@DiscriminatorValue("STUDENT")
@JsonDeserialize(as = Student.class)
public class Student extends Person {

	private static final long serialVersionUID = 3124929899550185124L;
	private String school;
	private String study_field;
	@JsonBackReference
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	private Room room;

	public Student() {
	}

	public Student(String school, String study_field, Room room) {
		this.school = school;
		this.study_field = study_field;
		this.room = room;
	}

	public Student(String firstName, String lastName, String origin, Timestamp birthDate, StatusOfThePerson status,
			Contact contact, List<Message> sent_messages, List<Message> received_messages, String school,
			String study_field, Room room) {
		super(firstName, lastName, origin, birthDate, status, contact, sent_messages, received_messages);
		this.school = school;
		this.study_field = study_field;
		this.room = room;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getStudy_field() {
		return study_field;
	}

	public void setStudy_field(String study_field) {
		this.study_field = study_field;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "Student{" + "firstName='" + this.getFirstName() + '\'' + ", lastName='" + this.getLastName() + '\''
				+ ", origin='" + this.getOrigin() + '\'' + ", birthDate=" + this.getBirthDate() + ", status="
				+ this.getStatus() + ", school='" + school + '\'' + ", study_field='" + study_field + '\'' +

				'}';
	}
}
