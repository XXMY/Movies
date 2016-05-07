package cfw.movies.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cfw.movies.model.Comments;

/**
 * @author Fangwei_Cai
 * @time since 2016年5月1日 上午11:37:55
 */
@Repository
public interface CommentsMapper extends Mapper<Comments>{

	/**
	 * Select comments of one movie.
	 * @author Fangwei_Cai
	 * @time since 2016年5月7日 上午10:35:16
	 * @param mid {Long} movie id.
	 * @return
	 */
	List<Comments>selectComments(Long mid);
}
