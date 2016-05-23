package cfw.movies.thread;

import cfw.movies.controller.admin.recommend.RecommendStatus;
import cfw.movies.r.R;

/** 
 * @author Fangwei_Cai
 * @time since 2016年5月15日 下午9:12:42
 */
public class RecommendThread extends Thread {
	
	private R r ;
	
	public RecommendThread(String name){
		super.setName(name);
		this.r = new R();
	}
	
	public void run(){
		doRecommend();
	}
	
	private synchronized void doRecommend(){
		synchronized (RecommendStatus.class){
			RecommendStatus.inProcessing = true;
		}
		
		// R connect to MySQL.
		boolean connectToMysqlResult = this.r.connectToMysql();
		if(connectToMysqlResult){
			String message = "连接数据库成功,将评价数据存入HDFS中...";
			this.setRecommendStatus(30, message);
		}
		
		// Get data from mysql and store into HDFS.
		boolean putRatingDataIntoHDFSResult = this.r.putRatingDateIntoHDFS();
		if(putRatingDataIntoHDFSResult){
			String message = "评价数据存入HDFS成功，Map-Reduce 计算推荐数据中...";
			this.setRecommendStatus(50, message);
		}
		
		// Execute map-reduce.
		boolean mapReduceResult = this.r.executeRecommendMR();
		if(mapReduceResult){
			String message = "Map-Reduce 推荐数据计算完成，正将数据存入 MySQL 中...";
			this.setRecommendStatus(80, message);
		}
		
		boolean putRecommendDataToMysqlResult = this.r.putRecommendDataToMysql();
		if(putRecommendDataToMysqlResult){
			String message = "推荐数据存入 MySQL 完成，计算结束";
			this.setRecommendStatus(100, message);
		}
		
		this.r.destroy();
		
	}
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年5月15日 下午9:55:39
	 * @param code
	 * @param message
	 */
	private synchronized void setRecommendStatus(int code,String message){
		RecommendStatus.statusMessage.setCode(code);
		RecommendStatus.statusMessage.setMessage(message);
	}
}
