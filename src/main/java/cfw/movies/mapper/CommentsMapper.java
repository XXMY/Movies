package cfw.movies.mapper;

import cfw.movies.model.Comments;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Fangwei_Cai
 * @time since 2016年5月1日 上午11:37:55
 */
@Repository
@Mapper
public interface CommentsMapper extends BaseMapper<Comments> {

	/**
	 * Select comments of one movie.
	 * @author Fangwei_Cai
	 * @time since 2016年5月7日 上午10:35:16
	 * @param mid {Long} movie id.
	 * @return
	 */
	List<Comments>selectComments(Long mid);
}
