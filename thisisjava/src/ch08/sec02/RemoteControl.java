package ch08.sec02;

public interface RemoteControl {
	
	//상수
	int MAX_VALUE = 10; // public static final
	int MIN_VALUE = 0;
	
	// 추상메서드
	void turnOn(); // public abstract
	void turnOff();
	void setVolume(int volume);
	
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리합니다.");
			setVolume(MIN_VALUE);
		} else {
			System.out.println("무음 해제합니다.");
		}
	}
}
