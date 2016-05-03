package cfw.movies.dao;

import cfw.movies.model.Comments;

/**
 * @author Fangwei_Cai
 * @time since 2016年5月1日 上午11:43:19
 */
public interface CommentsDao {
	
	/**
	 * Insert one comment.
	 * @author Fangwei_Cai
	 * @time since 2016年5月1日 上午11:44:03
	 * @param comment
	 * @return
	 */
	int insertComment(Comments comment);
}
