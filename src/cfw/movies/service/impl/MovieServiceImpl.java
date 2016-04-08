package cfw.movies.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cfw.movies.dao.TypesDao;
import cfw.movies.model.Types;
import cfw.movies.service.MovieService;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月2日 下午5:55:41
 */
@Service("movieServiceImpl")
public class MovieServiceImpl implements MovieService {

	@Autowired
	private TypesDao typesDao;
	
	@Override
	public List<Types> getAllTypes() {
		List<Types> movieTypes = typesDao.findAll();
		
		return movieTypes;
	}

	/*
	 * Setters and Getters
	 */
	public void setTypesDao(TypesDao typesDao) {
		this.typesDao = typesDao;
	}
	
}
