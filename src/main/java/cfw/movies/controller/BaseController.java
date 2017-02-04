package cfw.movies.controller;

import cfw.movies.dto.AjaxRequestResult;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月18日 下午1:54:55
 */
public abstract class BaseController {

	public AjaxRequestResult buildAjaxResult(int code,String message){
		AjaxRequestResult result = new AjaxRequestResult(code,message);
		
		return result;
	}
}
