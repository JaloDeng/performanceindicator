package cn.net.jalo.performanceindicator.model;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EmployeeIntegralModel extends BaseModel {
	private Integer id;
	private Integer employeeId;
	private Integer integralId;
	private Date integralTime;
	private Integer integralValue;
	private String remark;
	private String createUser;
	private Date createTime;
	private String updateUser;
	private Date updateTime;
	private String name;
	private String label;
	
	private Integer[] employeeIds;
	private String employeeStatus;
	private Integer[] integralIds;
	private String integralStartTime;
	private String integralEndTime;
}
