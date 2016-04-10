package cfw.movies.dto;

/**
 * The DTO in submitting movies.
 * @author Fangwei_Cai
 * @time since 2016年4月9日 下午9:50:30
 */
public class MovieSubmit {

	//Template path of main picture.
	private String mainPicture;
	
	//Movie's name.
	private String name;
	
	//Array of movie types. 
	private int[] typesArray;
	
	//Abstracts of moives.
	private String abstracts;

	public String getMainPicture() {
		return mainPicture;
	}

	public void setMainPicture(String mainPicture) {
		this.mainPicture = mainPicture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getTypesArray() {
		return typesArray;
	}

	public void setTypesArray(int[] typesArray) {
		this.typesArray = typesArray;
	}

	public String getAbstracts() {
		return abstracts;
	}

	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}
	
	
}
