package cfw.movies.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import cfw.movies.model.Movies;

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
}
