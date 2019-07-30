package cn.net.jalo.performanceindicator.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;

import cn.net.jalo.performanceindicator.entity.Employee;
import cn.net.jalo.performanceindicator.mapper.EmployeeMapper;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	public Integer delete(Serializable id) {
		return employeeMapper.delete(id);
	}
	
	public Integer save(Employee employee) {
		employee.setUpdateUser("SYSTEM");
		if (employee.getId() != null) {
			return employeeMapper.update(employee);
		} else {
			employee.setCreateUser("SYSTEM");
			return employeeMapper.insert(employee);
		}
	}
	
	public Page<Employee> select(String name, String phone, String email, String address, Integer pageNum, Integer pageSize, String orderBy) {
		return employeeMapper.select(name, phone, email, address, pageNum, pageSize, orderBy);
	}
	
	public Employee selectById(Serializable id) {
		return employeeMapper.selectById(id);
	}
}
