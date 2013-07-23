package com.madrone.attendance.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;

import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@SequenceGenerator(
	    name="SEQ_STORE",
	    sequenceName="employee__id_seq"
	)
@Table(name = "employee_", uniqueConstraints = {
		@UniqueConstraint(columnNames = "id"),
		@UniqueConstraint(columnNames = "primary_email")})
public class Employee implements Serializable {

	private static final long serialVersionUID = -8774050095045228244L;
	
	private long id;
	private String firstName;
	private String lastName;
	private String primaryEmail;
	private String secondaryEmail;
	
	public Employee() {
	}
	
	public Employee(String firstName, String lastName, 
			String primaryEmail, String secondaryEmail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.primaryEmail = primaryEmail;
        this.secondaryEmail = secondaryEmail;
    }

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator="SEQ_STORE")
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "primary_email", unique= true, nullable = false)
	public String getPrimaryEmail() {
		return primaryEmail;
	}

	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	@Column(name = "secondary_email")
	public String getSecondaryEmail() {
		return secondaryEmail;
	}

	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}
	
	@Override
	public boolean equals(Object ob) {
		if(ob instanceof User) {
			Employee e = (Employee) ob;
			
			if((id == e.id) && (primaryEmail != null && 
					primaryEmail.equals(e.primaryEmail))) {
				return true;
			}		
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 31 * (primaryEmail != null ? 
				primaryEmail.hashCode() : 1);
	}
	
	@Override
	public String toString() {	
				
		StringBuilder pattern = new StringBuilder("Employee {")
		.append("id=%d, ")
		.append("firstName=%s, ")
		.append("lastName=%s, ")
		.append("primaryEmail=%s, ")
		.append("secondaryEmail=%s, ")
		.append("}");
		
		return String.format(pattern.toString(), 
				id,
				firstName, 
				lastName,
				primaryEmail,
				secondaryEmail
				);
	}
}
