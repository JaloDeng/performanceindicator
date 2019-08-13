package cn.net.jalo.performanceindicator.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;

import cn.net.jalo.performanceindicator.entity.Employee;
import cn.net.jalo.performanceindicator.enums.ActiveStatus;
import cn.net.jalo.performanceindicator.result.Result;
import cn.net.jalo.performanceindicator.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@DeleteMapping("/{id}")
	public Result<Integer> delete(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response) {
		try {
			return new Result<Integer>(employeeService.delete(id), "删除成功", true);
		} catch (Exception e) {
			log.error(e.toString());
			return new Result<Integer>(0, "删除失败：" + e.getMessage(), false);
		}
	}
	
	@PutMapping
	public Result<Integer> save(@RequestBody Employee employee, HttpServletRequest request, HttpServletResponse response) {
		try {
			return new Result<Integer>(employeeService.save(employee), "保存成功", true);
		} catch (Exception e) {
			log.error(e.toString());
			return new Result<Integer>(0, "保存失败：" + e.getMessage(), false);
		}
	}
	
	@GetMapping
	public Result<Page<Employee>> select(@RequestParam(required = false) ActiveStatus status,
			@RequestParam(required = false) String name, 
			@RequestParam(required = false) String phone,
			@RequestParam(required = false) String email, 
			@RequestParam(required = false) String address,
			@RequestParam(required = false) Integer pageNum,
			@RequestParam(required = false) Integer pageSize,
			@RequestParam(required = false) String orderBy, 
			HttpServletRequest request, HttpServletResponse response) {
		Page<Employee> employees = employeeService.select(status, name, phone, email, address, pageNum, pageSize,
				orderBy);
		return new Result<>(employees, employees.getPageNum(), employees.getPageSize(), employees.getTotal(),
				employees.getPages());
	}
	
	@GetMapping("/{id}")
	public Result<Employee> selectById(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response) {
		return new Result<>(employeeService.selectById(id));
	}
}
