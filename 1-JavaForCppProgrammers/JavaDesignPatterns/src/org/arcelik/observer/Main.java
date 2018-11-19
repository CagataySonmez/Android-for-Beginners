package org.arcelik.observer;

public class Main {

	public static void main(String[] args) {
		InternetObservable subject = new InternetObservable();

		new MenuObserver(subject);
		new HbbtvObserver(subject);
		new AppstoreObserver(subject);

		subject.setState(true);
		System.out.println("-------------");	
		subject.setState(false);
	}

}
