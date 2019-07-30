package cn.net.jalo.performanceindicator.mapper;

import java.io.Serializable;

public interface BaseMapper<T> {

	public Integer insert(T entity);
	
	public Integer delete(Serializable id);
	
	public T selectById(Serializable id);
	
	public Integer update(T entity);
	
}
