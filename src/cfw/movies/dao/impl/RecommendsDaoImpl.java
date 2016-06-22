package cfw.movies.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cfw.movies.dao.RecommendsDao;
import cfw.movies.mapper.RecommendsMapper;
import cfw.movies.model.Recommends;
import cfw.movies.model.Users;

/**
 * @author Fangwei_Cai
 * @time since 2016年5月31日 下午7:04:41
 */
@Repository
public class RecommendsDaoImpl implements RecommendsDao {

	@Autowired
	private RecommendsMapper recommendsMapper;
	
	/**
	 * (non-Javadoc)
	 * @see cfw.movies.dao.RecommendsDao#insertOne(cfw.movies.model.Recommends)
	 * @author Fangwei_Cai
	 * @time since 2016年5月29日 上午11:37:07
	 */
	@Override
	public int insertOne(Recommends recommend) {
		
		int result = this.recommendsMapper.insertOne(recommend);
		
		return result;
	}

	/**
	 * (non-Javadoc)
	 * @see cfw.movies.dao.RecommendsDao#selectRecommendedMoviesCount(cfw.movies.model.Users)
	 * @author Fangwei_Cai
	 * @time since 2016年5月31日 下午7:04:48
	 */
	@Override
	public int selectRecommendedMoviesCount(Users user) {
		int count = this.recommendsMapper.selectRecommendedMoviesCount(user);
		return count;
	}

}
