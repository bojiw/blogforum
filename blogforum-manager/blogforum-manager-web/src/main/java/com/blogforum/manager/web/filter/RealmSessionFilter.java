package com.blogforum.manager.web.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.blogforum.manager.pojo.entity.AdminUser;
import com.blogforum.manager.pojo.entity.Permision;
import com.blogforum.manager.pojo.entity.Role;
import com.blogforum.manager.service.adminuser.RoleService;

@Component
public class RealmSessionFilter extends OncePerRequestFilter {

	@Autowired
	private RoleService roleService;
	
	private String exception;

	// 需要设置set方法才能获取web.xml配置的例外URL
	public void setException(String exception) {
		this.exception = exception;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
						throws ServletException, IOException {

		boolean isExcludedPage = false;

		String servletPath = request.getServletPath();

		String[] url = exception.split(",");
		for (String string : url) {
			if (servletPath.equals(string)) {
				isExcludedPage = true;
				break;
			}
		}
		// 在过滤url之外
		if (isExcludedPage) {
			filterChain.doFilter(request, response);
		} else {
			// 不在过滤url之外，判断session是否存在
			HttpSession session = request.getSession();
			AdminUser adminUser = (AdminUser) session.getAttribute("adminuser");
			//判断用戶是否登錄
			if (adminUser == null) {
				loginAgain(request,response);
				return;
			}
			
			//判斷用戶是否有权限
			boolean flag = checkPermision(request, response, adminUser, servletPath);
			if (flag) {
				filterChain.doFilter(request, response);
			}else {
				noPermision(request, response);
			}

		}
	}

	/**
	 * 返回用戶為登錄提醒 跳轉到登錄頁面
	 * @param request
	 * @param response
	 * @throws IOException
	 * @author wwd
	 * @date 2017年3月12日上午12:50:39
	 * @version V1.0
	 */
	private void loginAgain(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String loginPage = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath() + "/login.jsp";
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		StringBuilder builder = new StringBuilder();
		// 因为请求直接拦截 浏览器默认是GBK 所以需要设置返回页面的编码为utf-8作统一 防止有些浏览器GBK 有些UTF-8
		builder.append("<html>");
		builder.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
		builder.append("<title>Insert title here</title>");
		builder.append("<script>");
		builder.append("alert('网页过期，请重新登录！');");
		builder.append("window.top.location.href='");
		builder.append(loginPage);
		builder.append("';");
		builder.append("</script>");
		builder.append("</html>");
		out.print(builder.toString());
	}
	
	/**
	 * 判斷用戶是否有權限
	 * @param request
	 * @param response
	 * @param adminUser
	 * @param servletPath
	 * @return
	 * @author wwd
	 * @date 2017年3月12日上午12:50:25
	 * @version V1.0
	 */
	private boolean checkPermision(
								HttpServletRequest request,
								HttpServletResponse response, 
								AdminUser adminUser,
								String servletPath){
		int id = adminUser.getRole().getId();
		Role role = roleService.getByID(id);
		List<Permision> permisions = role.getPermisions();
		for (Permision permision : permisions) {
			if (servletPath.equals(permision.getController())) {
				return true;
			}
		}
		return false;
	}
	
	private void noPermision(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		StringBuilder builder = new StringBuilder();
		// 因为请求直接拦截 浏览器默认是GBK 所以需要设置返回页面的编码为utf-8作统一 防止有些浏览器GBK 有些UTF-8
		builder.append("<html>");
		builder.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
		builder.append("<title>Insert title here</title>");
		builder.append("<script>");
		builder.append("alert('您沒有权限');");
		builder.append("</script>");
		builder.append("</html>");
		out.print(builder.toString());
	}
	
}
