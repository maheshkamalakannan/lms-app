package com.madrone.lms.utils;

import java.util.ArrayList;
import java.util.List;

import com.madrone.lms.entity.Department;
import com.madrone.lms.entity.DesignationEnum;

public class EnumUtils {
	
	public static List<Department> getDesigList() {
		DesignationEnum[] array1 = DesignationEnum.values();
		List<Department> desigList = new ArrayList<Department>();
		
		for(int i=0; i<array1.length; i++) {
			Department bean = new Department();
			bean.setId(array1[i].name());
			bean.setDescription(array1[i].description());
			desigList.add(bean);
		}
		
		return desigList;
	}
	
	
	public static DesignationEnum getDesignation(String desig){
		DesignationEnum desigEnum = null;
		
		switch(desig) {
			case "AD" : desigEnum = DesignationEnum.AD;
			case "PM" : desigEnum = DesignationEnum.PM;
			case "QA" : desigEnum = DesignationEnum.QA;
			case "SE" : desigEnum = DesignationEnum.SE;
			case "SSE" : desigEnum = DesignationEnum.SSE;
			case "STL" : desigEnum = DesignationEnum.STL;
			case "TL" : desigEnum = DesignationEnum.TL;
			default: desigEnum = DesignationEnum.SE;
		}
		
		return desigEnum;
	
	}

}
