package org.bc.common.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author warner von
 * @create 2018-04-27
 */
public class CommonParam {
	/**
	 * 页码
	 */
	@ApiModelProperty(value = "页码", notes = "默认为1", required = true)
	private Integer page = 1;
	/**
	 * 每页数据大小
	 */
	@ApiModelProperty(value = "条数", notes = "默认每页显示50条", required = true)
	private Integer pageSize = 50;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getStartNum() {
		Integer startNum = 0;
		if (page != null && page > 1 && pageSize != null && pageSize > 0) {
			startNum = (page - 1) * pageSize;
		}
		return startNum;
	}

}
