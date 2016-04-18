package cfw.movies.model;

import java.util.Date;

/**
 * @author Fangwei_Cai
 * @time since 2016年3月4日 下午9:32:14
 */
public class Movies {
	
	private Long id;
	
	private String name;
	
	private String type;
	
	private Date time;
	
	private Descriptions description;
	
	public Movies() {
		super();
	}

	public Movies(String name, String type, Descriptions description, String pic) {
		super();
		this.name = name;
		this.type = type;
		this.description = description;
		this.pic = pic;
	}

	// Main picture.
	private String pic;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Date getTime() {
		return time;
	}
	
	public void setTime(Date time) {
		this.time = time;
	}
	
	public Descriptions getDescription() {
		return description;
	}
	
	public void setDescription(Descriptions description) {
		this.description = description;
	}
	
	public String getPic() {
		return pic;
	}
	
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	
}
