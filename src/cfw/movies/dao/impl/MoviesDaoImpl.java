package cfw.movies.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cfw.movies.dao.MoviesDao;
import cfw.movies.mapper.MoviesMapper;
import cfw.movies.model.Movies;
import cfw.movies.model.Users;

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

	/**
	 * (non-Javadoc)
	 * @see cfw.movies.dao.MoviesDao#selectMovies(java.util.Map)
	 * @author Fangwei_Cai
	 * @time since 2016年4月24日 下午4:35:59
	 */
	@Override
	public List<Movies> selectMovies(Map<String, Object> map) {
		List<Movies> movies = this.moviesMapper.selectMovies(map);
		return movies;
	}

	/**
	 * (non-Javadoc)
	 * @see cfw.movies.dao.MoviesDao#selectFullMovies(java.util.Map)
	 * @author Fangwei_Cai
	 * @time since 2016年4月24日 下午6:40:04
	 */
	@Override
	public List<Movies> selectFullMovies(Map<String, Object> map) {
		List<Movies> movies = this.moviesMapper.selectFullMovies(map);
		
		return movies;
	}

	/**
	 * (non-Javadoc)
	 * @see cfw.movies.dao.MoviesDao#selectCount()
	 * @author Fangwei_Cai
	 * @time since 2016年4月24日 下午9:56:40
	 */
	@Override
	public Long selectCount() {
		Long count = this.moviesMapper.selectCount();
		return count;
	}

	/**
	 * (non-Javadoc)
	 * @see cfw.movies.dao.MoviesDao#selectOne(java.lang.Long)
	 * @author Fangwei_Cai
	 * @time since 2016年5月7日 上午12:26:14
	 */
	@Override
	public Movies selectOne(Long id) {
		Movies movie = this.moviesMapper.selectOne(id);
		return movie;
	}

	/**
	 * (non-Javadoc)
	 * @see cfw.movies.dao.MoviesDao#selectPic(java.util.Map)
	 * @author Fangwei_Cai
	 * @time since 2016年5月8日 下午3:03:48
	 */
	@Override
	public List<Movies> selectPic(Map<String, Object> map) {
		List<Movies> movies = this.moviesMapper.selectPic(map);
		
		return movies;
	}

	/**
	 * (non-Javadoc)
	 * @see cfw.movies.dao.MoviesDao#updatePic(java.util.Map)
	 * @author Fangwei_Cai
	 * @time since 2016年5月8日 下午3:03:53
	 */
	@Override
	public int updatePic(Map<String, Object> map) {
		int result = this.moviesMapper.updatePic(map);
		
		return result;
	}

	/**
	 * (non-Javadoc)
	 * @see cfw.movies.dao.MoviesDao#updateMovie(cfw.movies.model.Movies)
	 * @author Fangwei_Cai
	 * @time since 2016年5月8日 下午10:05:57
	 */
	@Override
	public int updateMovie(Movies movie) {
		int result = this.moviesMapper.updateOne(movie);
		
		return result;
	}

	/**
	 * (non-Javadoc)
	 * @see cfw.movies.dao.MoviesDao#selectRecommendedMovies(cfw.movies.model.Users)
	 * @author Fangwei_Cai
	 * @time since 2016年5月31日 下午7:44:12
	 */
	@Override
	public List<Movies> selectRecommendedMovies(Users user) {
		List<Movies> recommendMovies = this.moviesMapper.selectRecommendedMovies(user);
		
		return recommendMovies;
	}

	/**
	 * (non-Javadoc)
	 * @see cfw.movies.dao.MoviesDao#selectTopScoreMoviesToRecommend()
	 * @author Fangwei_Cai
	 * @time since 2016年5月31日 下午8:00:43
	 */
	@Override
	public List<Movies> selectTopScoreMoviesToRecommend() {
		List<Movies> recommendMovies = this.moviesMapper.selectTopScoreMoviesToRecommend();
		
		return recommendMovies;
	}

	/**
	 * (non-Javadoc)
	 * @see cfw.movies.dao.MoviesDao#selectDesciptionId(java.lang.Long)
	 * @author Fangwei_Cai
	 * @time since 2016年6月1日 下午5:13:29
	 */
	@Override
	public Long selectDesciptionId(Long mid) {
		Long result = this.moviesMapper.selectDesciptionId(mid);
		return result;
	}
	
	

}
