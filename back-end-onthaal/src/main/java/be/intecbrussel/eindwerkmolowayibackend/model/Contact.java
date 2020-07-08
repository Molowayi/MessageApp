package be.intecbrussel.eindwerkmolowayibackend.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Component
public class Contact implements Serializable {

	private static final long serialVersionUID = -7603784928062548838L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String email;
	private String mobile;
	@ManyToOne(cascade = { CascadeType.ALL })
	private Adress adress;

	public Contact() {
	}

	public Contact(String email, String mobile, Adress adress) {
		this.email = email;
		this.mobile = mobile;
		this.adress = adress;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Contact that = (Contact) o;

		if (id != that.id)
			return false;
		if (email != null ? !email.equals(that.email) : that.email != null)
			return false;
		if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null)
			return false;
		return adress != null ? adress.equals(that.adress) : that.adress == null;
	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {

		return "\n\tContact :  \n\t\temail : " + email + "\n\t\tMobile phone : " + mobile + adress;
	}
}
