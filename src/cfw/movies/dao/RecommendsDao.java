package cfw.movies.dao;

import cfw.movies.model.Recommends;

/**
 * @author Fangwei_Cai
 * @time since 2016年5月29日 上午11:35:13
 */
public interface RecommendsDao {

	/**
	 * @author Fangwei_Cai
	 * @time since 2016年5月29日 上午11:36:07
	 * @param recommend
	 * @return
	 */
	int insertOne(Recommends recommend);
}
