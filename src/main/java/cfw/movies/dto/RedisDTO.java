package cfw.movies.dto;

/**
 * @author Fangwei_Cai
 * @time since 2016年6月26日 下午4:29:50
 */
public class RedisDTO {

	private int id;

	private String [] fields;

	private long start;

	private long end;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String[] getFields() {
		return fields;
	}

	public void setFields(String[] fields) {
		this.fields = fields;
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public long getEnd() {
		return end;
	}

	public void setEnd(long end) {
		this.end = end;
	}
	
}
