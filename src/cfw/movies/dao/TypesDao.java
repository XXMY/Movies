package cfw.movies.dao;

import java.util.List;

import cfw.movies.model.Types;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月2日 下午5:50:04
 */
public interface TypesDao {
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年4月2日 下午5:50:04
	 */
	List<Types> findAll();
}
