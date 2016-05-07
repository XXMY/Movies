package cfw.movies.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cfw.movies.dao.CommentsDao;
import cfw.movies.mapper.CommentsMapper;
import cfw.movies.model.Comments;

/**
 * @author Fangwei_Cai
 * @time since 2016年5月1日 上午11:44:42
 */
@Repository("commentsDaoImpl")
public class CommentsDaoImpl implements CommentsDao {

	@Autowired
	private CommentsMapper commentsMapper;
	
	/**
	 * (non-Javadoc)
	 * @see cfw.movies.dao.CommentsDao#insertComment(cfw.movies.model.Comments)
	 * @author Fangwei_Cai
	 * @time since 2016年5月1日 上午11:45:08
	 */
	@Override
	public int insertComment(Comments comment) {
		
		int result = this.commentsMapper.insertOne(comment);
		
		return result;
	}

	/**
	 * (non-Javadoc)
	 * @see cfw.movies.dao.CommentsDao#selectCommentsOfMovie(java.lang.Long)
	 * @author Fangwei_Cai
	 * @time since 2016年5月7日 上午11:02:05
	 */
	@Override
	public List<Comments> selectCommentsOfMovie(Long mid) {
		List<Comments> comments = this.commentsMapper.selectComments(mid);
		
		return comments;
	}

}
