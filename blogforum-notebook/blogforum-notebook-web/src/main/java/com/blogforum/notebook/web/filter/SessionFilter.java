package com.blogforum.notebook.web.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import com.blogforum.common.tools.CookieUtils;
import com.blogforum.notebook.service.session.SessionServer;
import com.blogforum.sso.facade.model.UserVO;


public class SessionFilter extends OncePerRequestFilter {

	private static final Logger logger = LoggerFactory.getLogger(SessionFilter.class);    
	
	private SessionServer sessionServer;
	
	/**登录地址*/
	private String	ssoUrl;
	

	public void setSsoUrl(String ssoUrl) {
		this.ssoUrl = ssoUrl;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
						throws ServletException, IOException {
		try {
			//获取cookie中的token
			String token = CookieUtils.getCookie(request, "COOKIE_TOKEN");
			//通过token获取登录的用户
			UserVO user = sessionServer.getUserByToken(token);
			//如果用户为空代表没有登录返回跳转页面
			if (user == null) {
				loginAgain(request, response);
				return ;
			}
			if (logger.isInfoEnabled()) {
				logger.info("成功获取到user:" + user.toString());
			}
			//把查询到的用户保存到request中 方便后面获取
			request.setAttribute("user", user);
		} catch (Exception e) {
			logger.error("sessionFilter用户登录判断过滤器异常:",e);
		}
		//业务逻辑不包异常
		filterChain.doFilter(request, response);
		
	}
	
	/**
	 * 返回用戶為登錄提醒 跳轉到登錄頁面
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @author wwd
	 * @date 2017年3月12日上午12:50:39
	 * @version V1.0
	 */
	private void loginAgain(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String loginPage = ssoUrl;
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		StringBuilder builder = new StringBuilder();
		// 因为请求直接拦截 浏览器默认是GBK 所以需要设置返回页面的编码为utf-8作统一 防止有些浏览器GBK 有些UTF-8
		builder.append("<html>");
		builder.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
		builder.append("<title>Insert title here</title>");
		builder.append("<script>");
		builder.append("alert('网页过期，请重新登录！');");
		builder.append("window.location.href='");
		builder.append(loginPage);
		builder.append("';");
		builder.append("</script>");
		builder.append("</html>");
		out.print(builder.toString());
	}

	public void setSessionServer(SessionServer sessionServer) {
		this.sessionServer = sessionServer;
	}

}
