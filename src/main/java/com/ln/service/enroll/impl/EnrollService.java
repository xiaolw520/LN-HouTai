package com.ln.service.enroll.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;
import com.ln.service.enroll.EnrollManager;

/** 
 * 说明： 报名进度
 * 创建人：xiaolw Q76114567
 * 创建时间：2018-12-23
 * @version
 */
@Service("enrollService")
public class EnrollService implements EnrollManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception{
		dao.save("EnrollMapper.save", pd);
	}
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception{
		dao.delete("EnrollMapper.delete", pd);
	}

	/**软删除
	* @param pd
	* @throws Exception
	*/
	public void softDelete(PageData pd) throws Exception {
		dao.update("EnrollMapper.softDelete", pd);
	}

	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception{
		dao.update("EnrollMapper.edit", pd);
	}

	/**修改审核信息
	 * @param pd
	 * @throws Exception
	 */
	public void editAuditState(PageData pd)throws Exception{
		dao.update("EnrollMapper.editAuditState", pd);
	}


	/**列表
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("EnrollMapper.datalistPage", page);
	}
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("EnrollMapper.listAll", pd);
	}
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("EnrollMapper.findById", pd);
	}

	/**通过用户id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findByRefid(PageData pd)throws Exception{
		return (PageData)dao.findForObject("EnrollMapper.findByRefid", pd);
	}

	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("EnrollMapper.deleteAll", ArrayDATA_IDS);
	}

	/**批量软删除
	* @param ArrayDATA_IDS
	* @throws Exception
	*/
	public void softDeleteAll(String[] ArrayDATA_IDS) throws Exception {
		dao.update("EnrollMapper.softDeleteAll", ArrayDATA_IDS);
	}

}

