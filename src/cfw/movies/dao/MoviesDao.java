package cfw.movies.dao;

import java.util.List;
import java.util.Map;

import cfw.movies.model.Movies;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月8日 下午4:18:10
 */
public interface MoviesDao {
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年4月8日 下午4:18:42
	 */
	int insertMovie(Movies movies);
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年4月24日 上午10:24:53
	 * @param map
	 * @return List<Movies>
	 */
	List<Movies> selectMovies(Map<String,Object> map);
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年4月24日 下午6:39:51
	 * @param map
	 * @return
	 */
	List<Movies> selectFullMovies(Map<String,Object> map);
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年4月24日 下午9:56:23
	 * @return
	 */
	Long selectCount();
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年5月7日 上午12:25:57
	 * @param id
	 * @return
	 */
	Movies selectOne(Long id);
}
