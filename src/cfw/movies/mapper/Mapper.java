package cfw.movies.mapper;


/**
 * Public data access operating function.
 *  While we need full object information to execute one SQL,
 *  then we income object as parameter.Otherwise use Map.
 *  In my view, using Map can cut memory costs more then Object.
 *  OK, that might be a wrong view.
 * @AUTHOR CaiFangwei
 * @DATE 2015年8月6日 下午3:10:18
 */
public interface Mapper<Template> {
	public Long insertOne(Template t);
	public int deleteOne(Template t);
	public int updateOne(Template t);
	
	/**
	 * Count the records.
	 * @author Fangwei_Cai
	 * @time since 2016年3月26日 下午4:59:00
	 */
	public Long findOne(Template t);
}
