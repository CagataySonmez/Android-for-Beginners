package org.arcelik.singleton;

public class Main {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
	}
}
