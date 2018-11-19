package org.arcelik.iterator;

public interface ChannelList {
	public void addChannel(Channel c);
	
	public void removeChannel(Channel c);
	
	public ChannelIterator iterator();
}
