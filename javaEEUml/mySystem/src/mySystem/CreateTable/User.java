package mySystem.CreateTable;

public class User {
	private Integer id;
	private String school_id;
	private String name;
	private String password;
	private String identify;
	
	public User(String school_id, String name, String password, String identify){
		//this.id = id;
		this.school_id = school_id;
		this.name = name;
		this.password = password;
		this.identify = identify;
	}
	
	public Integer getId(){
		return this.id;
	}
	public String getSchoolId(){
		return this.school_id;
	}
	public String getName(){
		return this.name;
	}
	public String getPassword(){
		return this.password;
	}
	public String getIdentify(){
		return this.identify;
	}
}
