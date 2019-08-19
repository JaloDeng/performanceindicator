package cn.net.jalo.performanceindicator.model;

import java.util.List;

import cn.net.jalo.performanceindicator.entity.EmployeeIntegral;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EmployeeIntegralModel extends EmployeeIntegral {
	private String name;
	private String label;
	private List<Integer> employeeIds;
	private String employeeStatus;
	private List<Integer> integralIds;
	private String integralStartTime;
	private String integralEndTime;
}
