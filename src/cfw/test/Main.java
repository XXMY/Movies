package cfw.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	
	public static void main(String[] args) throws ParseException, ClassNotFoundException{
		String typeName = "java.lang.util.List<cfw.movies.model.Movies>";
		if(typeName.matches(".*<.*>")){
			String parentTypeName = typeName.substring(0, typeName.indexOf("<"));
			String sonTypeName = typeName.substring(typeName.indexOf("<")+1, typeName.indexOf(">"));
			System.out.println(parentTypeName);
			System.out.println(sonTypeName);
			
			
		}else{
			System.out.print("false");
		}
	}
}
