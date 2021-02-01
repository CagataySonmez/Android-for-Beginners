package org.arcelik.adapter;

public class Main {

	public static void main(String[] args) {
		
		AudioPlayer mp3Player = new Mp3Player();
		mp3Player.play();

		AudioPlayer wavPlayer = new WavPlayer();
		wavPlayer.play();

		LegacyPlayer legacyPlayer = new LegacyPlayer();
		AudioPlayer legacyPlayerAdapter = new LegacyPlayerAdapter(legacyPlayer);
		legacyPlayerAdapter.play();
	}
}
