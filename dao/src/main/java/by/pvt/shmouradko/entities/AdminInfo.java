/**
 * 
 */
package by.pvt.shmouradko.entities;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author Shmouradko Sergey
 *
 */
@Component
public class AdminInfo implements Serializable {
	private static final long serialVersionUID = 5L;

	private int count;
	private int status;
	private int securitycode;
	private String login;
	private String creditcard;

	public AdminInfo(){}

	public AdminInfo(int count, int status, int securitycode, String login, String creditcard){
		this.count=count;
		this.status=status;
		this.securitycode=securitycode;
		this.login=login;
		this.creditcard=creditcard;
	}

//	public int getCount() {
//		return count;
//	}
//
//	public int getStatus() {
//		return status;
//	}
//
//	public int getSecuritycode() {
//		return securitycode;
//	}
//
//	public String getLogin() {
//		return login;
//	}
//
//	public String getCreditcard() {
//		return creditcard;
//	}
//
//	public AdminInfo setCount(int count) {
//		this.count = count;
//		return this;
//	}
//
//	public AdminInfo setStatus(int status) {
//		this.status = status;
//		return this;
//	}
//
//	public AdminInfo setSecuritycode(int securitycode) {
//		this.securitycode = securitycode;
//		return this;
//	}
//
//	public AdminInfo setLogin(String login) {
//		this.login = login;
//		return this;
//	}
//
//	public AdminInfo setCreditcard(String creditcard) {
//		this.creditcard = creditcard;
//		return this;
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

	public int getSecuritycode() {
		return securitycode;
	}

	public void setSecuritycode(int securitycode) {
		this.securitycode = securitycode;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getCreditcard() {
		return creditcard;
	}

	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		AdminInfo adminInfo = (AdminInfo) o;

		if (count != adminInfo.count) return false;
		if (status != adminInfo.status) return false;
		if (securitycode != adminInfo.securitycode) return false;
		if (login != null ? !login.equals(adminInfo.login) : adminInfo.login != null) return false;
		return creditcard != null ? creditcard.equals(adminInfo.creditcard) : adminInfo.creditcard == null;

	}

	@Override
	public int hashCode() {
		int result = count;
		result = 31 * result + status;
		result = 31 * result + securitycode;
		result = 31 * result + (login != null ? login.hashCode() : 0);
		result = 31 * result + (creditcard != null ? creditcard.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "AdminInfo{" +
				"count=" + count +
				", status=" + status +
				", securitycode=" + securitycode +
				", login='" + login + '\'' +
				", creditcard='" + creditcard + '\'' +
				'}';
	}
}
