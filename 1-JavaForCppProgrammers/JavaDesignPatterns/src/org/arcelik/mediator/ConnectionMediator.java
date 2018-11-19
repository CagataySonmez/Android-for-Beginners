package org.arcelik.mediator;

import java.util.ArrayList;
import java.util.List;

public class ConnectionMediator {
	private List<Connection> connections;
	
	public ConnectionMediator(){
		this.connections=new ArrayList<Connection>();
	}
	
	public void addConnection(Connection connection){
		this.connections.add(connection);
	}

	public void broadcastMessage(String msg, String connectionInterface) {
		for(Connection c : this.connections){
			if(c.connectionInterface.equals(connectionInterface) == false)
				c.receive(msg);
		}
		System.out.println("-----------------------------");
	}
}
