package cfw.movies.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import cfw.movies.model.Movies;
import cfw.movies.model.Users;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月8日 下午3:12:44
 */
@Component("moviesMapper")
public interface MoviesMapper extends Mapper<Movies> {
	
	/**
	 * Select movies in list, can be paged.
	 * @param map
	 * @return
	 */
	List<Movies> selectMovies(Map<String,Object> map);
	
	/**
	 * Select movies with full informations.
	 * @author Fangwei_Cai
	 * @time since 2016年4月24日 下午6:13:24
	 * @param map
	 * @return
	 */
	List<Movies> selectFullMovies(Map<String,Object> map);
	
	/**
	 * Select the count of movies.
	 * @author Fangwei_Cai
	 * @time since 2016年4月24日 下午9:53:52
	 * @return
	 */
	Long selectCount();
	
	/**
	 * Delete movies specified by id array.
	 * @author Fangwei_Cai
	 * @time since 2016年4月26日 下午3:03:08
	 * @param ids
	 * @return
	 */
	int deleteMovies(Long [] ids);
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年5月8日 下午3:02:43
	 * @param map
	 * @return
	 */
	List<Movies> selectPic(Map<String,Object> map);
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年5月8日 下午3:03:02
	 * @param map
	 * @return
	 */
	int updatePic(Map<String,Object> map);
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年5月31日 下午6:58:16
	 * @param user
	 * @return
	 */
	List<Movies> selectRecommendedMovies(Users user);
	
	/**
	 * Select five movies which score is in top list. 
	 * @author Fangwei_Cai
	 * @time since 2016年5月31日 下午7:51:40
	 * @return
	 */
	List<Movies> selectTopScoreMoviesToRecommend();
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年6月1日 下午5:10:20
	 * @param mid
	 * @return
	 */
	Long selectDesciptionId(Long mid);
}
