package cfw.movies.mapper;

import cfw.movies.model.Problems;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository("problemsMapper")
@Mapper
public interface ProblemsMapper extends BaseMapper<Problems> {
}
