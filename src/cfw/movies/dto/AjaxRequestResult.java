package cfw.movies.dto;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月11日 上午10:32:08
 */
public class AjaxRequestResult {
	
	private int code;
	
	private String message;
	
	public AjaxRequestResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AjaxRequestResult(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
