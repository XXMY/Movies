package cfw.movies.controller.upload;

import java.io.File;   
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import static cfw.util.Constants.*;
import cfw.exception.ServiceException;
import cfw.movies.common.UploadService;
import cfw.movies.dto.UploadResult;
import cfw.util.Folder;

/**
 * @author Fangwei_Cai
 * @time since 2016年3月21日 上午10:33:53
 */
@RequestMapping("/upload")
@Controller
public class FileUploadController {
	
	@Autowired
	private UploadService uploadServiceImpl;
	
	/*@RequestMapping("/temp")
	@ResponseBody
	public UploadResult uploadTempFiles(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
		UploadResult uploadResult = new UploadResult();
		
		String tempPath = Folder.tempUploadDir();
		
		String tempFilePathName = tempPath + file.getOriginalFilename();
		
		System.out.println(tempFilePathName);
		try{
			file.transferTo(new File(tempFilePathName));
			uploadResult.setFilePath(tempFilePathName);
			uploadResult.setLink(Folder.templinkPath() + file.getOriginalFilename());
			uploadResult.setStatus((short)1);
			uploadResult.setMessage("文件上传成功");
		}catch(Exception e){
			e.printStackTrace();
			uploadException(uploadResult);
		}
		
		
		return uploadResult;
	}*/
	
	
	
	@RequestMapping("/temp2")
	@ResponseBody
	public UploadResult uploadTempFiles(@RequestParam("file") MultipartFile file, HttpServletRequest request){
		UploadResult uploadResult = new UploadResult();
		try{
			String pathName = this.uploadServiceImpl.uploadTempFile(file.getInputStream(), file.getOriginalFilename());
			uploadResult.setFilePath(pathName);
			uploadResult.setStatus((short)1);
			uploadResult.setMessage("文件上传成功");
		}catch(ServiceException se){
			se.printStackTrace();
			uploadException(uploadResult);
		}catch(IOException ioe){
			ioe.printStackTrace();
			uploadException(uploadResult);
		}
		
		return uploadResult;
	}
	
	private void uploadException(UploadResult uploadResult){
		uploadResult.setStatus((short)0);
		uploadResult.setMessage("文件上传异常");
	}
}
