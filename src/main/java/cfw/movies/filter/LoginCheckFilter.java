package cfw.movies.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * @author Fangwei_Cai
 * @time since 2016年5月31日 上午10:55:51
 */
public class LoginCheckFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpSession session = request.getSession();
		Map<String,Object> map = (Map<String,Object>)session.getAttribute(session.getId());
		String url = "http://cfw.movies.com"; 
		if(map==null){
			// 用户未登录
			url += "/login/index.html";
			response.sendRedirect(url);
		}else if(!(Boolean)map.get("type")){
			// 登录用户不是管理员用户
			url += "/index.html";
			response.sendRedirect(url);
		}else{
			// 用户已登录，且为管理员用户
			arg2.doFilter(arg0, arg1);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("INFOR: Login check filter is initializating!!");
		
	}

}
