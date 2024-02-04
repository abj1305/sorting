package com.practice.play;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test1 {

	public static void print (Greeting greetint) {
		greetint.greet();
	}
	
	public static void main(String[] args) {
		System.out.format("%.3f is my favourite no", 3.1238);
		print(() -> System.out.println("Hello"));
		Greeting.method2();
		Greeting g = new GreetingChild();
		g.method1();
		
		System.out.println(-12%5);
		
		Employee e1 = new Employee(1, 20, "Employee1");
		Employee e2 = new Employee(2, 30, "Employee2");
		Employee e3 = new Employee(3, 40, "Employee3");
		Employee e4 = new Employee(4, 40, "Employee4");
		Employee e5 = new Employee(5, 40, "Employee5");
		
		List<Employee> list = new ArrayList<Employee>();
		
		list.add(e3);
		list.add(e5);
		list.add(e2);
		list.add(e1);
		list.add(e4);
		
		System.out.println(list);
		
		List<Employee> sortedList = list.stream()
					.sorted(Comparator.comparing(Employee::getAge).thenComparing(Employee::getName).reversed())
					.collect(Collectors.toList());
		
		System.out.println(sortedList);
		
		
		List<String> list2 = List.of("India", "Japan", "US", "UK", "Sri Lanka");
	
		Map<Integer, List<String>> map = list2.stream().collect(Collectors.groupingBy(String :: length));
		System.out.println(map);
	}

}

class Employee {
	
	private int id;
	private int age;
	private String name;
	
	public Employee(int id, int age, String name) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", age=" + age + ", name=" + name + "]";
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
