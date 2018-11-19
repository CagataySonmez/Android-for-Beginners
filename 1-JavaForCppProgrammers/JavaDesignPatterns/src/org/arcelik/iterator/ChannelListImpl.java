package org.arcelik.iterator;

import java.util.ArrayList;
import java.util.List;

public class ChannelListImpl implements ChannelList {
	private List<Channel> channelList;

	public ChannelListImpl() {
		channelList = new ArrayList<>();
	}

	public void addChannel(Channel c) {
		this.channelList.add(c);
	}

	public void removeChannel(Channel c) {
		this.channelList.remove(c);
	}

	public ChannelIterator iterator() {
		return new ChannelIteratorImpl(this.channelList);
	}

	private class ChannelIteratorImpl implements ChannelIterator {

		private List<Channel> channels;
		private int position;

		public ChannelIteratorImpl(List<Channel> channelsList) {
			this.channels = channelsList;
		}

		@Override
		public boolean hasNext() {
			if(position >= channels.size())
				return false;
			else
				return true;
		}

		@Override
		public Channel next() {
			Channel c = channels.get(position);
			position++;
			return c;
		}

	}
}
