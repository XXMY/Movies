package cfw.movies.controller.moviecatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HttpRequest {
    /**
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     * @throws IOException 
     */
    public static String sendGet(String url, String param)  {
       String result = "";
       
       BufferedReader br = null;
       
       try{
    	   URL realUrl = new URL(url + "?" +param);
    	   
    	   URLConnection connection = realUrl.openConnection();
    	   
    	   connection.connect();
    	   
    	   InputStreamReader inputStream = new InputStreamReader(connection.getInputStream(),"gb2312");
    	   
    	   br = new BufferedReader(inputStream);
    	   
    	   String line = "";
    	   while((line = br.readLine()) != null){
    		   result += line;
    	   }
    	   
       }catch(Exception e){
    	   System.err.println("Send request "+url+" failed!");
    	   e.printStackTrace();
       }finally{
    	  try{
    		  if(br != null){
    			  br.close();
    		  }
    	  }catch(IOException e){
    		  e.printStackTrace();
    	  }
       }
       
       
       return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
    
    /**
     * Check whether the URL is accessible. 
     * @author Fangwei_Cai
     * @time since 2016年4月22日 上午10:21:57
     */
    public static boolean checkUrlAccess(String url){
    	
    	try{
    		URL realUrl = new URL(url);
    		URLConnection connection = realUrl.openConnection();
    		connection.connect();
    		String contentType = connection.getContentType();
    		System.out.println(contentType);
    		
    		if(contentType == null || (!contentType.equalsIgnoreCase("image/jpeg") && !contentType.equalsIgnoreCase("image/png"))) 
    			return false;
    	}catch(IOException e){
    		return false;
    	}
    	
    	return true;
    }
}