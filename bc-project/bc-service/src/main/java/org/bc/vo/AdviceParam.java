package org.bc.vo;

/**
 * @author gjf
 * @create 2018/6/21.
 */
public class AdviceParam {
    private String name;
    private Integer deptTypeId;
    private Integer pageNo = 1;
    private Integer pageSize = 20;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDeptTypeId() {
        return deptTypeId;
    }

    public void setDeptTypeId(Integer deptTypeId) {
        this.deptTypeId = deptTypeId;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
