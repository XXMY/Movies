package cfw.movies.service;

import java.util.List;

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
	 * @time since 2016年4月8日 下午4:35:24
	 */
	int addMovie(Movies movies);
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年4月8日 下午4:44:47
	 */
	int addAbstract(Descriptions abstracts);
}
