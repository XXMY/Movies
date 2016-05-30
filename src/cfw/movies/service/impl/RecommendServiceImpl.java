package cfw.movies.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cfw.movies.controller.admin.recommend.RecommendStatus;
import cfw.movies.dao.RecommendsDao;
import cfw.movies.dao.TempRecommendsDao;
import cfw.movies.dto.AjaxRequestResult;
import cfw.movies.model.Recommends;
import cfw.movies.model.Users;
import cfw.movies.service.RecommendService;
import cfw.movies.thread.RecommendThread;

/**
 * @author Fangwei_Cai
 * @time since 2016年5月15日 下午9:11:55
 */

@Service("recommendService")
public class RecommendServiceImpl implements RecommendService {

	@Autowired
	private TempRecommendsDao tempRecommendsDao;
	
	@Autowired
	private RecommendsDao recommendsDao;
	
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

	/**
	 * (non-Javadoc)
	 * @see cfw.movies.service.RecommendService#processRecommendData()
	 * @author Fangwei_Cai
	 * @time since 2016年5月29日 下午1:19:20
	 */
	@Override
	public boolean processRecommendData() {
		
		List<Users> recommendUsers = this.tempRecommendsDao.selectRecommendUsers();
		if(recommendUsers == null || recommendUsers.size()<=0) return false;
		
		List<Recommends> recommends = null;
		for(Users user : recommendUsers){
			recommends = this.tempRecommendsDao.selectRecommends(user);
			for(Recommends recommend : recommends){
				if(recommend == null || recommend.getPref() < 1000) continue;
				
				int result = this.recommendsDao.insertOne(recommend);
				if(result <= 0){
					return false;
				}
			}
		}
		
		return true;
	}
	
	

}
