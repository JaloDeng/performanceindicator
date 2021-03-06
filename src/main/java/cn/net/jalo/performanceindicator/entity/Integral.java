package cn.net.jalo.performanceindicator.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Integral {
	private Integer id;
	private String label;
	private Integer value;
	private Integer reduceValue;
	private String remark;
	private String columnName;
	private String createUser;
	private Date createTime;
	private String updateUser;
	private Date updateTime;
}
