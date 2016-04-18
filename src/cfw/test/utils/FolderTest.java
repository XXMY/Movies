package cfw.test.utils;

import java.io.IOException;

import org.junit.Test;

import cfw.util.Folder;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月3日 上午11:38:12
 */
public class FolderTest {

	@Test
	public void TestTempUploadDir() throws IOException{
		String path = Folder.tempUploadDir();
		System.out.println(path);
	}
	
	//@Test
	public void testTodayDir(){
		int [] array = Folder.todayDir();
		
		System.out.println(array);
	}
}
