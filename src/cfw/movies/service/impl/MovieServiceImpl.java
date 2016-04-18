package cfw.movies.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cfw.movies.dao.AbstractsDao;
import cfw.movies.dao.MoviesDao;
import cfw.movies.dao.TypesDao;
import cfw.movies.model.Descriptions;
import cfw.movies.model.Movies;
import cfw.movies.model.Types;
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
		boolean addAbstractResult = addAbstract(movies.getDescription());
		
		// Movie's abstract persist succeed then persist the movie.
		int insertMovieResult = 0;
		if(addAbstractResult){
			insertMovieResult = moviesDaoImpl.insertMovie(movies);
		}
		
		return insertMovieResult>0 ? true : false;
	}
	
	/**
	 * @see cfw.movies.service.MovieService#addAbstract(cfw.movies.model.Descriptions)
	 * @author Fangwei_Cai
	 * @time since 2016年4月8日 下午4:45:40
	 */
	@Override
	public boolean addAbstract(Descriptions abstracts) {
		int insertAbstractResult = abstractsDaoImpl.insertAbstract(abstracts);
		
		return insertAbstractResult>0 ? true : false;
	}

	/*
	 * Setters and Getters
	 */
	public void setTypesDao(TypesDao typesDao) {
		this.typesDaoImpl = typesDao;
	}

}
