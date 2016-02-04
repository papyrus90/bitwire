package ro.sci.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "people")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
	private long id;

	
	@Column(name = "email", nullable = false, unique = true)
	private String email;


	@Column(name = "firstName", nullable = false)
	private String firstName;

	
	@Column(name = "lastName", nullable = false)
	private String lastName;
	
	
	@Column(name = "password_hash", nullable = false)
	private String password;
	
	@Column(name = "date")
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User() {

	}

	public User(long id) {
		super();
		this.id = id;
	}

	public User(String email, String passwordHash) {
		super();
		this.email = email;
		this.password = passwordHash;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passwordHash) {
		this.password = passwordHash;
	}

	public long getId() {
		return id;
	}


}
