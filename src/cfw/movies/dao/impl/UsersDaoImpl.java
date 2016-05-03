package cfw.movies.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cfw.movies.dao.UsersDao;
import cfw.movies.mapper.UsersMapper;
import cfw.movies.model.Users;

/**
 * @author Fangwei_Cai
 * @time since 2016年3月26日 下午4:56:41
 */
@Repository("usersDao")
public class UsersDaoImpl implements UsersDao {

	@Autowired
	private UsersMapper usersMapper;
	
	/**
	 * @author fwCai.
	 * @since 2016.03.26 17:00
	 */
	@Override
	public int checkUser(Users user) {
		
		int count = usersMapper.findOne(user);
		
		return count;
	}

	/**
	 * @author fwCai
	 * @since 2016.03.26 20:11
	 */
	@Override
	public int updateUser(Users user) {
		
		int result = usersMapper.updateOne(user);
		
		return result;
	}

	/**
	 * @author fwCai
	 * @since 2016.03.27 10:08
	 */
	@Override
	public int addUser(Users user) {
		
		int result = usersMapper.insertOne(user);
		
		return result;
	}
	
	/**
	 * (non-Javadoc)
	 * @see cfw.movies.dao.UsersDao#selectUserByName(java.lang.String)
	 * @author Fangwei_Cai
	 * @time since 2016年5月1日 下午2:16:42
	 */
	@Override
	public Users selectUserByName(String username) {
		Users user = usersMapper.selectUserByName(username);
		return user;
	}


}
