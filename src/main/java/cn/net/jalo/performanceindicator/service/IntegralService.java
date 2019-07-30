package cn.net.jalo.performanceindicator.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;

import cn.net.jalo.performanceindicator.entity.Integral;
import cn.net.jalo.performanceindicator.mapper.IntegralMapper;

@Service
@Transactional
public class IntegralService {

	@Autowired
	private IntegralMapper integralMapper;
	
	public Integer delete(Serializable id) {
		return integralMapper.delete(id);
	}
	
	public Integer save(Integral integral) {
		integral.setUpdateUser("SYSTEM");
		if (integral.getId() != null) {
			return integralMapper.update(integral);
		} else {
			integral.setCreateUser("SYSTEM");
			return integralMapper.insert(integral);
		}
	}
	
	public Page<Integral> select(String label, Integer value, Integer pageNum, Integer pageSize, String orderBy) {
		return integralMapper.select(label, value, pageNum, pageSize, orderBy);
	}
	
	public Integral selectById(Serializable id) {
		return integralMapper.selectById(id);
	}
}
