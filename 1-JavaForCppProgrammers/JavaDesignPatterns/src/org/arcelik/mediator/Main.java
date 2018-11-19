package org.arcelik.mediator;

public class Main {
	
	public static void main(String[] args) {
		ConnectionMediator mediator = new ConnectionMediator();
		Connection wlan0Connection = new WlanConnection(mediator, "wlan0");
		Connection eth0Connection = new EthernetConnection(mediator, "eth0");
		Connection eth1Connection = new EthernetConnection(mediator, "eth1");
		
		mediator.addConnection(wlan0Connection);
		mediator.addConnection(eth0Connection);
		mediator.addConnection(eth1Connection);

		eth0Connection.send("Ethernet cable is unplugged!");
		eth1Connection.send("IP address is obtained!");
		wlan0Connection.send("WiFi signal is unstable!");
	}
}
