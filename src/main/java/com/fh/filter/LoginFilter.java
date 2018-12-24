package com.fh.filter;

import com.fh.controller.base.BaseController;
import com.fh.util.Const;
import com.fh.util.PageData;
import com.ln.entity.Account;
import com.ln.service.account.AccountManager;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**登录验证过滤器(废弃  com.fh.interceptor替代)
 * @author FH QQ 313596790[青苔]
 *
 */
public class LoginFilter extends BaseController implements Filter {


	private AccountManager accountService;

	private static Logger logger = Logger.getLogger(LoginFilter.class);

	private static final long serialVersionUID = 1L;

	public static final String LOGIN_TOKEN_KEY = "wl_auth";
	/**
	 * 初始化
	 */
	public void init(FilterConfig fc) throws ServletException {
		//FileUtil.createDir("d:/FH/topic/");
		ServletContext sc = fc.getServletContext();
		XmlWebApplicationContext cxt = (XmlWebApplicationContext)WebApplicationContextUtils.getWebApplicationContext(sc);
		if(cxt != null && cxt.getBean("accountService") != null && accountService == null)
			accountService = (AccountManager) cxt.getBean("accountService");
	}
	
	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		//从header中获取token
		String token = request.getHeader(LOGIN_TOKEN_KEY);
		//如果header中不存在token，则从参数中获取token
		if (StringUtils.isBlank(token)) {
			token = request.getParameter(LOGIN_TOKEN_KEY);
		}

		//token为空 跳转登录页面
		if (StringUtils.isBlank(token)) {
			logger.error("-- LoginFilter -->401 1--"+token);
			response.sendError(401);
			return;
		}
		PageData pd = new PageData();
		pd.put("token",token);
		Account account = null;
		try {
			account = accountService.getAccountByTokenOrOpenid(pd);	//根据ID读取
		} catch (Exception e) {
			e.printStackTrace();
		}

		//最后还是 userModel为空 跳转登录页面
		if (account == null) {
			logger.error("-- LoginFilter -->401 2--"+token);
			response.sendError(401);
			return;
		}
		HttpSession session = request.getSession();
		session.setAttribute(Const.SESSION_ACCOUNT, account);
		chain.doFilter(request, response);
	}

}
