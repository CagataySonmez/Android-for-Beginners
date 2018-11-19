package org.arcelik.mediator;

public abstract class Connection {
	protected ConnectionMediator mediator;
	protected String connectionInterface;
	
	public Connection(ConnectionMediator mediator, String connectionInterface) {
		this.mediator = mediator;
		this.connectionInterface = connectionInterface;
	}
	
	public abstract void send(String msg);
	
	public abstract void receive(String msg);
}
