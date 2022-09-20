package gr.codelearn.core.showcase.datetime;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class LocalTimeDemo {
	public static void main(String[] args) {
		LocalTimeDemo localTimeDemo = new LocalTimeDemo();
		localTimeDemo.examples();
	}
	
	public void examples() {
		LocalTime localTime = LocalTime.now();
		System.out.println("Current time is: " + localTime);
		System.out.println("Current hour is: " + localTime.getHour());
		System.out.println("Current minute is: " + localTime.getMinute());
		System.out.println("Max time is: "+ LocalTime.MAX);
		ZoneId.getAvailableZoneIds().forEach(System.out::println);
		System.out.println("Current time for Asia/Tokyo zone: "+ LocalTime.now(ZoneId.of("Asia/Tokyo")));
		
		System.out.println("Replace "+ localTime + " minutes field with 15. Modified time is: "+ localTime.withMinute(15));
		
		LocalTime midnight = LocalTime.parse("00:00");
		System.out.println("Midnight time: "+midnight);
		
		LocalTime secondsOfDay = LocalTime.ofSecondOfDay(30000);
		System.out.println("Time by adding 30000 seconds from midnight: "+secondsOfDay);
		
		boolean isChronoUnitSupported = LocalTime.now().isSupported(ChronoUnit.WEEKS);
		System.out.println("Is ChronoUnit.WEEKS supported for time? "+ (isChronoUnitSupported? "true":"false"));
	}
}
