package org.arcelik.proxy;

public class ChannelListImpl implements ChannelList {

	public ChannelListImpl(){
		loadChannelListFromDisk();
	}
	
	@Override
	public void getChannelList() {
		System.out.println("Getting channel list...");
	}

	public void loadChannelListFromDisk() {
		System.out.println("Loading channel list from disk...");
	}
}
