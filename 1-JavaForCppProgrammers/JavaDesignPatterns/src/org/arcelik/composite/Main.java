package org.arcelik.composite;

public class Main {

	public static void main(String[] args) {
		Setting cs = new ChannelSetting();
		Setting us = new UserSetting();
		Setting as = new AppSetting();
		
		CompositeSetting composite = new CompositeSetting();
		composite.add(cs);
		composite.add(us);
		composite.add(as);
		composite.reset();
		
		composite.clear();
		
		composite.add(cs);
		composite.add(us);
		composite.reset();
	}

}
