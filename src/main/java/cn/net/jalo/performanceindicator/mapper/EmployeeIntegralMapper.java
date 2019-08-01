package cn.net.jalo.performanceindicator.mapper;

import java.io.Serializable;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import cn.net.jalo.performanceindicator.entity.EmployeeIntegral;
import cn.net.jalo.performanceindicator.model.EmployeeIntegralModel;

public interface EmployeeIntegralMapper extends BaseMapper<EmployeeIntegral> {

	public Page<EmployeeIntegralModel> selectModel(@Param("employeeIds") Integer[] employeeIds, @Param("integralIds") Integer[] integralIds,
			@Param("integralStartTime") String integralStartTime, @Param("integralEndTime") String integralEndTime,
			@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("orderBy") String orderBy);
	
	public EmployeeIntegralModel selectModelById(Serializable id);
}
