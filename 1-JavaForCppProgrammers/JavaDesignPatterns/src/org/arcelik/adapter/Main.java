package org.arcelik.adapter;

public class Main {

	public static void main(String[] args) {

		AudioPlayer mp3Adapter = new PlayerAdapter("mp3");
		mp3Adapter.play();

		AudioPlayer wavAdapter = new PlayerAdapter("wav");
		wavAdapter.play();
	}

}
