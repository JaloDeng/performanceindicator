package cn.net.jalo.performanceindicator.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Employee {
	private Integer id;
	private String name;
	private String phone;
	private String email;
	private String address;
	private String remark;
	private String createUser;
	private Date createTime;
	private String updateUser;
	private Date updateTime;
}
