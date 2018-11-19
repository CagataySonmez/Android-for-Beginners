package org.arcelik.iterator;

public class Channel {
	private String name;
	
	public Channel(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString(){
		return "Channel Name = " + name;
	}
}
