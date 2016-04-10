package cfw.movies.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cfw.common.UploadService;

/**
 * Movie upload filter to pack the template file name to persistent.
 * @author Fangwei_Cai
 * @time since 2016年4月10日 上午11:06:18
 */
@Component
public class MovieUploadFilter implements Filter {

	@Autowired
	private UploadService uploadService;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Main function.
	 * Get the template file name from main picture and description,
	 * use file upload service to persistent it, then replace them to
	 * persistent path and name, finally redirect the request to movie
	 * upload controller.
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 * @author Fangwei_Cai
	 * @time since 2016年4月10日 上午11:19:21
	 */
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		String mainPicTempName = request.getParameter("tempFilePath");
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
