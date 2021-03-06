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
import cfw.movies.dao.RecommendsDao;
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
	
	@Autowired
	private RecommendsDao recommendsDao;
	
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
	 *
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
     * @return
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
		try{
			Long count = moviesDaoImpl.selectCount();
			return count;
		}catch(Exception e){
			System.out.println("countMovie exception");
			e.printStackTrace();
		}

		return null;

	}

	/**
	 * (non-Javadoc)
	 * @see cfw.movies.service.MovieService#addComment(cfw.movies.dto.MovieComment)
	 * @author Fangwei_Cai
	 * @time since 2016年5月1日 上午11:49:06
	 */
	@Override
	public boolean addComment(MovieComment mComment) throws Exception {
		Comments comment = new Comments();

		Users user = usersDaoImpl.selectUserByName(mComment.getUsername());
		
		if(user == null) return false;
		
		comment.setUser(user);
		comment.setComment(mComment.getComment());
		comment.setMid(mComment.getMid());
		comment.setScore(mComment.getScore());
		
		int insertCommentResult = commentsDaoImpl.insertComment(comment);
		
		if(insertCommentResult > 0)
			//throw new RuntimeException("Add comment transaction test");
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
		try{
			Movies movie = this.moviesDaoImpl.selectOne(id);

			return movie;
		}catch (Exception e){
			System.out.println("getOneMovie exception");
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年5月7日 上午11:03:36
	 * @param mid
	 * @return
	 */
	@Override
	public List<Comments> getCommentsOfMovie(Long mid) {
		try{
			List<Comments> comments = this.commentsDaoImpl.selectCommentsOfMovie(mid);

			return comments;
		}catch(Exception e){
			System.out.println("getCommentsOfMovie exception");
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * (non-Javadoc)
	 * @see cfw.movies.service.MovieService#findPic(java.util.Map)
	 * @author Fangwei_Cai
	 * @time since 2016年5月8日 下午3:06:18
	 */
	@Override
	public List<Movies> findPic(Map<String, Object> map) {
		Long start = (Long) map.get("start");
		int length = (Integer) map.get("length");
		try{
			List<Movies> movies = this.moviesDaoImpl.selectPic(start, length);

			return movies;
		}catch(Exception e){
			System.out.println("findPic exception");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * (non-Javadoc)
	 * @see cfw.movies.service.MovieService#modifyPic(java.util.Map)
	 * @author Fangwei_Cai
	 * @time since 2016年5月8日 下午3:06:21
	 */
	@Override
	public boolean modifyPic(Map<String, Object> map) {
		int result = this.moviesDaoImpl.updatePic(map);
		
		if(result>0){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * (non-Javadoc)
	 * @see cfw.movies.service.MovieService#deleteMovie(java.lang.Long[])
	 * @author Fangwei_Cai
	 * @time since 2016年5月8日 下午10:08:14
	 */
	@Override
	public boolean deleteMovie(Long... mids) {
		for(Long mid : mids){
			Movies movie = new Movies();
			movie.setId(mid);
			movie.setIsdeleted(true);
			
			int deleteResult = this.moviesDaoImpl.updateMovie(movie);
			if(deleteResult <= 0) return false;
		}
		
		return true;
	}

	/**
	 * (non-Javadoc)
	 * @see cfw.movies.service.MovieService#getRecommendMovies(cfw.movies.model.Users)
	 * @author Fangwei_Cai
	 * @time since 2016年5月31日 下午7:47:48
	 */
	@Override
	public List<Movies> getRecommendMovies(Users user) {
		List<Movies> recommendMovies = null;
		// While user is not logined.
		if(user == null){
			recommendMovies = this.moviesDaoImpl.selectTopScoreMoviesToRecommend();
			
			return recommendMovies;
		}
		
		int recommendCount = this.recommendsDao.selectRecommendedMoviesCount(user);
		if(recommendCount>0)
			recommendMovies = this.moviesDaoImpl.selectRecommendedMovies(user);
		else
			recommendMovies = this.moviesDaoImpl.selectTopScoreMoviesToRecommend();
			
		
		return recommendMovies;
	}

	/**
	 * (non-Javadoc)
	 * @see cfw.movies.service.MovieService#modifyMoive(cfw.movies.model.Movies)
	 * @author Fangwei_Cai
	 * @time since 2016年6月1日 下午4:52:32
	 */
	@Override
	public boolean modifyMoive(Movies movie) {
		
		if(movie.getId() == null || movie.getId()<=0) return false;
		
		Long descriptionId = this.moviesDaoImpl.selectDesciptionId(movie.getId());
		if(descriptionId == null ) return false;
		
		Descriptions description = movie.getDescription();
		description.setId(descriptionId);
		int updateDescriptionResult = this.abstractsDaoImpl.updateOne(description);
		
		if(updateDescriptionResult <= 0) return false;
		
		int updateMovieResult = this.moviesDaoImpl.updateMovie(movie);
		
		if(updateMovieResult > 0) return true;
		
		return false;
	}

}
