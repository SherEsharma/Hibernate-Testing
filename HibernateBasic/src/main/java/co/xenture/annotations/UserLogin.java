package co.xenture.annotations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_registration")
public class UserLogin {
	@Id
	@Column(name="userid")
	private Integer userId;
	
	@Column(name = "username")
	private String userName;
	@Column(name = "userpassword", length = 12)
	private String userPassword;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}
