package org.arcelik.adapter;

public class LegacyPlayerAdapter implements AudioPlayer {
	LegacyPlayer legacyPlayer = null;
	
	public LegacyPlayerAdapter(LegacyPlayer legacyPlayer) {
		this.legacyPlayer = legacyPlayer;
	}

	@Override
	public void play() {
		legacyPlayer.init();
		legacyPlayer.playMusic();
	}
}