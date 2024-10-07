package ch06;

public class Member {
	private String id;
	private String name;
	private String pwd;
	
	// shift + alt + s > r > alt + a > r -> getter setter 만들어 줌
	// Source > Generate Getters and Setters > ...

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
