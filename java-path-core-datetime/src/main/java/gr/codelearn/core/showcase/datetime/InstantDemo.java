package gr.codelearn.core.showcase.datetime;

import java.time.Instant;
import java.time.LocalDateTime;

public class InstantDemo {
	public static void main(String[] args) {
		InstantDemo instantDemo = new InstantDemo();
		instantDemo.examples();
	}
	
	public void examples() {
		Instant instant = Instant.now();
		System.out.println("Current instant is: "+instant + " LocalDaTime is" + LocalDateTime.now());
	}
}
