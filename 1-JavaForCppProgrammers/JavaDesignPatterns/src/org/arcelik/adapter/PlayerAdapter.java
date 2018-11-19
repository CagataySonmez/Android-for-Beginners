package org.arcelik.adapter;

public class PlayerAdapter implements AudioPlayer {
	Decoder decoder = null;
	
	public PlayerAdapter(String format) {
		if(format == "mp3")
			decoder = new Mp3Decoder();
		else if(format == "wav")
			decoder = new WavDecoder();
	}

	@Override
	public void play() {
		if(decoder != null)
			decoder.playMusic();
		else
			System.out.println("Unknow music format!");	
	}
}