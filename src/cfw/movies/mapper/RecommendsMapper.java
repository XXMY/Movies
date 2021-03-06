package cfw.movies.mapper;

import org.springframework.stereotype.Repository;

import cfw.movies.model.Recommends;
import cfw.movies.model.Users;

/**
 * @author Fangwei_Cai
 * @time since 2016年5月29日 上午11:24:56
 */
@Repository
public interface RecommendsMapper extends Mapper<Recommends>{

	/**
	 * While the number of recommended movies larger than zero,then select movies.
	 * @author Fangwei_Cai
	 * @time since 2016年5月31日 下午6:59:15
	 * @param user
	 * @return
	 */
	int selectRecommendedMoviesCount(Users user);
}
