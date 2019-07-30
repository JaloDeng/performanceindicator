package cn.net.jalo.performanceindicator.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;

import cn.net.jalo.performanceindicator.entity.Integral;
import cn.net.jalo.performanceindicator.mapper.IntegralMapper;
import cn.net.jalo.performanceindicator.result.Result;

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
	
	public Result<Page<Integral>> select(String label, Integer value, Integer pageNum, Integer pageSize, String orderBy) {
		Page<Integral> integrals = integralMapper.select(label, value, pageNum, pageSize, orderBy);
		return new Result<>(integrals, integrals.getPageNum(), integrals.getPageSize(), integrals.getTotal(), integrals.getPages());
	}
	
	public Result<Integral> selectById(Serializable id) {
		return new Result<>(integralMapper.selectById(id));
	}
}
