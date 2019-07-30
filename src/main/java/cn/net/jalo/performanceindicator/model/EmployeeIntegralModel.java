package cn.net.jalo.performanceindicator.model;

import java.util.Date;

import lombok.Data;

@Data
public class EmployeeIntegralModel {
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
}
