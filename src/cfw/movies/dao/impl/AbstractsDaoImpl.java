package cfw.movies.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cfw.movies.dao.AbstractsDao;
import cfw.movies.mapper.DescriptionsMapper;
import cfw.movies.model.Descriptions;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月8日 下午4:33:33
 */
@Repository("abstractsDaoImpl")
public class AbstractsDaoImpl implements AbstractsDao {

	@Autowired
	private DescriptionsMapper abstractsMapper;
	
	/**
	 * @see cfw.movies.dao.AbstractsDao#insertAbstract(cfw.movies.model.Descriptions)
	 * @author Fangwei_Cai
	 * @time since 2016年4月8日 下午4:32:37
	 */
	@Override
	public int insertAbstract(Descriptions abstracts) {
		int result = this.abstractsMapper.insertOne(abstracts);
		
		return result;
	}
}
