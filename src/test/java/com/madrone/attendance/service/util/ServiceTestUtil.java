package com.madrone.attendance.service.util;

import java.util.Calendar;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.madrone.attendance.entity.Department;
import com.madrone.attendance.entity.DesignationEnum;
import com.madrone.attendance.entity.Employee;
import com.madrone.attendance.entity.User;
import com.madrone.attendance.service.DepartmentService;
import com.madrone.attendance.service.EmployeeService;
import com.madrone.attendance.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", 
		"classpath:spring/hibernateContext.xml"})
@Component
public class ServiceTestUtil {
	
	// Spring does not allow Autowiring static fields. Hence as suggested in 
	// few forums, defined setters for these static fields and autowired the
	// setter methods. Also made the class a component for this to work.
	
	private static UserService userService;
	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	
	@Autowired
	public void setUserService(UserService userService) {
		ServiceTestUtil.userService = userService;
	}
	
	@Autowired
	public void setEmployeeService(EmployeeService employeeService) {
		ServiceTestUtil.employeeService = employeeService;
	}
	
	@Autowired
	public void setDepartmentService(DepartmentService departmentService) {
		ServiceTestUtil.departmentService = departmentService;
	}
	
	private ServiceTestUtil() {
	}

	public static User createUser(String empId, String deptId, 
			String primaryEmail) {
		User u = userService.findByUserName(primaryEmail);
		if(u == null) {

			Employee e = createEmployee(empId, deptId, primaryEmail);

			u = new User(primaryEmail, "password");
			u.setEmployee(e);
			userService.saveUser(u);
		}
		return u;
	}

	public static Employee createEmployee(String empId, String deptId, 
			String primaryEmail) {

		Employee e = employeeService.findById(empId);
		if(e == null) {
			Department d = createDepartment(deptId, null);
			e = new Employee(empId, "tom", "jerry", primaryEmail, null, 
					Calendar.getInstance(), DesignationEnum.SSE, 
					"#25 Chitrakulam north st", "Mylapore", "Chennai", 
					"TN", 600004);
			e.setDept(d);
			employeeService.saveEmployee(e);
		}
		return e;
	}

	public static Department createDepartment(String deptId, String desc) {
		Department d = departmentService.findById(deptId);
		if(d == null) {
			d = new Department(deptId, desc != null ? desc : "test");
			departmentService.saveDepartment(d);
		}
		return d;
	}

}
