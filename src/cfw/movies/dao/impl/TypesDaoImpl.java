package cfw.movies.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cfw.movies.dao.TypesDao;
import cfw.movies.mapper.TypesMapper;
import cfw.movies.model.Types;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月2日 下午5:52:09
 */
@Repository("typesDaoImpl")
public class TypesDaoImpl implements TypesDao {
	
	@Autowired
	private TypesMapper typesMapper;
	
	@Override
	public List<Types> findAll() {
		List<Types> result = typesMapper.selectAll();
		return result;
	}

}
