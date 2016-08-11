/**
 * 
 */
package by.pvt.shmouradko.entities;

import org.hibernate.annotations.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Shmouradko Sergey
 *
 */

@Entity
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "Person")
@Component
public class Person implements Serializable {
	private static final long serialVersionUID = 3L;

	@Id
	@GeneratedValue
	@Column(name = "Person_Id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "login")
	private String login;

	@Column(name = "password")
	private String password;

	@Column(name = "role")
	private int role;

	@OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
	private Set<CreditCard> creditCards = new HashSet<>();

	public Person() {}

//	public Person(String name, String surname, String login, String password, int role) {
//		this.name=name;
//		this.surname=surname;
//		this.login=login;
//		this.password=password;
//		this.role=role;
//	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<CreditCard> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(Set<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Person person = (Person) o;

		if (role != person.role) return false;
		if (id != person.id) return false;
		if (name != null ? !name.equals(person.name) : person.name != null) return false;
		if (surname != null ? !surname.equals(person.surname) : person.surname != null) return false;
		if (login != null ? !login.equals(person.login) : person.login != null) return false;
		if (password != null ? !password.equals(person.password) : person.password != null) return false;
		return creditCards != null ? creditCards.equals(person.creditCards) : person.creditCards == null;

	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (surname != null ? surname.hashCode() : 0);
		result = 31 * result + (login != null ? login.hashCode() : 0);
		result = 31 * result + (password != null ? password.hashCode() : 0);
		result = 31 * result + role;
		result = 31 * result + id;
		result = 31 * result + (creditCards != null ? creditCards.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", login='" + login + '\'' +
				", password='" + password + '\'' +
				", role=" + role +
				", id=" + id +
				'}';
	}
}
