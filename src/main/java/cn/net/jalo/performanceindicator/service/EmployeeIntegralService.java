package cn.net.jalo.performanceindicator.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;

import cn.net.jalo.performanceindicator.entity.EmployeeIntegral;
import cn.net.jalo.performanceindicator.mapper.EmployeeIntegralMapper;

@Service
@Transactional
public class EmployeeIntegralService {

	@Autowired
	private EmployeeIntegralMapper employeeIntegralMapper;
	
	public Integer delete(Serializable id) {
		return employeeIntegralMapper.delete(id);
	}
	
	public Integer save(EmployeeIntegral employeeIntegral) {
		employeeIntegral.setUpdateUser("SYSTEM");
		if (employeeIntegral.getId() != null) {
			return employeeIntegralMapper.update(employeeIntegral);
		} else {
			employeeIntegral.setCreateUser("SYSTEM");
			return employeeIntegralMapper.insert(employeeIntegral);
		}
	}
	
	public Page<EmployeeIntegral> select(Integer employeeId, String integralStartTime, String integralEndTime, 
			String name, String phone, String email, String label, Integer pageNum, Integer pageSize, String orderBy) {
		return employeeIntegralMapper.select(employeeId, integralStartTime, integralEndTime, name, phone, email, label, pageNum, pageSize, orderBy);
	}
	
	public EmployeeIntegral selectById(Serializable id) {
		return employeeIntegralMapper.selectById(id);
	}
}
