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

/**
 * @author Shmouradko Sergey
 *
 */

@Entity
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "Transaction")
@Component
public class Transaction implements Serializable {
	private static final long serialVersionUID = 4L;

	@Id
	@GeneratedValue
	@Column(name = "Transaction_Id")
	private int id;

	@Column(name = "sum")
	private int sum;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Account_Id")
	private Account account;

	public Transaction() {}

//	public int getAccountId() {
//		return accountId;
//	}

//	public void setAccountId(int accountId) {
//		this.accountId = accountId;
//	}


	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

		Transaction that = (Transaction) o;

		if (id != that.id) return false;
		if (sum != that.sum) return false;
		return account != null ? account.equals(that.account) : that.account == null;

	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + sum;
		result = 31 * result + (account != null ? account.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Transaction{" +
				"sum=" + sum +
				", id=" + id +
				'}';
	}
}
