package cfw.movies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cfw.movies.model.Users;
import cfw.movies.service.RegisterService;
import cfw.util.CodeHelper;


/**
 * @author Fangwei_Cai
 * @time since 2016年3月26日 下午8:49:13
 */
@Controller
@RequestMapping(value="/register",method=RequestMethod.POST)
public class RegisterController {

	@Autowired
	private RegisterService registerServiceImpl;
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年3月26日 下午8:05:55
	 */
	@RequestMapping(value="/userCheck")
	@ResponseBody
	public boolean userCheck(Users user){
		
		if(user.getUsername() == null) return false;
		
		boolean result = registerServiceImpl.userExists(user);
		
		return result;
	}
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年3月27日 上午10:15:19
	 */
	@RequestMapping("/registerUser")
	@ResponseBody
	public boolean userRegister(Users user){
		if(CodeHelper.isEmpty(user.getUsername()) || CodeHelper.isEmpty(user.getPassword()))
			return false;
		
		boolean result = registerServiceImpl.register(user);
		
		return result;
		
	}
	
}
