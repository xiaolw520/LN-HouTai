package com.ln.service.banner.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;
import com.ln.service.banner.BannerManager;

/** 
 * 说明： 图片
 * 创建人：xiaolw Q76114567
 * 创建时间：2018-12-15
 * @version
 */
@Service("bannerService")
public class BannerService implements BannerManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception{
		dao.save("BannerMapper.save", pd);
	}
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception{
		dao.delete("BannerMapper.delete", pd);
	}

	/**软删除
	* @param pd
	* @throws Exception
	*/
	public void softDelete(PageData pd) throws Exception {
		dao.update("BannerMapper.softDelete", pd);
	}

	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception{
		dao.update("BannerMapper.edit", pd);
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("BannerMapper.datalistPage", page);
	}
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("BannerMapper.listAll", pd);
	}
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("BannerMapper.findById", pd);
	}
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("BannerMapper.deleteAll", ArrayDATA_IDS);
	}

	/**批量软删除
	* @param ArrayDATA_IDS
	* @throws Exception
	*/
	public void softDeleteAll(String[] ArrayDATA_IDS) throws Exception {
		dao.update("BannerMapper.softDeleteAll", ArrayDATA_IDS);
	}

}

