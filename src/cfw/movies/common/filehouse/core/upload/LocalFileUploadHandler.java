package cfw.movies.common.filehouse.core.upload;

import java.io.File;  
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;


@Component("fileUploadHandler")
public class LocalFileUploadHandler extends AbstractFileUploadHandler implements FileUploadHandler {

	/**
	 * 将输入流写出到本地目标文件
	 * 
	 * @param source					原文件输入流
	 * @param output					目标文件名
	 * @throws IOException
	 */
	@Override
	protected void write(InputStream source, String output) throws IOException {
		
		cfw.util.FileUtils.createDirectory(cfw.util.FileUtils.truncateFilePath(output));
		
		FileUtils.copyInputStreamToFile(source, new File(output));
	}

}
