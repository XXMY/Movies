package cfw.movies.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cfw.movies.dao.UsersDao;
import cfw.movies.model.Users;
import cfw.movies.service.RegisterService;

/**
 * @author Fangwei_Cai
 * @time since 2016年3月26日 下午8:07:16
 */
@Service("registerServiceImpl")
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private UsersDao usersDaoImpl;
	
	/**
	 * @author fwCai
	 * @since 2016.03.26 20:12
	 */
	@Override
	public boolean userExists(Users user) {
		Long result = usersDaoImpl.checkUser(user);
		
		if(result>0)
			return true;
		
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
			Long result = usersDaoImpl.addUser(user);
			if(result > 0)
				return true;
		}
		
		return false;
	}

}
