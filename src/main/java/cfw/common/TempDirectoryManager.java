package cfw.common;

import cfw.exception.ServiceException;

public interface TempDirectoryManager {

	/**
	 * 生成临时文件路径
	 * 
	 * @param 	originalFileName	原文件名
	 * @return 	String				生成的临时文件路径
	 * @throws 	ServiceException
	 * @throws com.common.exception.ServiceException 
	 */
	public String generateTempFilePath(String originalFileName) throws ServiceException;
	
	/**
	 * 根据临时文件名获取临时目录中的文件地址
	 * 
	 * @param 	tempFileName		临时文件名
	 * @return 	String				临时目录中的文件地址
	 * @throws 	ServiceException
	 * @throws com.common.exception.ServiceException 
	 */
	public String obtainTempFilePath(String tempFileName) throws ServiceException;
	
	/**
	 * 清除临时目录(只保留最近两天的文件夹)
	 * 
	 * @throws 	ServiceException
	 * @throws com.common.exception.ServiceException 
	 */
	public void cleanTempDirectory() throws ServiceException;
	
}
