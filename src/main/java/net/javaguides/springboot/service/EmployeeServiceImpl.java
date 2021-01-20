/**
 * 
 */
package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;

/**
 * @author Liyabona Saki
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		//Get Data
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		//Save Data
		this.employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(long id) {
		//Update Data
		Optional <Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		
		if(optional.isPresent()) {
			employee = optional.get();
		}else {
			throw new RuntimeException("Employee not found for ID :: " + id);
		}
		
		return employee;
	}

	@Override
	public void deleteEmployeeById(long id) {
	//Delete Data
		this.employeeRepository.deleteById(id);
	}
	

}
