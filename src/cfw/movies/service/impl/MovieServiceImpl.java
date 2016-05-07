package cfw.movies.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cfw.common.reflect.SimpleAssign;
import cfw.movies.dao.AbstractsDao;
import cfw.movies.dao.CommentsDao;
import cfw.movies.dao.MoviesDao;
import cfw.movies.dao.TypesDao;
import cfw.movies.dao.UsersDao;
import cfw.movies.dto.MovieComment;
import cfw.movies.dto.Page;
import cfw.movies.model.Comments;
import cfw.movies.model.Descriptions;
import cfw.movies.model.Movies;
import cfw.movies.model.Types;
import cfw.movies.model.Users;
import cfw.movies.service.MovieService;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月2日 下午5:55:41
 */
@Service("movieServiceImpl")
public class MovieServiceImpl implements MovieService {

	@Autowired
	private TypesDao typesDaoImpl;
	
	@Autowired
	private MoviesDao moviesDaoImpl;
	
	@Autowired
	private AbstractsDao abstractsDaoImpl;
	
	@Autowired
	private CommentsDao commentsDaoImpl;
	
	@Autowired
	private UsersDao usersDaoImpl;
	
	/**
	 * @see cfw.movies.service.MovieService#getAllTypes()
	 * @author Fangwei_Cai
	 * @time since 2016年4月8日 下午4:35:57
	 */
	@Override
	public List<Types> getAllTypes() {
		List<Types> movieTypes = typesDaoImpl.findAll();
		
		return movieTypes;
	}
	
	/**
	 * @see cfw.movies.service.MovieService#addType(cfw.movies.model.Types)
	 * @author Fangwei_Cai
	 * @time since 2016年4月11日 上午11:44:49
	 */
	@Override
	public boolean addType(Types type) {
		int insertTypeResult = typesDaoImpl.insertType(type);
		return insertTypeResult>0 ? true : false;
	}
	
	/**
	 * @see cfw.movies.service.MovieService#addMovie(cfw.movies.model.Movies)
	 * @author Fangwei_Cai
	 * @time since 2016年4月8日 下午4:36:06
	 */
	@Override
	public boolean addMovie(Movies movies) {
		
		// Persist movie's abstract first.
		boolean addAbstractResult = addDescription(movies.getDescription());
		
		// Movie's abstract persist succeed then persist the movie.
		int insertMovieResult = 0;
		if(addAbstractResult){
			insertMovieResult = moviesDaoImpl.insertMovie(movies);
		}
		
		return insertMovieResult>0 ? true : false;
	}
	
	/**
	 * @see cfw.movies.service.MovieService#addDescription(cfw.movies.model.Descriptions)
	 * @author Fangwei_Cai
	 * @time since 2016年4月8日 下午4:45:40
	 */
	@Override
	public boolean addDescription(Descriptions abstracts) {
		int insertAbstractResult = abstractsDaoImpl.insertDescription(abstracts);
		
		return insertAbstractResult>0 ? true : false;
	}

	/**
	 * (non-Javadoc)
	 * @see cfw.movies.service.MovieService#getMovies(cfw.movies.dto.Page)
	 * @author Fangwei_Cai
	 * @time since 2016年4月24日 下午3:24:39
	 */
	@Override
	public List<Movies> getMovies(Page page, int flag) {
		List<Movies> movies = null;
		Map<String,Object> paramMap = new HashMap<String,Object>();
		
		boolean result = SimpleAssign.assignValueToMap(paramMap, page);
		if(result){
			switch(flag){
			case 1:
				movies = moviesDaoImpl.selectMovies(paramMap);
				break;
			case 2:
				movies = moviesDaoImpl.selectFullMovies(paramMap);
				break;
			}
		}
		
		if(movies == null || movies.size() == 0) return movies;
		
		List<Types> types = this.getAllTypes();
		for(Movies movie : movies){
			String movieTypeStr = movie.getType();
			String [] typeStrArr = movieTypeStr.split("_");
			String typeName = "";
			for(String typeStr : typeStrArr){
				for(Types type : types){
					if(type.getId() == Integer.parseInt(typeStr)){
						typeName += type.getType_name() + "/";
					}
				}
			}
			movie.setType(typeName.substring(0, typeName.length()-1));
		}
		
		return movies;
	}

	/**
	 * (non-Javadoc)
	 * @see cfw.movies.service.MovieService#countMovies()
	 * @author Fangwei_Cai
	 * @time since 2016年4月24日 下午9:58:14
	 */
	@Override
	public Long countMovies() {
		Long count = moviesDaoImpl.selectCount();
		return count;
	}

	/**
	 * (non-Javadoc)
	 * @see cfw.movies.service.MovieService#addComment(cfw.movies.dto.MovieComment)
	 * @author Fangwei_Cai
	 * @time since 2016年5月1日 上午11:49:06
	 */
	@Override
	public boolean addComment(MovieComment mComment) {
		Comments comment = new Comments();
		
		Users user = usersDaoImpl.selectUserByName(mComment.getUsername());
		
		if(user == null) return false;
		
		comment.setUser(user);
		comment.setComment(mComment.getComment());
		comment.setMid(mComment.getMid());
		comment.setScore(mComment.getScore());
		
		int insertCommentResult = commentsDaoImpl.insertComment(comment);
		
		if(insertCommentResult > 0)
			return true;
		
		return false;
	}

	/**
	 * (non-Javadoc)
	 * @see cfw.movies.service.MovieService#getOneMovie(java.lang.Long)
	 * @author Fangwei_Cai
	 * @time since 2016年5月7日 上午12:28:07
	 */
	@Override
	public Movies getOneMovie(Long id) {
		Movies movie = this.moviesDaoImpl.selectOne(id);
		
		return movie;
	}
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年5月7日 上午11:03:36
	 * @param mid
	 * @return
	 */
	@Override
	public List<Comments> getCommentsOfMovie(Long mid) {
		List<Comments> comments = this.commentsDaoImpl.selectCommentsOfMovie(mid);
		
		return comments;
	}

}
