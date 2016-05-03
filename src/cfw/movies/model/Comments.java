package cfw.movies.model;

import java.util.Date;

/**
 * @author Fangwei_Cai
 * @time since 2016年3月4日 下午10:03:50
 */
public class Comments {
	
	private Long id;
	
	private String comment;
	
	private float score;
	
	private Long uid;
	
	private Long mid;
	
	private Date create_time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getMid() {
		return mid;
	}

	public void setMid(Long mid) {
		this.mid = mid;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	@Override
	public String toString() {
		return "Comments [id=" + id + ", comment=" + comment + ", score=" + score + ", uid=" + uid + ", mid=" + mid
				+ ", create_time=" + create_time + "]";
	}

	
	
}
