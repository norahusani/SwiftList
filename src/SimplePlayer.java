import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class SimplePlayer {

	public SimplePlayer() {

		try {

			FileInputStream fis = new FileInputStream("/desktop/LoveStory.mp3");
			Player playMP3 = new Player(fis);

			playMP3.play();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
