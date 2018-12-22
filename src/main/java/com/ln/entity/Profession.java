package com.ln.entity;

import com.fh.entity.Page;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *  专业
 * @author xiaolw
 *
 */
public class Profession implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String professionid;
	private String p_refid;//
	private Dept dept;
	private Byte p_reftype;//
	private String p_name;//专业名称
	private String course;//主干课程
	private String credential;//证书
	private String work;//就业方向
	private Integer p_sort;
	private Date p_crtime;//创建时间
	private Date p_uptime;//更新时间
	private Boolean p_isdel;//是否软删除
	private Byte p_state;//状态
	private Page page;//分页对象

	public String getProfessionid() {
		return professionid;
	}

	public void setProfessionid(String professionid) {
		this.professionid = professionid;
	}

	public String getP_refid() {
		return p_refid;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public void setP_refid(String p_refid) {
		this.p_refid = p_refid;
	}

	public Byte getP_reftype() {
		return p_reftype;
	}

	public void setP_reftype(Byte p_reftype) {
		this.p_reftype = p_reftype;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getCredential() {
		return credential;
	}

	public Integer getP_sort() {
		return p_sort;
	}

	public void setP_sort(Integer p_sort) {
		this.p_sort = p_sort;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public Date getP_crtime() {
		return p_crtime;
	}

	public void setP_crtime(Date p_crtime) {
		this.p_crtime = p_crtime;
	}

	public Date getP_uptime() {
		return p_uptime;
	}

	public void setP_uptime(Date p_uptime) {
		this.p_uptime = p_uptime;
	}

	public Boolean getP_isdel() {
		return p_isdel;
	}

	public void setP_isdel(Boolean p_isdel) {
		this.p_isdel = p_isdel;
	}

	public Byte getP_state() {
		return p_state;
	}

	public void setP_state(Byte p_state) {
		this.p_state = p_state;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}


}
