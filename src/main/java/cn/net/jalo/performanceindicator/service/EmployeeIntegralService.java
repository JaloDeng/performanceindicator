package cn.net.jalo.performanceindicator.service;

import java.io.Serializable;

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
		if (employeeIntegral.getId() != null) {
			return employeeIntegralMapper.update(employeeIntegral);
		} else {
			employeeIntegral.setCreateUser("SYSTEM");
			return employeeIntegralMapper.insert(employeeIntegral);
		}
	}
	
	public Page<EmployeeIntegralModel> selectModel(Integer employeeId, String integralStartTime, String integralEndTime,
			String name, String phone, String email, String label, Integer pageNum, Integer pageSize, String orderBy) {
		return employeeIntegralMapper.selectModel(employeeId, integralStartTime, integralEndTime, name, phone, email,
				label, pageNum, pageSize, orderBy);
	}
	
	public EmployeeIntegralModel selectModelById(Serializable id) {
		return employeeIntegralMapper.selectModelById(id);
	}
}
