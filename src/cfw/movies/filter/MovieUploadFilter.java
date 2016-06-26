package cfw.movies.filter;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import cfw.common.UploadService;
import cfw.exception.ServiceException;
import cfw.movies.dto.MovieSubmit;

/**
 * Movie upload filter to pack the template file name to persistent.
 * @author Fangwei_Cai
 * @time since 2016年4月10日 上午11:06:18
 */
public class MovieUploadFilter implements Filter {
	
	private UploadService uploadService;
	
	public void setUploadService(UploadService uploadService) {
		this.uploadService = uploadService;
	}

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
		String[] result = this.persistAndReplace(request);
		String name = request.getParameter("name");
		String abstract_ = request.getParameter("abstract_");
		
		MovieSubmit movieSubmit = new MovieSubmit();
		movieSubmit.setMainPicture(result[0]);
		movieSubmit.setAbstract_(abstract_);
		movieSubmit.setDescription(result[1]);
		movieSubmit.setName(name);
		
		request.setAttribute("movieSubmit", movieSubmit);
		
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
	
	/**
	 * This function to get template file URI and persistent the 
	 * template file in it.
	 * @return {String []}, Persisted URI of main picture and those
	 * in description.
	 * @author Fangwei_Cai
	 * @time since 2016年4月11日 上午10:19:52
	 */
	private String [] persistAndReplace(HttpServletRequest request){
		
		String mainPicTempName = request.getParameter("tempFilePath");
		String description = request.getParameter("description");
		
		String regex = "http://cfw.movies.com/temp/.{54}\\.((jpg)|(png))";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(description);
		
		String tempFileName = mainPicTempName;
		
		String mainPicture = "";
		try{
			
			if(StringUtils.isNotEmpty(tempFileName))
				mainPicture = uploadService.persistTempFile(tempFileName, "movie.upload.movie.path");
			
			while(matcher.find()){
				tempFileName = matcher.group().substring(36);
				String persistentFilePath = uploadService.persistTempFile(tempFileName, "movie.upload.movie.path");
				description = matcher.replaceFirst(persistentFilePath);
				matcher = pattern.matcher(description);
			}
		}catch(ServiceException e){
			e.printStackTrace();
		}
		
		return new String[]{mainPicture,description};
	}

}
