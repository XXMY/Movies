package cfw.movies.model;

import java.util.Date;

/**
 * @author Fangwei_Cai
 * @time since 2016年3月4日 下午9:32:14
 */
public class Movies {
	
	private int id;
	private String name;
	private int type;
	private Date time;
	private int abstract_;
	private String pic;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getAbstract_() {
		return abstract_;
	}
	public void setAbstract_(int abstract_) {
		this.abstract_ = abstract_;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	
}
