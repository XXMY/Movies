package cfw.movies.mapper;

import cfw.movies.model.Types;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Fangwei_Cai
 * @time since 2016年3月30日 下午10:01:28
 */
@Repository("typesMapper")
@Mapper
public interface TypesMapper extends BaseMapper<Types> {
	
	/**
	 * Get all types.
	 * @author Fangwei_Cai
	 * @time since 2016年3月30日 下午10:02:23
	 */
	List<Types> selectAll();
}