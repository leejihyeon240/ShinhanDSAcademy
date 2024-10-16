package ch15.sec05.exam03;

public class Person implements Comparable<Person> {
	public String name;
	public int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;

	}

	@Override
	public int compareTo(Person o) {
//		if (age < o.age) {
//			return -1;
//		} else if (age == o.age) {
//			return 0;
//		} else {
//			return 1;
//		}
		
		return age - o.age; // 오름차순 + 나옴
		// return o.age - age; // 내림차순 - 나옴
		
	}
}
