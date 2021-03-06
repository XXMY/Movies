package cfw.movies.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Fangwei_Cai
 * @time since 2016年3月4日 下午10:03:50
 */
public class Comments {
	
	private Long id;
	
	private String comment;
	
	private float score;
	
	private Users user;
	
	private Long mid;
	
	private Date create_time;
	
	private int like;

	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comments(Long id, String comment, float score, Long mid, Date create_time) {
		super();
		this.id = id;
		this.comment = comment;
		this.score = score;
		this.mid = mid;
		this.create_time = create_time;
	}

	public Comments(Long id, String comment, Float score, Long mid, Date create_time,Integer like) {
		super();
		this.id = id;
		this.comment = comment;
		this.score = score;
		this.mid = mid;
		this.create_time = create_time;
		this.like = like;
	}

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

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
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
	
	public String getCreate_timeString(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		
		return simpleDateFormat.format(create_time);
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	
	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	@Override
	public String toString() {
		return "Comments [id=" + id + ", comment=" + comment + ", score=" + score + ", user=" + user + ", mid=" + mid
				+ ", create_time=" + create_time + ", like=" + like + "]";
	}

	
}
