package com.madrone.attendance.entity;

public enum DesignationEnum {
	
	SE("Software Engineer"),
	SSE("Senior Software Engineer"),
	TL("Team Leader"),
	STL("Senior Team Leader"),
	PM("Project Manager");
	
	private final String description;

	DesignationEnum(String description) {
		this.description = description;
	}
	
	public String description() {
		return description;
	}
}
