package cfw.movies.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cfw.common.reflect.SimpleAssign;
import cfw.movies.dao.UsersDao;
import cfw.movies.model.Users;
import cfw.movies.service.UserService;

/**
 * @author Fangwei_Cai
 * @time since 2016年3月26日 下午8:07:16
 */
@Service("registerServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersDao usersDaoImpl;
	
	/**
	 * @author fwCai
	 * @since 2016.03.26 20:12
	 */
	@Override
	public boolean userExists(Users user) {
		int result = usersDaoImpl.checkUser(user);
		
		if(result>0){
			// Query user's information except password based on user's name.
			Users tempUser = this.usersDaoImpl.selectUserByName(user.getUsername());
			if(tempUser != null){
				SimpleAssign.assignValue(null, tempUser, user);
				return true;
			}
		}
		
		return false;
	}

	/**
	 * @author fwCai
	 * @since 2016.06.26 20:13
	 */
	@Override
	public boolean modifyUsersInfo(Users newUser) {
		int result = usersDaoImpl.updateUser(newUser);
		
		if(result>0)
			return true;
		
		return false;
	}

	/**
	 * @author fwCai
	 * @since 2016.03.27 10:11
	 */
	@Override
	public boolean register(Users user) {
		boolean userExists = userExists(user);
		if(!userExists){
			int result = usersDaoImpl.addUser(user);
			if(result > 0)
				return true;
		}
		
		return false;
	}


}
