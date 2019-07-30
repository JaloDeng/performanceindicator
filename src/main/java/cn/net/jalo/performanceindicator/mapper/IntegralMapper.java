package cn.net.jalo.performanceindicator.mapper;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import cn.net.jalo.performanceindicator.entity.Integral;

public interface IntegralMapper extends BaseMapper<Integral> {

	public Page<Integral> select(@Param("label") String label, @Param("value") Integer value,
			@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("orderBy") String orderBy);
}
