	package com.cb.unit1;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TimeZone;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class UnitExercise {

	public static void main(String[] args) {
	
		List<Person> people = Arrays.asList(new Person("Charles", "Dicken", 60), 
											new Person("Lewis", "Carrol", 42), 
											new Person("Thomas", "Carlyle", 51), 
											new Person("Charlotte", "Bronte", 45), 
											new Person("Mathew", "Arnold", 39));
		
		/*//Step 1: Sort list by last name
		Collections.sort(people, (p1, p2) -> p1.getlName().compareToIgnoreCase(p2.getlName()));			
		
		//Step 2: Print the sorted list		
		System.out.println("Printing all names");
		printConditionally(people, p -> true, p -> System.out.println(p.getfName()+" "+p.getlName()+" "+p.getAge()));
		
		//Step 3: Create a method that prints all people that have last name starts with 'c'
		System.out.println("\nPrinting names starts with C");
		printConditionally(people, p -> p.getlName().startsWith("C"), p -> System.out.println(p.getfName()+" "+p.getlName()+" "+p.getAge()));
		*/
		/*
		 people.stream()
				.filter(p -> p.getlName().startsWith("C"))
				.forEach(c -> System.out.println(c.getlName()));
		System.out.println("x");*/
		
		
//		Stream.of("a1", "b1", "c1", "d1").anyMatch(s -> { return s.startsWith("a");});
		TimeZone t = TimeZone.getTimeZone("IST");
		System.out.println(t);
	}
	
	
	
	private static void printConditionally(List<Person> people, Predicate<Person> con, Consumer<Person> consumer) {
		
		for(Person p: people) {
		if(con.test(p)) {
			consumer.accept(p);
			}
		}
	}
}

/*
interface Condition {
	public boolean test(Person p);
}

interface SortList {
	public List<Person> sort(List<Person> l);
}

interface PrintList {
	public void print(List<Person> l);
}*/