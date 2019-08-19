package cn.net.jalo.performanceindicator.mapper;

import com.github.pagehelper.Page;

import cn.net.jalo.performanceindicator.entity.Integral;
import cn.net.jalo.performanceindicator.model.IntegralModel;

public interface IntegralMapper extends BaseMapper<Integral> {

	public Page<Integral> select(IntegralModel integralModel);
}
