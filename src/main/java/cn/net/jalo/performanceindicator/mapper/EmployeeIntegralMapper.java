package cn.net.jalo.performanceindicator.mapper;

import java.io.Serializable;

import com.github.pagehelper.Page;

import cn.net.jalo.performanceindicator.entity.EmployeeIntegral;
import cn.net.jalo.performanceindicator.model.EmployeeIntegralModel;
import cn.net.jalo.performanceindicator.model.excel.EmployeeIntegralExcelModel;

public interface EmployeeIntegralMapper extends BaseMapper<EmployeeIntegral> {

	public Page<EmployeeIntegralExcelModel> selectExportToExcel(EmployeeIntegralModel employeeIntegralModel);
	
	public Page<EmployeeIntegralModel> selectModel(EmployeeIntegralModel employeeIntegralModel);
	
	public EmployeeIntegralModel selectModelById(Serializable id);
}
