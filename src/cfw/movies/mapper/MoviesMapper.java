package cfw.movies.mapper;

import org.springframework.stereotype.Component;

import cfw.movies.model.Movies;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月8日 下午3:12:44
 */
@Component("moviesMapper")
public interface MoviesMapper extends Mapper<Movies> {
	
}
