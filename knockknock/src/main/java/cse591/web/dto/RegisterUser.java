package cse591.web.dto;



import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name="users")
public class RegisterUser {
	
	
	@Id
	@Column(name = "username")
	@NotBlank (message="Username cannot be empty!")
	private String username;
	
	@NotBlank (message="Password cannot be empty!")
    @Column(name = "password")
	private String password;
	
	
	

	public RegisterUser(String username,String password)
	{
		super();
		this.username=username;
		this.password=password;
	}
	
	public RegisterUser()
	{
		super();
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
	
	

}
