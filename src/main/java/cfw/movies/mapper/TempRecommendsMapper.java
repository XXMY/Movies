package cfw.movies.mapper;

import cfw.movies.model.Recommends;
import cfw.movies.model.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Fangwei_Cai
 * @time since 2016年5月29日 上午11:06:36
 */
@Repository
@Mapper
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
