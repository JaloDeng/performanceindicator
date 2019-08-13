package cn.net.jalo.performanceindicator.model;

import lombok.Data;

@Data
public class BaseModel {
	private Integer pageNum;
	private Integer pageSize;
	private String orderBy;
}
