package au.com.studyunsw.model;

import java.util.Date;

/**
 * Model of user<br />
 * @author range-ubuntu
 *
 */
public class User {
	private long userId;
	
	private String username;
	
	private String password; // encoded
	
	private Date createAt; // the date the user registered
	
	private Date lastLoginAt; // last login date

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getLastLoginAt() {
		return lastLoginAt;
	}

	public void setLastLoginAt(Date lastLoginAt) {
		this.lastLoginAt = lastLoginAt;
	}
}
