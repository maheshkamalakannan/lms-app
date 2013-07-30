package com.madrone.lms.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.madrone.lms.entity.Department;
import com.madrone.lms.entity.Employee;
import com.madrone.lms.service.util.ServiceTestUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", 
"classpath:spring/hibernateContext.xml"})
public class DepartmentServiceTest {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private DepartmentService departmentService;

	private final String ROLE_R1 = "r1";
	private final String DEPT_D1 = "d1";
	private final String EMP_100 = "100";
	private final String USER_NAME = "tom@jerry.com";

	@After
	public void tearDown() throws Exception {
		ServiceTestUtil.deleteEmployee(EMP_100);
		ServiceTestUtil.deleteDepartment(DEPT_D1);
	}

	@Test
	public void testDeleteEmployee() throws Exception {
		Department d = createDepartment();
		createEmployee();
		Employee e = employeeService.findById(EMP_100);
		assertNotNull(e);
		assertEquals(d, e.getDepartment());
		employeeService.deleteEmployee(EMP_100);
		assertNull(employeeService.findById(EMP_100));
		
		// Department should be deleted when Employee is deleted
		assertNotNull(departmentService.findById(e.getDepartment().getId()));	
	}	

	@Test
	public void testDeleteDepartment() throws Exception {
		Department d = createDepartment();
		createEmployee();
		Employee e = employeeService.findById(EMP_100);
		assertNotNull(e);
		assertEquals(d, e.getDepartment());
		
		try {
			departmentService.deleteDepartment(d.getId());
			fail("Should not reach here...");
		} catch(DataIntegrityViolationException ex) {			
		}
				
		employeeService.deleteEmployee(e.getId());
		departmentService.deleteDepartment(d.getId());
	}
	
	private Employee createEmployee() {
		return ServiceTestUtil.createEmployee(EMP_100, DEPT_D1, 
				ROLE_R1, USER_NAME);
	}
	
	private Department createDepartment() {
		return ServiceTestUtil.createDepartment(DEPT_D1, "dept_1");		
	}

}
