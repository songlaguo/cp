package org.bc.common.vo;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Administrator on 2017/10/10.
 */
public class Page implements Serializable {
    private static final long serialVersionUID = 145646464664632L;
    @ApiModelProperty(value="当前页数")
    private int pageNo = 1;     // 当前页数
    @ApiModelProperty(value="每页显示记录条数")
    private int pageSize = 10;  // 每页显示记录的条数
    @ApiModelProperty(value="总的记录数")
    private int totalRecords;   // 总的记录条数
    @ApiModelProperty(value="总的页数")
    private int totalPages;     // 总的页数
    private List result;

    public List getResult() {
        return result;
    }

    public void setResult(List result) {
        this.result = result;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }




    public Page(int totalRecords, int pageNo) {
        this.totalRecords = totalRecords;
        this.pageNo = pageNo;
    }
    public Page(){}
    public int getTotalPages() {
        totalPages = getTotalRecords() / getPageSize();
        return (totalRecords % pageSize == 0) ? totalPages
                : totalPages + 1;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getStartPoint() {
        return (pageNo - 1) * pageSize;
    }


}
