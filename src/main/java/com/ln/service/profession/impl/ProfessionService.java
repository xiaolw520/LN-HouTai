package com.ln.service.profession.impl;

import java.util.List;
import javax.annotation.Resource;

import com.ln.entity.Profession;
import org.springframework.stereotype.Service;
import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;
import com.ln.service.profession.ProfessionManager;

/** 
 * 说明： 专业
 * 创建人：xiaolw Q76114567
 * 创建时间：2018-12-15
 * @version
 */
@Service("professionService")
public class ProfessionService implements ProfessionManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception{
		dao.save("ProfessionMapper.save", pd);
	}
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception{
		dao.delete("ProfessionMapper.delete", pd);
	}

	/**软删除
	* @param pd
	* @throws Exception
	*/
	public void softDelete(PageData pd) throws Exception {
		dao.update("ProfessionMapper.softDelete", pd);
	}

	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception{
		dao.update("ProfessionMapper.edit", pd);
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("ProfessionMapper.datalistPage", page);
	}

	/**列表
	 * @param page
	 * @throws Exception
	 */
	public List<Profession> listProfession(Page page)throws Exception{
		return (List<Profession>)dao.findForList("ProfessionMapper.datalistPage", page);
	}

	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("ProfessionMapper.listAll", pd);
	}
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("ProfessionMapper.findById", pd);
	}
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("ProfessionMapper.deleteAll", ArrayDATA_IDS);
	}

	/**批量软删除
	* @param ArrayDATA_IDS
	* @throws Exception
	*/
	public void softDeleteAll(String[] ArrayDATA_IDS) throws Exception {
		dao.update("ProfessionMapper.softDeleteAll", ArrayDATA_IDS);
	}

}

