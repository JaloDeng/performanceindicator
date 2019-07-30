package cn.net.jalo.performanceindicator.result;

public class Result<T> {

	private T data;
	
	private String message;
	
	private Integer pageNum;
	
	private Integer pageSize;
	
	private Boolean success;
	
	private Long total;
	
	private Integer pages;
	
	public Result() {}

	/**
	 * 结果集
	 * @param data 数据
	 */
	public Result(T data) {
		this.data = data;
		this.success = true;
	}
	
	/**
	 * 结果集
	 * @param data 数据
	 * @param pageNum 当前页
	 * @param pageSize 当前页的数据量
	 * @param total 总数据量
	 * @param pages 总页数
	 */
	public Result(T data, Integer pageNum, Integer pageSize, Long total, Integer pages) {
		this.data = data;
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.success = true;
		this.total = total;
		this.pages = pages;
	}
	
	/**
	 * 结果集
	 * @param data 数据
	 * @param message 信息
	 * @param success true:成功, false:失败
	 */
	public Result(T data, String message, Boolean success) {
		this.data = data;
		this.message = message;
		this.success = success;
	}
	
	/**
	 * 结果集
	 * @param message 信息
	 * @param success true:成功, false:失败
	 */
	public Result(String message, Boolean success) {
		this.message = message;
		this.success = success;
	}
	
	/**
	 * 结果集
	 * @param data 数据
	 * @param message 信息
	 * @param pageNum 当前页
	 * @param pageSize 当前页的数据量
	 * @param success true:成功, false:失败
	 * @param total 总数据量
	 * @param pages 总页数
	 */
	public Result(T data, String message, Integer pageNum, Integer pageSize, Boolean success, Long total, Integer pages) {
		this.data = data;
		this.message = message;
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.success = success;
		this.total = total;
		this.pages = pages;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}
	
}
