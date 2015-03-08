package cse591.web.dto;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name="messages")
public class Messages {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",unique=true)
	private long id;
	

	@Column(name = "message")
	@NotBlank (message="Message cannot be empty!")
	private String message;
	
	@NotBlank (message="Title cannot be empty!")
    @Column(name = "title")
	private String title;
	
	@NotNull(message="secret cannot be empty!")
    @Column(name = "secret")
	private int secret;
	
	
	

	public int getSecret() {
		return secret;
	}

	public void setSecret(int secret) {
		this.secret = secret;
	}

	public Messages(String message,String title)
	{
		super();
		this.message=message;
		this.title=title;
	}
	
	public Messages()
	{
		super();
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
