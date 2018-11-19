package org.arcelik.composite;

public class UserSetting implements Setting{

	@Override
	public void reset() {
		System.out.println("UserSettings is being reset");
	}

}