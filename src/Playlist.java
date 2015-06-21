import jaco.mp3.player.MP3Player;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Playlist extends JPanel {

	private static ArrayList<Integer> songsToPlay;
	private JButton btn1, btn2, btn3, btn4, btn5, btn6;
	private JLabel label1, label2;
	JFrame frame;
	MP3Player player;
	private ArrayList<JButton> songButtons = new ArrayList<JButton>();
	private ArrayList<String> songTitles;
	private JDBC db;
	int currentSong;

	public Playlist(ArrayList<Integer> songsToPlay) {

		super();

		this.songsToPlay = songsToPlay;
		currentSong = 0;

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

		btn2 = new JButton("PLAY");
		buttonHeight = 50;
		buttonWidth = 75;
		btn2.setBounds(260, 100, buttonWidth, buttonHeight);
		btn2.setBackground(new Color(206, 184, 95));
		btn2.setOpaque(true);
		btn2.setBorder(null);
		this.add(btn2);

		btn3 = new JButton("STOP");
		buttonHeight = 50;
		buttonWidth = 75;
		btn3.setBounds(360, 100, buttonWidth, buttonHeight);
		btn3.setBackground(new Color(206, 184, 95));
		btn3.setOpaque(true);
		btn3.setBorder(null);
		this.add(btn3);

		btn4 = new JButton("PAUSE");
		buttonHeight = 50;
		buttonWidth = 75;
		btn4.setBounds(460, 100, buttonWidth, buttonHeight);
		btn4.setBackground(new Color(206, 184, 95));
		btn4.setOpaque(true);
		btn4.setBorder(null);
		this.add(btn4);

		btn5 = new JButton("NEXT");
		buttonHeight = 50;
		buttonWidth = 75;
		btn5.setBounds(560, 100, buttonWidth, buttonHeight);
		btn5.setBackground(new Color(206, 184, 95));
		btn5.setOpaque(true);
		btn5.setBorder(null);
		this.add(btn5);

		btn6 = new JButton("PREVIOUS");
		buttonHeight = 50;
		buttonWidth = 75;
		btn6.setBounds(660, 100, buttonWidth, buttonHeight);
		btn6.setBackground(new Color(206, 184, 95));
		btn6.setOpaque(true);
		btn6.setBorder(null);
		this.add(btn6);

		songTitles = getSongTitles();
		try {
			createSongButtons();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// size of frame
		setSize(300, 300);
		setVisible(true);
		setLayout(new BorderLayout());

		player = new MP3Player();
		player.setRepeat(true);
		for (int i = 0; i < songsToPlay.size(); i++) {
			player.addToPlayList(new File("resources/music/"
					+ songsToPlay.get(i) + ".mp3"));
		}

		ButtonResponder br = new ButtonResponder();
		btn1.addActionListener(br);
		btn2.addActionListener(br);
		btn3.addActionListener(br);
		btn4.addActionListener(br);
		btn5.addActionListener(br);
		btn6.addActionListener(br);
		songButtons.get(0).addActionListener(br);
		songButtons.get(1).addActionListener(br);
		songButtons.get(2).addActionListener(br);
		songButtons.get(3).addActionListener(br);
		songButtons.get(4).addActionListener(br);
		songButtons.get(5).addActionListener(br);
		songButtons.get(6).addActionListener(br);
		songButtons.get(7).addActionListener(br);
		songButtons.get(8).addActionListener(br);
		songButtons.get(9).addActionListener(br);
		songButtons.get(10).addActionListener(br);
		songButtons.get(11).addActionListener(br);
		songButtons.get(12).addActionListener(br);

		// player.setBorder(BorderFactory.createEmptyBorder(100, 100, 50, 100));
		// frame = new JFrame("SwiftList");
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setBounds(300, 500, 1000, 700);
		// frame.setBackground(new Color(100, 0, 60));
		// // frame.getContentPane().add(player);
		// frame.setLocationRelativeTo(null);
		// frame.setVisible(true);

	}

	private void createSongButtons() throws SQLException {
		int buttonHeight = 25;
		int buttonWidth = 300;
		int x = 340;
		int y = 160;
		JButton temp = new JButton();
		for (int i = 0; i < 13; i++) {
			temp = new JButton("Track " + (i + 1) + ": " + songTitles.get(i));
			temp.setBounds(x, y, buttonWidth, buttonHeight);
			temp.setBackground(new Color(50, 184, 95));
			temp.setOpaque(true);
			temp.setBorder(null);
			songButtons.add(temp);
			this.add(songButtons.get(i));
			y += 40;
		}
	}

	public ArrayList<String> getSongTitles() {
		db = new JDBC();
		ArrayList<String> temp = new ArrayList<String>();
		for (int i = 0; i < 13; i++) {
			ResultSet rs = null;
			rs = db.getSongTitleById(songsToPlay.get(i));
			try {
				temp.add(rs.getString(1));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return temp;
	}

	public class ButtonResponder implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			// home
			if (e.getSource() == btn1) {
				if (!(player.isPaused() || player.isStopped())) {
					player.stop();
				}
				RandomSwiftList rand;
				GUI home = new GUI();
				home.setVisible(true);
				home.main(null);
				CloseFrame();
			}

			// play
			if (e.getSource() == btn2) {
				player.play();
			}

			// stop
			if (e.getSource() == btn3) {
				player.stop();
			}
			// pause
			if (e.getSource() == btn4) {
				player.pause();
			}
			// next
			if (e.getSource() == btn5) {
				player.skipForward();
				if (currentSong < 13)
					currentSong++;
				else
					currentSong = 0;
			}
			// previous
			if (e.getSource() == btn6) {
				player.skipBackward();
				if (currentSong > 0)
					currentSong--;
				else
					currentSong = 13;
			}

			repaintButtons();
			songButtons.get(currentSong).setBackground(new Color(206, 184, 95));

			repaint();

		}

	}

	private void repaintButtons() {
		for (int i = 0; i < songButtons.size(); i++) {
			songButtons.get(i).setBackground(new Color(50, 184, 95));
		}
	}

	private void CloseFrame() {
		frame.dispose();
	}

	public static void main(String[] args) {

		// new Playlist(songs);
		JFrame frame = new JFrame("SwiftList");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(300, 500, 1000, 700);
		frame.setBackground(new Color(100, 0, 60));
		frame.add(new Playlist(songsToPlay));
		// frame.getContentPane().add(player);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}
