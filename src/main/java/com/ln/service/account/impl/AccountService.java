package com.ln.service.account.impl;

import java.util.List;
import javax.annotation.Resource;

import com.ln.entity.Account;
import org.springframework.stereotype.Service;
import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;
import com.ln.service.account.AccountManager;

/** 
 * 说明： 账号
 * 创建人：xiaolw Q76114567
 * 创建时间：2018-12-23
 * @version
 */
@Service("accountService")
public class AccountService implements AccountManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	/**通过token获取account
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public Account getAccountByTokenOrOpenid(PageData pd) throws Exception {
		return (Account) dao.findForObject("AccountMapper.getAccountByTokenOrOpenid", pd);
	}

	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception{
		dao.save("AccountMapper.save", pd);
	}

	/**新增
	 * @param account
	 * @throws Exception
	 */
	public void saveAccount(Account account)throws Exception{
		dao.save("AccountMapper.saveAccount", account);
	}

	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception{
		dao.delete("AccountMapper.delete", pd);
	}

	/**软删除
	* @param pd
	* @throws Exception
	*/
	public void softDelete(PageData pd) throws Exception {
		dao.update("AccountMapper.softDelete", pd);
	}

	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception{
		dao.update("AccountMapper.edit", pd);
	}
	/**修改token
	 * @param pd
	 * @throws Exception
	 */
	public void editToken(PageData pd)throws Exception{
		dao.update("AccountMapper.editToken", pd);
	}

	/**列表
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("AccountMapper.datalistPage", page);
	}
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("AccountMapper.listAll", pd);
	}
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("AccountMapper.findById", pd);
	}
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("AccountMapper.deleteAll", ArrayDATA_IDS);
	}

	/**批量软删除
	* @param ArrayDATA_IDS
	* @throws Exception
	*/
	public void softDeleteAll(String[] ArrayDATA_IDS) throws Exception {
		dao.update("AccountMapper.softDeleteAll", ArrayDATA_IDS);
	}

}

