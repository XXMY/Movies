package cfw.test;


import cfw.movies.model.Users;

import java.lang.reflect.Field;
import java.text.ParseException;

public class Main {

	private String name;

	private Users user;

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) throws ParseException, ClassNotFoundException{
		Class moviesClass = Class.forName("cfw.movies.model.Movies");
		try {
			Field [] fields = moviesClass.getFields();
			for(Field field : fields){
				System.out.println(field.getType().getName());
			}
		} catch (Exception e ) {
			e.printStackTrace();
		}
	}
}
