package cn.net.jalo.performanceindicator.mapper;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import cn.net.jalo.performanceindicator.entity.Employee;
import cn.net.jalo.performanceindicator.enums.ActiveStatus;

public interface EmployeeMapper extends BaseMapper<Employee> {

	public Page<Employee> select(@Param("status") ActiveStatus status, @Param("name") String name, @Param("phone") String phone, 
			@Param("email") String email, @Param("address") String address, 
			@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("orderBy") String orderBy);
}
