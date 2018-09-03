package com.javainuse;

public class JavaAnonymousClass {

	public static void main(String[] args) {
		Greetings greetingsInstance = new Greetings() {
			
			public void sayHello(String name) {
				System.out.println("Hello World " + name);
			}
		};
		greet(greetingsInstance, "Tom");
	}

	private static void greet(Greetings greetingsInstance, String name) {
		greetingsInstance.sayHello(name);
	}

}
