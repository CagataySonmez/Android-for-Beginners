package org.arcelik.iterator;

public class Main {

	public static void main(String[] args) {
		ChannelList channels = new ChannelListImpl();
		channels.addChannel(new Channel("TRT 1"));
		channels.addChannel(new Channel("TRT 2"));
		channels.addChannel(new Channel("TRT 3"));
		channels.addChannel(new Channel("TRT 4"));
		
		ChannelIterator baseIterator = channels.iterator();
		while (baseIterator.hasNext()) {
			Channel c = baseIterator.next();
			System.out.println(c.toString());
		}
	}

}
