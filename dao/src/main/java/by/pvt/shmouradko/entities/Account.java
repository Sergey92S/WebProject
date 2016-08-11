/**
 * 
 */
package by.pvt.shmouradko.entities;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.persistence.CascadeType;
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
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "Account")
@Component
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "gen")
	@Column(name = "Account_Id")
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "creditCard"))
	private int id;

	@Column(name = "count")
	private int count;

	@Column(name = "status")
	private int status;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "CreditCard_Id")
	private CreditCard creditCard;

	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
	private Set<Transaction> transactions = new HashSet<>();

	public Account() {}

	public Account (int id, int count, int status){
		this.id=id;
		this.count=count;
		this.status=status;
	}

//	public Account(int count, int status){
//		this.count=count;
//		//this.creditCardId=creditCardId;
//		this.status=status;
//	}

//	public int getCreditCardId() {
//		return creditCardId;
//	}

//	public void setCreditCardId(int creditCardId) {
//		this.creditCardId = creditCardId;
//	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Account account = (Account) o;

		if (count != account.count) return false;
		if (status != account.status) return false;
		if (id != account.id) return false;
		if (creditCard != null ? !creditCard.equals(account.creditCard) : account.creditCard != null) return false;
		return transactions != null ? transactions.equals(account.transactions) : account.transactions == null;

	}

	@Override
	public int hashCode() {
		int result = count;
		result = 31 * result + status;
		result = 31 * result + id;
		result = 31 * result + (creditCard != null ? creditCard.hashCode() : 0);
		result = 31 * result + (transactions != null ? transactions.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Account{" +
				"count=" + count +
				", status=" + status +
				", id=" + id +
				'}';
	}
}
