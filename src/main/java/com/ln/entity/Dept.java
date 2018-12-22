package com.ln.entity;

import com.fh.entity.Page;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Dept implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String deptid;
	private String refid;//上级院系
	private Byte reftype;//外键类型：0无，1roleid
	private String name;//院系名称
	private String info;//简介
	private String color;//颜色
	private Integer sort;//预警库存
	private Date crtime;//创建时间
	private Date uptime;//更新时间
	private Boolean isdel;//是否软删除
	private Byte state;//状态
	private List<Profession> pros;//专业集合
	private List<Deptinfo> infos;//简介集合
	private Page page;//分页对象

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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

	public List<Profession> getPros() {
		return pros;
	}
	public void setPros(List<Profession> pros) {
		this.pros = pros;
	}

	public List<Deptinfo> getInfos() {
		return infos;
	}

	public void setInfos(List<Deptinfo> infos) {
		this.infos = infos;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
}
