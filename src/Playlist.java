import jaco.mp3.player.MP3Player;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Playlist extends JPanel {

	private static ArrayList<Integer> songsToPlay;
	private JButton btn1, btn2;
	private JLabel label1, label2;

	public Playlist(ArrayList<Integer> songsToPlay) {

		super();

		FlowLayout experimentLayout = new FlowLayout();
		this.setLayout(experimentLayout);

		// set up label
		label1 = new JLabel("Please enjoy your random SwiftList!");
		label1.setBounds(325, 15, 700, 50);
		label1.setFont(label1.getFont().deriveFont(20f));
		this.add(label1);

		label2 = new JLabel("(13 songs of course!)");
		label2.setBounds(410, 45, 700, 50);
		label2.setFont(label2.getFont().deriveFont(16f));
		this.add(label2);

		// set up the buttons
		btn1 = new JButton("HOME");
		int buttonHeight = 50;
		int buttonWidth = 200;
		btn1.setBounds(25, 15, buttonWidth, buttonHeight);
		btn1.setBackground(new Color(206, 184, 95));
		btn1.setOpaque(true);
		btn1.setBorder(null);
		this.add(btn1);

		// size of frame
		setSize(300, 300);
		setVisible(true);
		setLayout(new BorderLayout());

		this.songsToPlay = songsToPlay;
		MP3Player player = new MP3Player();
		player.setRepeat(true);
		for (int i = 0; i < songsToPlay.size(); i++) {
			player.addToPlayList(new File("resources/music/"
					+ songsToPlay.get(i) + ".mp3"));
		}
		player.setBorder(BorderFactory.createEmptyBorder(100, 100, 50, 100));
		JFrame frame = new JFrame("SwiftList");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(300, 500, 1000, 700);
		frame.setBackground(new Color(100, 0, 60));
		frame.getContentPane().add(player);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	public static void main(String[] args) {

		ArrayList<Integer> songs = new ArrayList<Integer>();
		for (int i = 0; i < 13; i++) {
			songs.add(i + 1);
		}
		new Playlist(songs);

	}

}
