package com.madrone.lms.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(
		name="SEQ_STORE",
		sequenceName="employeeleave__id_seq"
)
@Table(name="employeeleave_")
public class EmployeeLeave implements Serializable {

	private static final long serialVersionUID = 1422177851998196650L;
	
	private long id;
	private Employee employee;
	private Leave leave;
	private Calendar fromDate;
	private Calendar toDate;
	
	public EmployeeLeave() {
	}
	
	public EmployeeLeave(Employee employee, Leave leave, Calendar fromDate,
			Calendar toDate) {
		this.employee = employee;
		this.leave = leave;
		this.fromDate = fromDate;
		this.toDate = toDate;				
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_STORE")
	@Column(name = "id")
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	@ManyToOne
	@JoinColumn(name="leave_id")
	public Leave getLeave() {
		return leave;
	}
	
	public void setLeave(Leave leave) {
		this.leave = leave;
	}
	
	@Column(name = "from_date", nullable = false)
	public Calendar getFromDate() {
		return fromDate;
	}

	public void setFromDate(Calendar fromDate) {
		this.fromDate = fromDate;
	}

	@Column(name = "to_date", nullable = false)
	public Calendar getToDate() {
		return toDate;
	}

	public void setToDate(Calendar toDate) {
		this.toDate = toDate;
	}

	@Override
	public boolean equals(Object ob) {
		if(ob instanceof EmployeeLeave) {
			EmployeeLeave l = (EmployeeLeave) ob;
			// TODO
			if(id == l.id) {
				return true;
			}		
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 31; // TODO
	}
	
	@Override
	public String toString() {	
				
		StringBuilder pattern = new StringBuilder("EmployeeLeave {")
		.append("id=%d, ")
		.append("}");
		
		return String.format(pattern.toString(), id);
	}	
}
