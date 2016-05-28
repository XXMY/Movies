package cfw.movies.service;

import java.util.List;
import java.util.Map;

import cfw.movies.dto.MovieComment;
import cfw.movies.dto.Page;
import cfw.movies.model.Comments;
import cfw.movies.model.Descriptions;
import cfw.movies.model.Movies;
import cfw.movies.model.Types;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月2日 下午5:54:26
 */
public interface MovieService {
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年4月2日 下午5:54:52
	 */
	List<Types> getAllTypes();
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年4月11日 上午11:44:22
	 */
	boolean addType(Types type);
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年4月8日 下午4:35:24
	 */
	boolean addMovie(Movies movies);
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年4月8日 下午4:44:47
	 */
	boolean addDescription(Descriptions abstracts);
	
	/**
	 * <b>Get movies in list.</b><p>
	 * We may have many place need to get movies
	 * in list, and we need to identify them.
	 * For now, we use flag to differ. The value 
	 * and it's means as parameter says.
	 * 
	 * @author Fangwei_Cai
	 * @time since 2016年4月24日 上午11:17:49
	 * @param page<Page>
	 * @param flag <br>
	 * 	Use flag to identify the different usage 
	 * of this method.<br>
	 * 	1: Get movie list for management page in table.<br>
	 * 	In this case, we just need id, name, type, score of
	 * movie.<br>
	 *  2: Get movie list for visitors, in index page and
	 *  search page and others.<br>
	 *  We need to get full information of movies.
	 * 
	 * 
	 * @return
	 */
	List<Movies> getMovies(Page page,int flag);
	
	/**
	 * Count the number of movies.
	 * @author Fangwei_Cai
	 * @time since 2016年4月24日 下午9:57:24
	 * @return
	 */
	Long countMovies();
	
	/**
	 * Add a new comment.
	 * @author Fangwei_Cai
	 * @time since 2016年5月1日 上午11:48:13
	 * @param mComment
	 * @return
	 */
	boolean addComment(MovieComment mComment);
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年5月7日 上午12:27:18
	 * @param id
	 * @return
	 */
	Movies getOneMovie(Long id);
	
	/**
	 * 
	 * @author Fangwei_Cai
	 * @time since 2016年5月7日 上午11:08:55
	 * @param mid
	 * @return
	 */
	List<Comments> getCommentsOfMovie(Long mid);
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年5月8日 下午3:02:43
	 * @param map
	 * @return
	 */
	List<Movies> findPic(Map<String,Object> map);
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年5月8日 下午3:03:02
	 * @param map
	 * @return
	 */
	boolean modifyPic(Map<String,Object> map);
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年5月8日 下午10:07:56
	 * @param mids
	 * @return
	 */
	boolean deleteMovie(Long ... mids);
}
