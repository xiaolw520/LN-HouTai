package com.ln.controller.dept;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import com.ln.entity.Code;
import com.ln.service.dept.DeptManager;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.util.AppUtil;
import com.fh.util.ObjectExcelView;
import com.fh.util.PageData;
import com.fh.util.Jurisdiction;
import com.ln.service.dept.DeptInfoManager;

/** 
 * 说明：院系简介
 * 创建人：xiaolw Q76114567
 * 创建时间：2018-12-16
 */
@Controller
@RequestMapping(value="/deptinfo")
public class DeptInfoController extends BaseController {
	
	String menuUrl = "deptinfo/list.do"; //菜单地址(权限用)
	@Resource(name="deptinfoService")
	private DeptInfoManager deptinfoService;

	@Resource(name="deptService")
	private DeptManager deptService;
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增DeptInfo");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("reftype", (byte) 1);
		pd.put("isdel",false);
		pd.put("state",0);
		pd.put("deptinfoid", this.get32UUID());	//主键
		pd.put("uptime", pd.get("crtime").toString());//设置修改时间
		deptinfoService.save(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"删除DeptInfo");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		deptinfoService.delete(pd);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改DeptInfo");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("uptime",/*DateUtil.getTime()*/new Date());
		deptinfoService.edit(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"列表DeptInfo");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
		List<PageData>	varList = deptinfoService.list(page);	//列出DeptInfo列表
		mv.setViewName("ln/dept/deptInfo_list");
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
		List<PageData> deptNames = deptService.nameListAll(new PageData());
		mv.addObject("deptNames", deptNames);
		mv.setViewName("ln/dept/deptInfo_edit");
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
		pd = deptinfoService.findById(pd);	//根据ID读取
		List<PageData> deptNames = deptService.nameListAll(new PageData());
		mv.addObject("deptNames", deptNames);
		mv.setViewName("ln/dept/deptInfo_edit");
		mv.addObject("msg", "edit");
		mv.addObject("pd", pd);
		return mv;
	}

	/**列表
	 * @throws Exception
	 */
	@RequestMapping(value="/ajaxlist",method = RequestMethod.GET)
	@ResponseBody
	public Object ajaxlist() {
		//logBefore(logger, Jurisdiction.getUsername()+"列表Banner");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Code code = null;
		List<PageData>	varList = null;	//列出Banner列表
		try {
			varList = deptinfoService.listAll(pd);
			if(varList !=null && varList.size()>0){
				code = Code.Success;
			}else {
				code = Code.NoData;
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = Code.Fail;
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list", varList);
		map.put("code", code);

		return AppUtil.returnObject(pd, map);

	}

    /**软删除
    * @param out
    * @throws Exception
    */
    @RequestMapping(value="/softDelete")
    public void softDelete(PrintWriter out) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"删除DeptInfo");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		deptinfoService.softDelete(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"批量删除DeptInfo");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
			String DATA_IDS = pd.getString("DATA_IDS");
			if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			deptinfoService.softDeleteAll(ArrayDATA_IDS);
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
		logBefore(logger, Jurisdiction.getUsername()+"批量删除DeptInfo");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			deptinfoService.deleteAll(ArrayDATA_IDS);
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
		logBefore(logger, Jurisdiction.getUsername()+"导出DeptInfo到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("上级院系");	//1
		titles.add("0顶级,1非顶级");	//2
		titles.add("文字");	//3
		titles.add("创建时间");	//4
		titles.add("更新时间");	//5
		titles.add("软删除");	//6
		titles.add("状态");	//7
		titles.add("排序");	//8
		titles.add("图片地址");	//9
		dataMap.put("titles", titles);
		List<PageData> varOList = deptinfoService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).getString("refid"));	    //1
			vpd.put("var2", varOList.get(i).get("reftype").toString());	//2
			vpd.put("var3", varOList.get(i).getString("info"));	    //3
			vpd.put("var4", varOList.get(i).getString("crtime"));	    //4
			vpd.put("var5", varOList.get(i).getString("uptime"));	    //5
			vpd.put("var6", varOList.get(i).get("isdel").toString());	//6
			vpd.put("var7", varOList.get(i).get("state").toString());	//7
			vpd.put("var8", varOList.get(i).get("sort").toString());	//8
			vpd.put("var9", varOList.get(i).getString("imgUrl"));	    //9
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
