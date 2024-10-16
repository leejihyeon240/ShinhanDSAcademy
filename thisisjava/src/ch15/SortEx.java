package ch15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ch15.sec05.exam03.Person;

public class SortEx {

	public static void main(String[] args) {

		// 기본 자료형
		int[] num = { 4, 1, 3, 5, 2 };

		// 정렬
		Arrays.sort(num);

		System.out.println(Arrays.toString(num));

		// 참조자료형
		Integer[] num2 = { 4, 1, 3, 5, 2 };
		// Arrays.sort(num2, Comparator.reverseOrder());
//		Arrays.sort(num2, (o1, o2) -> {
//			// o1 - o2 return이 하나 밖에 없으면 생략 가능
//			return o1 - o2;
//		});

		Arrays.sort(num2, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		System.out.println(Arrays.toString(num2));

		// int[] -> Integer[]
		Integer[] num3 = new Integer[num.length];
		for (int i = 0; i < num3.length; i++) {
			num3[i] = num[i];
		}
		System.out.println(Arrays.toString(num3));

		// 좀 더 빠른 식, for문의 시간 초과를 해결
		Integer[] num4 = Arrays.stream(num).boxed().toArray(Integer[]::new);
		System.out.println(Arrays.toString(num4));

		String[] name = { "김운학", "명재현", "김이한", "한동민", "이리우", "박성호" };

		Arrays.sort(name);
		System.out.println(Arrays.toString(name));

		Arrays.sort(name, Comparator.reverseOrder());
		System.out.println(Arrays.toString(name));

		// 컬렉션
		List<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(2);

		// 오름차순
		Collections.sort(list);
		System.out.println(list);

		// 내림차순
		Collections.sort(list, Comparator.reverseOrder());
		System.out.println(list);

		// 퀴즈
		Map<String, Object> student = new HashMap<>();
		student.put("name", "홍길동");
		student.put("age", 30);

		Map<String, Object> student2 = new HashMap<>();
		student2.put("name", "김길동");
		student2.put("age", 35);

		Map<String, Object> student3 = new HashMap<>();
		student3.put("name", "최길동");
		student3.put("age", 25);

		List<Map<String, Object>> students = new ArrayList<>();
		students.add(student);
		students.add(student2);
		students.add(student3);

		System.out.println(students);

		// 나이순으로(오름차순)
		Collections.sort(students, new Comparator<Map<String, Object>>() {
			@Override
			public int compare(Map<String, Object> m1, Map<String, Object> m2) {
				// return m1.get("age") - m2.get("age"); object는 뺄 수 없어서 오류 남
				return (Integer) m1.get("age") - (Integer) m2.get("age"); // 강제 형변환
			}
		});

		System.out.println(students);
		
		// 람다식
		Collections.sort(students, (m1, m2) -> (Integer) m1.get("age") - (Integer) m2.get("age"));
		System.out.println(students);

	}

}