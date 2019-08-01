package cn.net.jalo.performanceindicator.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum ActiveStatus {

	ENABLED("正常"), DISABLED("禁用");
	
	private String label;

	private ActiveStatus(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public static List<Map<String, Object>> getList() {
		List<Map<String, Object>> list = new ArrayList<>();
		for (ActiveStatus activeStatus : values()) {
			Map<String, Object> item = new HashMap<>();
			item.put("value", activeStatus);
			item.put("label", activeStatus.getLabel());
			list.add(item);
		}
		return list;
	}
}
