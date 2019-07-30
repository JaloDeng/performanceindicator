package cn.net.jalo.performanceindicator.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Integral {
	private Integer id;
	private String label;
	private Integer value;
	private String remark;
	private String createUser;
	private Date createTime;
	private String updateUser;
	private Date updateTime;
}
