package cfw.movies.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cfw.movies.dao.TempRecommendsDao;
import cfw.movies.mapper.TempRecommendsMapper;
import cfw.movies.model.Recommends;
import cfw.movies.model.Users;

/**
 * @author Fangwei_Cai
 * @time since 2016年5月29日 上午11:31:57
 */
@Repository
public class TempRecommendsDaoImpl implements TempRecommendsDao {

	@Autowired
	private TempRecommendsMapper tempRecommendsMapper;
	
	/**
	 * (non-Javadoc)
	 * @see cfw.movies.dao.TempRecommendsDao#selectRecommendUsers()
	 * @author Fangwei_Cai
	 * @time since 2016年5月29日 上午11:32:11
	 */
	@Override
	public List<Users> selectRecommendUsers() {
		
		List<Users> users = this.tempRecommendsMapper.selectRecommendUsers();
		
		return users;
	}

	/**
	 * (non-Javadoc)
	 * @see cfw.movies.dao.TempRecommendsDao#selectRecommends(cfw.movies.model.Users)
	 * @author Fangwei_Cai
	 * @time since 2016年5月29日 上午11:32:15
	 */
	@Override
	public List<Recommends> selectRecommends(Users user) {
		
		List<Recommends> recommends = this.tempRecommendsMapper.selectRecommends(user);
		
		return recommends;
	}

}
