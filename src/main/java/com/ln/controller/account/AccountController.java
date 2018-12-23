package com.ln.controller.account;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.util.AppUtil;
import com.fh.util.ObjectExcelView;
import com.fh.util.PageData;
import com.fh.util.Jurisdiction;
import com.fh.util.Tools;
import com.ln.service.account.AccountManager;

/** 
 * 说明：账号
 * 创建人：xiaolw Q76114567
 * 创建时间：2018-12-23
 */
@Controller
@RequestMapping(value="/account")
public class AccountController extends BaseController {
	
	String menuUrl = "account/list.do"; //菜单地址(权限用)
	@Resource(name="accountService")
	private AccountManager accountService;
	
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增Account");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("reftype", (byte) 1);
		pd.put("isdel",false);
		pd.put("state",0);
		pd.put("accountid", this.get32UUID());	//主键
		pd.put("uptime", pd.get("crtime").toString());//设置修改时间
		accountService.save(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**删除
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value="/delete")
	public void delete(PrintWriter out) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"删除Account");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		accountService.delete(pd);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改Account");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("uptime",/*DateUtil.getTime()*/new Date());
		accountService.edit(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Page page) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"列表Account");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
		List<PageData>	varList = accountService.list(page);	//列出Account列表
		mv.setViewName("ln/account/account_list");
		mv.addObject("varList", varList);
		mv.addObject("pd", pd);
		mv.addObject("QX",Jurisdiction.getHC());	//按钮权限
		return mv;
	}
	
	/**去新增页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goAdd")
	public ModelAndView goAdd()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
    	pd.put("crtime",/*DateUtil.getTime()*/new Date());
		mv.setViewName("ln/account/account_edit");
		mv.addObject("msg", "save");
		mv.addObject("pd", pd);
		return mv;
	}	
	
	 /**去修改页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goEdit")
	public ModelAndView goEdit()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = accountService.findById(pd);	//根据ID读取
		mv.setViewName("ln/account/account_edit");
		mv.addObject("msg", "edit");
		mv.addObject("pd", pd);
		return mv;
	}


    /**软删除
    * @param out
    * @throws Exception
    */
    @RequestMapping(value="/softDelete")
    public void softDelete(PrintWriter out) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"删除Account");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		accountService.softDelete(pd);
		out.write("success");
		out.close();
    }

    /**批量软删除
    * @param
    * @throws Exception
    */
    @RequestMapping(value="/softDeleteAll")
    @ResponseBody
    public Object softDeleteAll() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"批量删除Account");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
			String DATA_IDS = pd.getString("DATA_IDS");
			if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			accountService.softDeleteAll(ArrayDATA_IDS);
			pd.put("msg", "ok");
			}else{
			pd.put("msg", "no");
		}
		pdList.add(pd);
		map.put("list", pdList);
		return AppUtil.returnObject(pd, map);
	}

	 /**批量删除
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteAll")
	@ResponseBody
	public Object deleteAll() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"批量删除Account");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			accountService.deleteAll(ArrayDATA_IDS);
			pd.put("msg", "ok");
		}else{
			pd.put("msg", "no");
		}
		pdList.add(pd);
		map.put("list", pdList);
		return AppUtil.returnObject(pd, map);
	}
	
	 /**导出到excel
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/excel")
	public ModelAndView exportExcel() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"导出Account到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("上级院系");	//1
		titles.add("0顶级,1非顶级");	//2
		titles.add("昵称");	//3
		titles.add("性别");	//4
		titles.add("创建时间");	//5
		titles.add("更新时间");	//6
		titles.add("软删除");	//7
		titles.add("状态");	//8
		titles.add("城市");	//9
		titles.add("省份");	//10
		titles.add("县");	//11
		titles.add("头像");	//12
		titles.add("微信id");	//13
		titles.add("union");	//14
		titles.add("电话");	//15
		titles.add("凭证");	//16
		dataMap.put("titles", titles);
		List<PageData> varOList = accountService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).getString("refid"));	    //1
			vpd.put("var2", varOList.get(i).get("reftype").toString());	//2
			vpd.put("var3", varOList.get(i).getString("nick_name"));	    //3
			vpd.put("var4", varOList.get(i).get("gender").toString());	//4
			vpd.put("var5", varOList.get(i).getString("crtime"));	    //5
			vpd.put("var6", varOList.get(i).getString("uptime"));	    //6
			vpd.put("var7", varOList.get(i).get("isdel").toString());	//7
			vpd.put("var8", varOList.get(i).get(" state").toString());	//8
			vpd.put("var9", varOList.get(i).getString("city"));	    //9
			vpd.put("var10", varOList.get(i).getString("province"));	    //10
			vpd.put("var11", varOList.get(i).getString("country"));	    //11
			vpd.put("var12", varOList.get(i).getString("avatar_url"));	    //12
			vpd.put("var13", varOList.get(i).getString("open_id"));	    //13
			vpd.put("var14", varOList.get(i).getString("union_id"));	    //14
			vpd.put("var15", varOList.get(i).getString("phone"));	    //15
			vpd.put("var16", varOList.get(i).getString("token"));	    //16
			varList.add(vpd);
		}
		dataMap.put("varList", varList);
		ObjectExcelView erv = new ObjectExcelView();
		mv = new ModelAndView(erv,dataMap);
		return mv;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
	}
}
