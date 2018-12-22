package com.ln.entity;

import com.fh.entity.Page;

import java.io.Serializable;
import java.util.Date;

public class Deptinfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String deptinfoid;
    private String refid;//所属院系
    private Byte reftype;//外键类型：0无，1roleid
    private String info;//文字描述
    private String imgUrl;//图片路劲
    private Integer sort;//预警库存
    private Date crtime;//创建时间
    private Date uptime;//更新时间
    private Boolean isdel;//是否软删除
    private Byte state;//状态
    private Dept dept;//院系
    private Page page;//分页对象

    public String getDeptinfoid() {
        return deptinfoid;
    }

    public void setDeptinfoid(String deptinfoid) {
        this.deptinfoid = deptinfoid;
    }

    public String getRefid() {
        return refid;
    }

    public void setRefid(String refid) {
        this.refid = refid;
    }

    public Byte getReftype() {
        return reftype;
    }

    public void setReftype(Byte reftype) {
        this.reftype = reftype;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getCrtime() {
        return crtime;
    }

    public void setCrtime(Date crtime) {
        this.crtime = crtime;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    public Boolean getIsdel() {
        return isdel;
    }

    public void setIsdel(Boolean isdel) {
        this.isdel = isdel;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
