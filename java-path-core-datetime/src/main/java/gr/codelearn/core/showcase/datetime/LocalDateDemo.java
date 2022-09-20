package gr.codelearn.core.showcase.datetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class LocalDateDemo {
	public static void main(String[] args) {
		LocalDateDemo localDateDemo = new LocalDateDemo();
		localDateDemo.getValues();
		localDateDemo.addAndSubtractDate();
		localDateDemo.parseDate();
		localDateDemo.compareDate();
	}
	public void getValues() {
		 LocalDate localDate = LocalDate.now();
		 System.out.println("LOCAL DATE GET VALUES");
		 System.out.println("---------------------");
		 
		 System.out.println("Current day of the month is: " + localDate.getDayOfMonth());
		 System.out.println("Current month: " + localDate.getMonthValue());
		 System.out.println("Current day: " + localDate.getDayOfWeek()); 
	}
	
	public void addAndSubtractDate() {
		LocalDate localDate = LocalDate.now();
		System.out.println("LOCAL DATE ADD AND SUBTRACT DATES");
		System.out.println("---------------------");
		
		System.out.println("Today is: " + localDate);
		System.out.println("Yesterday was: " + localDate.minusDays(1));
		//localDate = localDate.minusDays(1);
		System.out.println("Today is after subtraction (Immutable): " + localDate);
		System.out.println("Tommorow is: " + localDate.plus(1,ChronoUnit.DAYS));
		System.out.println("After one month it will be: " + localDate.plus(1,ChronoUnit.MONTHS));
		
	}
	
	public void parseDate() {
		System.out.println("LOCAL DATE PARSE DATE");
		System.out.println("---------------------");
		LocalDate christmasNumeric = LocalDate.of(LocalDate.now().getYear(), 12, 25);
		System.out.println("The day of christmas for " + christmasNumeric.getYear() + " will be " +christmasNumeric.getDayOfWeek());
		LocalDate theBestDayOfAugustEnum = LocalDate.of(LocalDate.now().getYear(), Month.AUGUST, 15);
		LocalDate theBestDayOfAugustParser = LocalDate.parse(LocalDate.now().getYear()+"-08-15");
		System.out.println("The day of August 15 for " + theBestDayOfAugustParser.plus(1, ChronoUnit.YEARS).getYear() + " will be " +theBestDayOfAugustParser.plus(1, ChronoUnit.YEARS).getDayOfWeek());
	}
	
	public void compareDate() {
		System.out.println("LOCAL DATE COMPARE DATES");
		System.out.println("---------------------");
		
		LocalDate localDateToday = LocalDate.now();
		LocalDate localDateYesterday = LocalDate.now().minusDays(1);
		
		System.out.println("Is "+localDateToday +" before "+ localDateYesterday+"? "+localDateToday.isBefore(localDateYesterday));
	}
}
