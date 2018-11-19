package org.arcelik.factory;

public class PlayerFactory {
	public static Player getPlayer(String format) {
		Player p = null;
		if(format == "mp3")
			p = new Mp3Player();
		else if(format == "wav")
			p = new WavPlayer();
		
		return p;
	}
}