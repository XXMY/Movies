package cfw.movies.model;

import com.google.gson.Gson;

/**
 * @author Fangwei_Cai
 * @time since 2016年3月4日 下午9:34:30
 */
public class Users {
	
	private Long id;
	private String username;
	private String password;
	private String head_pic;
	private boolean type;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHead_pic() {
		return head_pic;
	}
	public void setHead_pic(String head_pic) {
		this.head_pic = head_pic;
	}
	public boolean isType() {
		return type;
	}
	public void setType(boolean type) {
		this.type = type;
	}
	@Override
	public String toString() {
		/*return "Users [id=" + id + ", username=" + username + ", password=" + password + ", head_pic=" + head_pic
				+ ", type=" + type + "]";*/
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
	
}
