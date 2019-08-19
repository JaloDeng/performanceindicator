package cn.net.jalo.performanceindicator.entity;

import java.util.Date;

import lombok.Data;

@Data
public class EmployeeIntegral {
	private Integer id;
	private Integer employeeId;
	private Integer integralId;
	private Date integralTime;
	private Integer integralValue;
	private Integer integralReduceValue;
	private String remark;
	private String createUser;
	private Date createTime;
	private String updateUser;
	private Date updateTime;
}
