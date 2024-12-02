package chapter06;

import lombok.Data;

@Data
public class MemberVO {
	private String id;
	private String name;
	private String pwd;
	private String email;
	private String joindate;
	
	// 검색
	private String searchType;
	private String searchWord;
}
