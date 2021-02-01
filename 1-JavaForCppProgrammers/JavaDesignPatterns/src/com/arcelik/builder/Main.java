package com.arcelik.builder;

public class Main {

	public static void main(String[] args) {
		Application youtube = new Application.ApplicationBuilder().
				name("YouTube").shortDesc("Official YouTube app").rate(5).build();
		
		System.out.println(youtube);
		
		System.out.println("---------------------");
		
		Application puhu = new Application.ApplicationBuilder().
				name("Puhu TV").locale("TR").build();

		System.out.println(puhu);

	}

}
