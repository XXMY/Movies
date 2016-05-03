package cfw.movies.mapper;

import org.springframework.stereotype.Component;

import cfw.movies.model.Users;

/**
 * @author Fangwei_Cai
 * @time since 2016年3月14日 下午2:22:38
 */
@Component("usersMapper")
public interface UsersMapper extends Mapper<Users> {
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年5月1日 下午2:17:30
	 * @param username
	 * @return
	 */
	Users selectUserByName(String username);
}
