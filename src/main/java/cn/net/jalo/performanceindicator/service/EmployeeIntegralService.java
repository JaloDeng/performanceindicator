package cn.net.jalo.performanceindicator.service;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;

import cn.net.jalo.performanceindicator.entity.EmployeeIntegral;
import cn.net.jalo.performanceindicator.mapper.EmployeeIntegralMapper;
import cn.net.jalo.performanceindicator.model.EmployeeIntegralModel;

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
		employeeIntegral.setUpdateTime(new Date());
		if (employeeIntegral.getId() != null) {
			return employeeIntegralMapper.update(employeeIntegral);
		} else {
			employeeIntegral.setCreateUser("SYSTEM");
			return employeeIntegralMapper.insert(employeeIntegral);
		}
	}
	
	public Page<EmployeeIntegralModel> selectModel(EmployeeIntegralModel employeeIntegralModel) {
		return employeeIntegralMapper.selectModel(employeeIntegralModel);
	}
	
	public EmployeeIntegralModel selectModelById(Serializable id) {
		return employeeIntegralMapper.selectModelById(id);
	}
}
