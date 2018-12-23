package com.ln.service.account;

import java.util.List;
import com.fh.entity.Page;
import com.fh.util.PageData;
import com.ln.entity.Account;

/** 
 * 说明： 账号接口
 * 创建人：xiaolw Q76114567
 * 创建时间：2018-12-23
 * @version
 */
public interface AccountManager{


	/**通过token获取account
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public Account getAccountByTokenOrOpenid(PageData pd) throws Exception;

	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception;

	/**新增
	 * @param account
	 * @throws Exception
	 */
	public void saveAccount(Account account)throws Exception;
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception;

	/**软删除
	* @param pd
	* @throws Exception
	*/
	public void softDelete(PageData pd)throws Exception;
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception;

	/**修改token
	 * @param pd
	 * @throws Exception
	 */
	public void editToken(PageData pd)throws Exception;
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	public List<PageData> list(Page page)throws Exception;
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	public List<PageData> listAll(PageData pd)throws Exception;
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception;
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception;

	/**批量软删除
	* @param ArrayDATA_IDS
	* @throws Exception
	*/
	public void softDeleteAll(String[] ArrayDATA_IDS)throws Exception;
}

