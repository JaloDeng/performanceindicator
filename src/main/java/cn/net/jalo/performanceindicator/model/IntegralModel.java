package cn.net.jalo.performanceindicator.model;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class IntegralModel extends BaseModel {
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
	
	private List<Integer> integralIds;
}
