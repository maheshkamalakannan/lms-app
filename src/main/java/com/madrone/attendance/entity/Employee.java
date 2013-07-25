package com.madrone.attendance.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "employee_", uniqueConstraints = {
		@UniqueConstraint(columnNames = "primary_email")})
public class Employee implements Serializable {

	private static final long serialVersionUID = -8774050095045228244L;
	
	private String id;
	private String firstName;
	private String lastName;
	private String primaryEmail;
	private String secondaryEmail;
	private Calendar dateOfJoin;
	private DesignationEnum designation;
	@Embedded private Address address;
	private Department dept;
	private Role role;
		
	public Employee() {
	}
	
	public Employee(String id, String firstName, String lastName, 
			String primaryEmail, String secondaryEmail, 
			Calendar dateOfJoin, DesignationEnum designation,
			String addressLine1, String addressLine2, String city,
			String state, int zipcode) {
		this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.primaryEmail = primaryEmail;
        this.secondaryEmail = secondaryEmail;
        this.dateOfJoin = dateOfJoin;
        this.designation = designation;
        this.address = new Address(addressLine1, addressLine2, city, state, 
        		zipcode);
    }

	@Id
	@Column(name = "id", nullable = false)
	public String getId() {
		return id;
	}

	public void setId(String id) {
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
	
	@Column(name = "date_of_join", nullable = false)
	public Calendar getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(Calendar dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

	@Column(name = "designation", nullable = false)
	@Enumerated(EnumType.STRING)
	public DesignationEnum getDesignation() {
		return designation;
	}

	public void setDesignation(DesignationEnum designation) {
		this.designation = designation;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	@ManyToOne
    @JoinColumn(name="dept_id")
	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}
	
	@ManyToOne
    @JoinColumn(name="role_id")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	@Override
	public boolean equals(Object ob) {
		if(ob instanceof Employee) {
			Employee e = (Employee) ob;
			
			if((id != null && id.equals(e.id)) && (primaryEmail != null && 
					primaryEmail.equals(e.primaryEmail))) {
				return true;
			}		
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 31 * ((id != null ? id.hashCode() : 1) + (primaryEmail != null ? 
				primaryEmail.hashCode() : 1));
	}
	
	@Override
	public String toString() {	
				
		StringBuilder pattern = new StringBuilder("Employee {")
		.append("id=%s, ")
		.append("firstName=%s, ")
		.append("lastName=%s, ")
		.append("primaryEmail=%s, ")
		.append("secondaryEmail=%s, ")
		.append("dateOfJoin=%s, ")
		.append("designation=%s, ")
		.append("address=%s")
		.append("}");
		
		return String.format(pattern.toString(), 
				id,
				firstName, 
				lastName,
				primaryEmail,
				secondaryEmail,
				dateOfJoin,
				designation,
				address
				);
	}	
}

@Embeddable
class Address implements Serializable {
	
	private static final long serialVersionUID = -5833762231605484421L;
	
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private int zipcode;
	
	public Address() {		
	}
	
	public Address(String addressLine1, String addressLine2, String city,
			String state, int zipcode) {
		this.addressLine1 = addressLine1;  
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	
	@Column(name = "address_line1", nullable = false)
	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	@Column(name = "address_line2")
	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	@Column(name = "city", nullable = false)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state", nullable = false)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "zipcode", nullable = false)
	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	
	@Override
	public String toString() {	
				
		StringBuilder pattern = new StringBuilder("Address {")
		.append("addressLine1=%s, ")
		.append("addressLine2=%s, ")
		.append("city=%s, ")
		.append("state=%s, ")
		.append("zipcode=%d")
		.append("}");
		
		return String.format(pattern.toString(), 
				addressLine1,
				addressLine2,
				city,
				state,
				zipcode
				);
	}		
}
