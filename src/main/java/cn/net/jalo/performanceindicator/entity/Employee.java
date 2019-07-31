package cn.net.jalo.performanceindicator.entity;

import java.util.Date;

import cn.net.jalo.performanceindicator.enums.ActiveStatus;
import lombok.Data;

@Data
public class Employee {
	private Integer id;
	private ActiveStatus status;
	private String name;
	private String phone;
	private String email;
	private String address;
	private Integer initialIntegralValue;
	private String remark;
	private String createUser;
	private Date createTime;
	private String updateUser;
	private Date updateTime;
}
