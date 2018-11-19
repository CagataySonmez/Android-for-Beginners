package org.arcelik.observer;

public class HbbtvObserver extends Observer{
	
	public HbbtvObserver(InternetObservable observable) {
		super(observable);
		observable.addObserver(this);
	}

	@Override
	public void update() {
		String status = observable.getState() == true ? "established" : "lost";
		System.out.println("Internet connection is " + status + "! Reinit Hbbtv.");
	}
}