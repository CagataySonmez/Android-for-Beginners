package org.arcelik.proxy;

public class ChannelListProxy implements ChannelList {
	private ChannelListImpl channelListImpl;
	
	@Override
	public synchronized void getChannelList() {
		if(channelListImpl == null){
			channelListImpl = new ChannelListImpl();
	      }
		channelListImpl.getChannelList();
	}
}
