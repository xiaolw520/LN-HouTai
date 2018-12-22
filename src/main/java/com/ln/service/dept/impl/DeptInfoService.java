package com.ln.service.dept.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;
import com.ln.service.dept.DeptInfoManager;

/** 
 * 说明： 院系简介
 * 创建人：xiaolw Q76114567
 * 创建时间：2018-12-16
 * @version
 */
@Service("deptinfoService")
public class DeptInfoService implements DeptInfoManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception{
		dao.save("DeptInfoMapper.save", pd);
	}
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception{
		dao.delete("DeptInfoMapper.delete", pd);
	}

	/**软删除
	* @param pd
	* @throws Exception
	*/
	public void softDelete(PageData pd) throws Exception {
		dao.update("DeptInfoMapper.softDelete", pd);
	}

	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception{
		dao.update("DeptInfoMapper.edit", pd);
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("DeptInfoMapper.datalistPage", page);
	}
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("DeptInfoMapper.listAll", pd);
	}
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("DeptInfoMapper.findById", pd);
	}
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("DeptInfoMapper.deleteAll", ArrayDATA_IDS);
	}

	/**批量软删除
	* @param ArrayDATA_IDS
	* @throws Exception
	*/
	public void softDeleteAll(String[] ArrayDATA_IDS) throws Exception {
		dao.update("DeptInfoMapper.softDeleteAll", ArrayDATA_IDS);
	}

}

