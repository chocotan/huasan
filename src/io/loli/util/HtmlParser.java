package io.loli.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Project: MyOldBlog
 * Package: io.loli.blog.tools
 * Created Date: 2013-4-9 下午6:52:34
 * Description: 
 * 
 * @author choco
 */

public class HtmlParser {  
	@SuppressWarnings("finally")
	public static String getHtmlContent(String s) {
		StringBuilder sb=new StringBuilder();
		try {
			URL url=new URL(s);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					url.openStream()));
			String line;
			
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();

		} catch (MalformedURLException e) {
			
		} catch (IOException e) {
			
		}finally{
			return sb.toString();
		}
	}
    public static void main(String argsp[]){  
        System.out.println(getHtmlContent("https://raw.github.com/ochiho/io.loli.util/master/src/ad")) ;  
    }  
}  