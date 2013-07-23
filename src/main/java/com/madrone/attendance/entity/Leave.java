package com.madrone.attendance.entity;

import java.io.Serializable;

public class Leave implements Serializable {

	private static final long serialVersionUID = 610166417069777773L;
	
	private long id;
	private String name;
	private String description;
	private int days;
	
	public Leave() {
	}
	
	public Leave(String name, String description, int days) {
        this.name = name;
        this.description = description;
        this.days = days;
    }
	
	public long getId() {
		return id;
	}
	@SuppressWarnings("unused")
	private void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	
	@Override
	public boolean equals(Object ob) {
		if(ob instanceof Leave) {
			Leave l = (Leave) ob;
			
			if(id == l.id && (name != null && name.equals(l.name))) {
				return true;
			}		
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 31 * (name != null ? name.hashCode() : 1);
	}
	
	@Override
	public String toString() {	
				
		StringBuilder pattern = new StringBuilder("Leave {")
		.append("id=%d, ")
		.append("name=%s, ")
		.append("description=%s, ")
		.append("days=%d")
		.append("}");
		
		return String.format(pattern.toString(), id, name, description, days);
	}
}
