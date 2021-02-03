package org.arcelik.builder;

public class Main {

	public static void main(String[] args) {
		App youtube = new App.Builder().
				name("YouTube").
				shortDesc("Official YouTube app").
				rate(5).
				build();
		
		System.out.println(youtube);
		
		System.out.println("---------------------");
		
		App puhu = new App.Builder().
				name("Puhu TV").
				locale("TR").
				build();

		System.out.println(puhu);

	}

}
