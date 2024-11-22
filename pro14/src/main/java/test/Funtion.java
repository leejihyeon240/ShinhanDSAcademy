package test;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Funtion {
	// instance 메서드
	public int plus(int x, int y) {
		return x + y;
	}
	
	// static 메서드
	static public int minus(int x, int y) {
		return x - y;
	}
	
	// 날짜 변환
	static public String dateFormat(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		return sdf.format(d);
	}
}
