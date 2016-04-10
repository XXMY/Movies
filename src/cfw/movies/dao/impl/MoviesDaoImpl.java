package cfw.movies.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cfw.movies.dao.MoviesDao;
import cfw.movies.mapper.MoviesMapper;
import cfw.movies.model.Movies;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月8日 下午4:21:47
 */
@Repository("moviesDaoImpl")
public class MoviesDaoImpl implements MoviesDao {
	
	@Autowired
	private MoviesMapper moviesMapper;
	
	/**
	 * @see cfw.movies.dao.MoviesDao#insertMovie(cfw.movies.model.Movies)
	 * @author Fangwei_Cai
	 * @time since 2016年4月8日 下午4:25:32
	 */
	@Override
	public int insertMovie(Movies movies) {
		int result = this.moviesMapper.insertOne(movies);
		
		return result;
	}

}
