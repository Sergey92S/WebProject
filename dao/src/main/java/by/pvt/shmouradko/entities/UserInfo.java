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
public class UserInfo implements Serializable {
	private static final long serialVersionUID = 6L;

	private int count;
	private int status;
	private int securitycode;
	private String name;

	public UserInfo(){}

	public UserInfo(int count, int status, int securitycode, String name){
		this.count=count;
		this.status=status;
		this.securitycode=securitycode;
		this.name=name;
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
//	public String getName() {
//		return name;
//	}
//
//	public UserInfo setCount(int count) {
//		this.count = count;
//		return this;
//	}
//
//	public UserInfo setStatus(int status) {
//		this.status = status;
//		return this;
//	}
//
//	public UserInfo setSecuritycode(int securitycode) {
//		this.securitycode = securitycode;
//		return this;
//	}
//
//	public UserInfo setName(String name) {
//		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		UserInfo userInfo = (UserInfo) o;

		if (count != userInfo.count) return false;
		if (status != userInfo.status) return false;
		if (securitycode != userInfo.securitycode) return false;
		return name != null ? name.equals(userInfo.name) : userInfo.name == null;

	}

	@Override
	public int hashCode() {
		int result = count;
		result = 31 * result + status;
		result = 31 * result + securitycode;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "UserInfo{" +
				"count=" + count +
				", status=" + status +
				", securitycode=" + securitycode +
				", name='" + name + '\'' +
				'}';
	}
}
