package com.javainuse;

public class JavaLambda {

	public static void main(String[] args) {
		
		//(String param)->{System.out.println("My Name is "+param);};
		Greetings greetingsInstance=n -> System.out.println("My name is " + n);
		greet(greetingsInstance, "Tom");
	}

	private static void greet(Greetings greetingsInstance, String name) {
		greetingsInstance.sayHello(name);
	}

}
