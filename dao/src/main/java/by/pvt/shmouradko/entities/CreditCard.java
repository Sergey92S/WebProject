/**
 * 
 */
package by.pvt.shmouradko.entities;

import org.hibernate.annotations.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Shmouradko Sergey
 *
 */

@Entity
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "Credit_Card")
@Component
public class CreditCard implements Serializable {
	private static final long serialVersionUID = 2L;

	@Id
	@GeneratedValue
	@Column(name = "CreditCard_Id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "securityCode")
	private int securityCode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Person_Id")
	private Person person;

	@OneToOne(mappedBy = "creditCard", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Account account;

	public CreditCard() {}

//	public int getPersonId() {
//		return personId;
//	}

//	public void setPersonId(int personId) {
//		this.personId = personId;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		CreditCard that = (CreditCard) o;

		if (securityCode != that.securityCode) return false;
		if (id != that.id) return false;
		if (name != null ? !name.equals(that.name) : that.name != null) return false;
		if (person != null ? !person.equals(that.person) : that.person != null) return false;
		return account != null ? account.equals(that.account) : that.account == null;

	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + securityCode;
		result = 31 * result + id;
		result = 31 * result + (person != null ? person.hashCode() : 0);
		result = 31 * result + (account != null ? account.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "CreditCard{" +
				"name='" + name + '\'' +
				", securityCode=" + securityCode +
				", id=" + id +
				'}';
	}
}
