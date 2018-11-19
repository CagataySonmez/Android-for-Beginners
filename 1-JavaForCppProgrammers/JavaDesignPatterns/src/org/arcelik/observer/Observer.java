package org.arcelik.observer;

public abstract class Observer {
	protected InternetObservable observable;
	public Observer(InternetObservable observable){
		this.observable = observable;
	}
	
	public abstract void update();
}