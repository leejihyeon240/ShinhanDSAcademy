package ch08.sec02;

public class RemoteControlExample {

	public static void main(String[] args) {
		RemoteControl rc;
		rc = new Television();
		rc.turnOn();
	
		rc = new Audio();
		rc.turnOn();
		
		System.out.println("리모콘 최대 볼륨 " + RemoteControl.MAX_VALUE) ;
		System.out.println("리모콘 최저 볼륨 " + RemoteControl.MIN_VALUE) ;
		
		rc.setMute(true);
		rc.setMute(false);
	}

}
