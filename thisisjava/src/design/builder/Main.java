package design.builder;

public class Main {

	public static void main(String[] args) {
		// 빌더 패턴을 사용한 클래스의 객체 생성

int score = 85;
String grade = "";
switch (score / 10) {
    case 9 :
        grade = "A";
    case 8 :
        grade = "B";
    case 7 :
        grade = "C";
    default :
        grade = "D";
}
System.out.println(grade);

	}
}
