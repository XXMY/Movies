package cfw.movies.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cfw.movies.model.Recommends;
import cfw.movies.model.Users;

/**
 * @author Fangwei_Cai
 * @time since 2016年5月29日 上午11:06:36
 */
@Repository
public interface TempRecommendsMapper{
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年5月29日 上午11:12:31
	 * @return
	 */
	List<Users> selectRecommendUsers();
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年5月29日 上午11:18:31
	 * @param user
	 * @return
	 */
	List<Recommends> selectRecommends(Users user);
}
