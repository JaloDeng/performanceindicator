package cn.net.jalo.performanceindicator.model.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EmployeeIntegralExcelModel extends BaseRowModel {
	@ExcelProperty(value = "获取积分时间", index = 0)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private String integralTime;
	
	@ExcelProperty(value = "参与者", index = 1)
	private String name;
	
	@ExcelProperty(value = "项目", index = 2)
	private String label;
	
	@ExcelProperty(value = "积分", index = 3)
	private Integer integralValue;
	
	@ExcelProperty(value = "备注", index = 4)
	private String remark;
}
