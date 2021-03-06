package org.arcelik.mediator;

public class EthernetConnection extends Connection {

	public EthernetConnection(ConnectionMediator mediator, String connectionInterface) {
		super(mediator, connectionInterface);
	}

	@Override
	public void send(String msg) {
		//do your business logic here
		mediator.broadcastMessage(msg, connectionInterface);
	}

	@Override
	public void receive(String msg) {
		//do your business logic here
		System.out.println("[" + connectionInterface + "] Event received: "+msg);
	}
}
