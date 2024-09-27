package ch03.sec01;

public class IncreseDecreaseOperatorExample {

	public static void main(String[] args) {
		int x = 10;
		int y = 10;
		int z;

		x++; // 후위연산(실행문 실행 후)
		++x; // 전위연산(실행문 실행 전)
		System.out.println("x=" + x);

		System.out.println("-------------------------");
		y--;
		--y;
		System.out.println("y=" + y);

		System.out.println("-------------------------");
		z = x++;
		System.out.println("z=" + z);
		System.out.println("x=" + x);

		System.out.println("-------------------------");
		z = ++x;
		System.out.println("z=" + z);
		System.out.println("x=" + x);

		System.out.println("-------------------------");
		z = ++x + y++;
		System.out.println("z=" + z);
		System.out.println("x=" + x);
		System.out.println("y=" + y);

	}

}
