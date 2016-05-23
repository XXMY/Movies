package cfw.movies.service.impl;

import org.springframework.stereotype.Service;

import cfw.movies.controller.admin.recommend.RecommendStatus;
import cfw.movies.dto.AjaxRequestResult;
import cfw.movies.service.RecommendService;
import cfw.movies.thread.RecommendThread;

/**
 * @author Fangwei_Cai
 * @time since 2016年5月15日 下午9:11:55
 */

@Service("recommendService")
public class RecommendServiceImpl implements RecommendService {

	/**
	 * (non-Javadoc)
	 * @see cfw.movies.service.RecommendService#startRecommend()
	 * @author Fangwei_Cai
	 * @time since 2016年5月15日 下午9:12:01
	 */
	@Override
	public boolean startRecommend() {
		RecommendThread thread = new RecommendThread("recommendThread");
		thread.start();
		return true;
	}

	/**
	 * (non-Javadoc)
	 * @see cfw.movies.service.RecommendService#getRecommendStaus()
	 * @author Fangwei_Cai
	 * @time since 2016年5月15日 下午9:12:06
	 */
	@Override
	public AjaxRequestResult getRecommendStaus() {
		AjaxRequestResult ajaxResult = RecommendStatus.statusMessage;
		
		return ajaxResult;
	}

}
