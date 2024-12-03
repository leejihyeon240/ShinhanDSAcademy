package chapter09;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class StudentVO {
	private int studno;
	private String name;
	private String id;
	private int grade;
	private String jumin;
	private Timestamp birthday;
	private String tel;
	private int height;
	private int weight;
	private int major1;
	private int major2;
	private int profno;
	
	private String searchType;
	private String searchWord;
	private String profname;
	private int searchGrade;
	private int[] searchMajor;
	
	private String[] hobbyName;
}






