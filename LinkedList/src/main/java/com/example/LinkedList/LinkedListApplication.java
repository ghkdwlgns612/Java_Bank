package com.example.LinkedList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LinkedListApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkedListApplication.class, args);
		LinkedList numbers = new LinkedList();
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		LinkedList.ListIterator li = numbers.listIterator();
		System.out.println(li.next());
		System.out.println(li.next());
		System.out.println(li.next());
	}

}
