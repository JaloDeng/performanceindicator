package cn.net.jalo.performanceindicator.mapper;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import cn.net.jalo.performanceindicator.entity.EmployeeIntegral;
import cn.net.jalo.performanceindicator.model.EmployeeIntegralModel;

public interface EmployeeIntegralMapper extends BaseMapper<EmployeeIntegral>{

	public Page<EmployeeIntegralModel> select(@Param("employeeId") Integer employeeId, 
			@Param("integralStartTime") String integralStartTime, @Param("integralEndTime") String integralEndTime,
			@Param("name") String name, @Param("phone") String phone, @Param("email") String email, @Param("label") String label, 
			@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("orderBy") String orderBy);
}
