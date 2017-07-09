package com.blogforum.sso.web.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.support.json.JSONUtils;
import com.blogforum.common.enums.BizError;
import com.blogforum.sso.common.exception.SSOBusinessException;

/**
 * 统一返回异常类
 * 
 * @author wwd pl
 */
@ControllerAdvice
public class MyCustomExceptionResolver{
	private static Logger logger = LoggerFactory.getLogger(MyCustomExceptionResolver.class);

	@ExceptionHandler(value = Exception.class)
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
						Exception exception) {
		// 判断是否ajax请求
		if (!(request.getHeader("accept").indexOf("application/json") > -1 || (request
							.getHeader("X-Requested-With") != null && request.getHeader(
												"X-Requested-With").indexOf("XMLHttpRequest") > -1))) {
			// 如果不是ajax，JSP格式返回
			// 为安全起见，只有业务异常我们对前端可见，否则否则统一归为系统异常
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("success", "false");
			if (exception instanceof SSOBusinessException) {
				map.put("status", ((SSOBusinessException) exception).getCode());
				map.put("msg", exception.getMessage());

			} else {
				map.put("status", BizError.SYS_EXCEPTION.getStatus());
				map.put("msg", BizError.SYS_EXCEPTION.getMsg());
				logger.error(BizError.SYS_EXCEPTION.getMsg(), exception);
			}

			// 对于非ajax请求，我们都统一跳转到error.jsp页面
			return new ModelAndView("/error", map);
		} else {
			// 如果是ajax请求，JSON格式返回
			try {
				response.setContentType("application/json;charset=UTF-8");
				PrintWriter writer = response.getWriter();
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("success", "false");
				// 为安全起见，只有业务异常我们对前端可见，否则统一归为系统异常
				if (exception instanceof SSOBusinessException) {
					map.put("status", ((SSOBusinessException) exception).getCode());
					map.put("msg", exception.getMessage());
				} else {
					map.put("status", BizError.SYS_EXCEPTION.getStatus());
					map.put("msg", BizError.SYS_EXCEPTION.getMsg());
					logger.error(BizError.SYS_EXCEPTION.getMsg(), exception);
				}
				writer.write(JSONUtils.toJSONString(map));
				writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
