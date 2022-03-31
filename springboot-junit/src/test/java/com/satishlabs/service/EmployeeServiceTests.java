package com.satishlabs.service;
//https://www.javaguides.net/2022/03/spring-boot-unit-testing-service-layer.html?spref=fb&fbclid=IwAR3QI0_MftXm_3F2qnqgjhbhsKemp_aufRlkUrzGwEnmX7b5W9ZozAvj50U
import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.satishlabs.enity.Employee;
import com.satishlabs.repository.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTests {

	@Mock
	private EmployeeRepository employeeRepository;
	
	@InjectMocks
	private EmployeeServiceImpl employeeServiceImpl;
	
	private Employee employee;
	
	@BeforeEach
	public void setup() {
		//employeeRepository = Mockito.mock(EmployeeRepository.class);
        //employeeService = new EmployeeServiceImpl(employeeRepository);
		employee = Employee.builder()
				.id(1L)
				.firstName("Satish")
				.lastName("Prasad")
				.email("satish@g.com")
				.build();
	}
	
	  // JUnit test for saveEmployee method
	@DisplayName("JUnit test for saveEmployee method")
	@Test
	public void givenEmployeeObject_whenSaveEmployee_thenReturnEmployeeObject() {
		// given - precondition or setup
		given(employeeRepository.findByEmail(employee.getEmail())).willReturn(Optional.empty());
	}

	private Object given(Optional<Employee> findByEmail) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
