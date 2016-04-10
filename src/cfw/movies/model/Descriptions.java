package cfw.movies.model;


/**
 * @author Fangwei_Cai
 * @time since 2016年3月4日 下午10:04:52
 */
public class Descriptions {
	
	private Long id;
	
	private String description;
	
	private boolean isdeleted;
	
	public Descriptions(){
		this.isdeleted = false;
	}
	
	public boolean isIsdeleted() {
		return isdeleted;
	}
	public void setIsdeleted(boolean isdeleted) {
		this.isdeleted = isdeleted;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
