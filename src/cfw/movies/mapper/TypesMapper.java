package cfw.movies.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import cfw.movies.model.Types;

/**
 * @author Fangwei_Cai
 * @time since 2016年3月30日 下午10:01:28
 */
@Component("typesMapper")
public interface TypesMapper extends Mapper<Types> {
	
	/**
	 * Get all types.
	 * @author Fangwei_Cai
	 * @time since 2016年3月30日 下午10:02:23
	 */
	List<Types> selectAll();
}
