package ch06.sec08;

public class CylinderTest {

	public static void main(String[] args) {
		Cylinder c = new Cylinder();
		
		c.radius = 4;
		c.height = 5;
		
		System.out.printf("원기둥의 부피 : %.2f\n", c.getVolume());
		System.out.printf("원기둥의 겉넓이 : %.2f\n", c.getArea());
	}

}

class Cylinder {

	public int height;
	public int radius;
	
	public double getArea() {
		return radius*radius*height*Math.PI;
	}

	public double getVolume() {
		return 2*Math.PI*radius*radius+2*Math.PI*radius*height;
	}
	
}