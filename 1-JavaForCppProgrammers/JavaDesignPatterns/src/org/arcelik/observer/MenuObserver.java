package org.arcelik.observer;

public class MenuObserver extends Observer{
	
	public MenuObserver(InternetObservable observable) {
		super(observable);
		observable.addObserver(this);
	}
	
	@Override
	public void update() {
		String status = observable.getState() == true ? "established" : "lost";
		System.out.println("Internet connection is " + status + "! Update TV Menu.");
	}
}
