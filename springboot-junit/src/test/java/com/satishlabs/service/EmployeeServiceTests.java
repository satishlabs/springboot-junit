package com.satishlabs.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

//https://www.javaguides.net/2022/03/spring-boot-unit-testing-service-layer.html?spref=fb&fbclid=IwAR3QI0_MftXm_3F2qnqgjhbhsKemp_aufRlkUrzGwEnmX7b5W9ZozAvj50U
import java.util.Optional;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import com.satishlabs.enity.Employee;
import com.satishlabs.exception.ResourceNotFoundException;
import com.satishlabs.repository.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTests {

	@Mock
	private EmployeeRepository employeeRepository;
	
	@InjectMocks
	private EmployeeServiceImpl employeeService;
	
	private Employee employee;
	
	@BeforeEach
	public void setup() {
		//employeeRepository = Mockito.mock(EmployeeRepository.class);
        //employeeService = new EmployeeServiceImpl(employeeRepository);
		employee = Employee.builder()
				.id(1L)
				.firstName("Satish")
				.lastName("Prasad")
				.email("satish@gmail")
				.build();
	}
	
	 // JUnit test for saveEmployee method
    @DisplayName("JUnit test for saveEmployee method")
    @Test
    public void givenEmployeeObject_whenSaveEmployee_thenReturnEmployeeObject(){
        // given - precondition or setup
        given(employeeRepository.findByEmail(employee.getEmail()))
                .willReturn(Optional.empty());

        given(employeeRepository.save(employee)).willReturn(employee);

        System.out.println(employeeRepository);
        System.out.println(employeeService);

        // when -  action or the behaviour that we are going test
        Employee savedEmployee = employeeService.saveEmployee(employee);

        System.out.println(savedEmployee);
        // then - verify the output
        assertThat(savedEmployee).isNotNull();
    }
    
    // JUnit test for saveEmployee method
    @DisplayName("JUnit test for saveEmployee method which throws exception")
    @Test
    public void givenExistingEmail_WhenSaveEmployee_thenThrowsException() {
    	given(employeeRepository.findByEmail("satish@gmail")).willReturn(Optional.of(employee));
    	
    	// when -  action or the behaviour that we are going test
    	assertThrows(ResourceNotFoundException.class, ()->{
    		employeeService.saveEmployee(employee);
    	});
    	
    	
    	//then
    	verify(employeeRepository,never()).save(any(Employee.class));
    }
    
	
	
}
