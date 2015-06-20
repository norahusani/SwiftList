import jaco.mp3.player.MP3Player;

import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

public class Playlist {

	private static ArrayList<Integer> songsToPlay;

	public Playlist(ArrayList<Integer> songsToPlay) {

		this.songsToPlay = songsToPlay;
	}

	public static void main(String[] args) {

		// MP3Player.setDefaultUI(MP3PlayerUICompact.class);

		//

		MP3Player player = new MP3Player();

		player.setRepeat(true);

		for (int i = 0; i < songsToPlay.size(); i++) {
			player.addToPlayList(new File("resources/music/"
					+ songsToPlay.get(i) + ".mp3"));
		}

		//

		player.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));

		JFrame frame = new JFrame("MP3 Player");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(player);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
