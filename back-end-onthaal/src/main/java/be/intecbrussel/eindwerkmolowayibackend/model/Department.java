package be.intecbrussel.eindwerkmolowayibackend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Component
public class Department implements IDepartment, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7465582499300658382L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	@JsonManagedReference
	@OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
	private List<Staff> staffList = new ArrayList<>();

	public Department() {
	}

	public Department(String name) {
		this.name = name;
	}

	public Department(String name, List<Staff> staffList) {
		this.name = name;
		this.staffList = staffList;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Staff> getStaffList() {
		return staffList;
	}

	public void setStaffList(List<Staff> staffList) {
		this.staffList = staffList;
	}

	@Override
	public String toString() {
		return "Department{" + "id=" + id + ", name='" + name + '\'' + '}';
	}
}
