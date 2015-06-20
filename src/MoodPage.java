import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MoodPage extends JPanel {

	static JFrame frame1;
	private JButton btn1, btn2;
	private JLabel label1, label2;
	public static MP3 mp3;
	private ArrayList<String> emotions = new ArrayList<String>();
	private ArrayList<Integer> emotionsChosen;
	private ArrayList<Integer> songsToPlay = new ArrayList<Integer>();
	private ArrayList<ArrayList<Integer>> listOfAllSongsWithEmotions = new ArrayList<ArrayList<Integer>>();
	private JDBC db;
	private ArrayList<String> songTitles;
	private ArrayList<JButton> songButtons = new ArrayList<JButton>();
	private boolean songPlaying = false;
	private ArrayList<Boolean> thisSongPlaying = new ArrayList<Boolean>();

	public MoodPage(ArrayList<Integer> emotionsChosen) {
		super();

		this.emotionsChosen = emotionsChosen;

		emotions.add("Happy");
		emotions.add("Sad");
		emotions.add("Mad");
		emotions.add("Free");
		emotions.add("Confused");
		emotions.add("Frustrated");
		emotions.add("Regretful");
		emotions.add("Nostalgic");
		emotions.add("Betrayed");
		emotions.add("Lonely");
		emotions.add("Empowered");
		emotions.add("Afraid");
		emotions.add("Vengeful");
		emotions.add("Sarcastic");
		emotions.add("Social");
		emotions.add("Hopeful");
		emotions.add("Desperate");
		emotions.add("Foolish");
		emotions.add("Amazed");
		emotions.add("Brave");

		FlowLayout experimentLayout = new FlowLayout();
		this.setLayout(experimentLayout);

		// set up label
		label1 = new JLabel("Please enjoy your SwiftList based on your mood!");
		label1.setBounds(275, 15, 700, 50);
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

		btn2 = new JButton("PLAY MY SWIFTLIST!");
		buttonWidth = 200;
		btn2.setBounds(390, 90, buttonWidth, buttonHeight);
		btn2.setBackground(new Color(206, 184, 95));
		btn2.setOpaque(true);
		btn2.setBorder(null);
		this.add(btn2);

		try {
			MapEmotionsToSongs();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

		// set up button action
		ButtonResponder br = new ButtonResponder();
		btn1.addActionListener(br);
		btn2.addActionListener(br);
		// for (int i = 0; i < songsToPlay.size(); i++) {
		// songButtons.get(i).addActionListener(br);
		// }
		//
		// for (int i = 0; i < songsToPlay.size(); i++) {
		// thisSongPlaying.add(false);
		// }

	}

	public ArrayList<String> getSongTitles() {
		db = new JDBC();
		ArrayList<String> temp = new ArrayList<String>();
		for (int i = 0; i < songsToPlay.size(); i++) {
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

	private void createSongButtons() throws SQLException {
		int buttonHeight = 25;
		int buttonWidth = 300;
		int x = 340;
		int y = 160;
		JButton temp = new JButton();
		for (int i = 0; i < songsToPlay.size(); i++) {
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

	private void repaintButtons() {
		for (int i = 0; i < songButtons.size(); i++) {
			songButtons.get(i).setBackground(new Color(50, 184, 95));
		}
	}

	private void unclickAllButtons(int index) {
		for (int i = 0; i < 13; i++) {
			if (i != index)
				thisSongPlaying.set(i, false);
		}
		repaintButtons();
	}

	public class ButtonResponder implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btn1) {

				GUI home = new GUI();
				home.setVisible(true);
				home.main(null);
				CloseFrame();
				// try {
				// mp3.close();
				// } catch (IOException e1) {
				// // TODO Auto-generated catch block
				// e1.printStackTrace();
				// }
			} else if (e.getSource() == btn2) {
				// eventually need to figure out how to loop music
				// ArrayList<Integer> songsToPlay = new ArrayList<Integer>();
				// songsToPlay.add(1);
				// songsToPlay.add(2);
				// if (b2 == false) {
				// b2 = true;
				// mp3 = new MP3();
				// for (int i = 0; i < songsToPlay.size(); i++) {
				// mp3.play("music/" + songsToPlay.get(i) + ".mp3");
				// synchronized (mp3) {
				// try {
				// mp3.wait(1000);
				// } catch (InterruptedException e2) {
				// // TODO Auto-generated catch block
				// e2.printStackTrace();
				// }
				// }
				// }
				// } else {
				// b2 = false;
				// try {
				// mp3.close();
				// } catch (IOException e1) {
				// // TODO Auto-generated catch block
				// e1.printStackTrace();
				// }
				// }

				// } else {
				// for (int i = 0; i < songsToPlay.size(); i++) {
				// if (e.getSource() == songButtons.get(i)) {
				// if (songPlaying == true) {
				// try {
				// mp3.close();
				// } catch (IOException e1) {
				// e1.printStackTrace();
				// }
				// unclickAllButtons(i);
				// songPlaying = false;
				// }
				// if (thisSongPlaying.get(i) == false) {
				// songButtons.get(i).setBackground(
				// new Color(206, 184, 95));
				// System.out.println(i);
				// System.out.println(songsToPlay.size());
				// mp3.play("music/" + songsToPlay.get(i) + ".mp3");
				// System.out.println("hello");
				// thisSongPlaying.set(i, true);
				// songPlaying = true;
				// } else {
				// songButtons.get(i).setBackground(
				// new Color(50, 184, 95));
				// try {
				// mp3.close();
				// } catch (IOException e1) {
				// e1.printStackTrace();
				// }
				// thisSongPlaying.set(i, false);
				// }
				// }
				// }
			}

			repaint();

		}

	}

	private ArrayList<Integer> findSongsWithEmotion(int emotionId) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		JDBC db = new JDBC();
		String emotion = emotions.get(emotionId - 1);
		ResultSet rs = db.executeQuery("SELECT SId FROM Moods WHERE " + emotion
				+ " = 1");

		try {
			while (rs.next() == true) {
				result.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	private void CloseFrame() {
		frame1.dispose();
	}

	private void MapEmotionsToSongs() throws SQLException {
		// create list of all the songs that match the emotions
		int size = 0;
		boolean noSongsLeft = false;
		if (emotionsChosen.size() <= 13)
			size = emotionsChosen.size();
		else
			size = 13;
		for (int i = 0; i < size; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list = findSongsWithEmotion(emotionsChosen.get(i));
			listOfAllSongsWithEmotions.add(list);
		}

		while ((songsToPlay.size() < 13) && (noSongsLeft == false)) {
			int count = 0;
			boolean shouldAdd;
			for (int i = 0; i < listOfAllSongsWithEmotions.size(); i++) {
				int s = listOfAllSongsWithEmotions.get(i).size();
				int temp = (int) ((s - 1) * Math.random());
				// check to make sure song isn't already added
				shouldAdd = !songsToPlay.contains(listOfAllSongsWithEmotions
						.get(i).get(temp));
				if (shouldAdd == true) {
					songsToPlay
							.add(listOfAllSongsWithEmotions.get(i).get(temp));
					listOfAllSongsWithEmotions.get(i).remove(temp);
				}
				if (shouldAdd == false) {
					count++;
					listOfAllSongsWithEmotions.get(i).remove(temp);
				}
				if (listOfAllSongsWithEmotions.get(i).size() == 0) {
					listOfAllSongsWithEmotions.remove(i);
				}
				if ((listOfAllSongsWithEmotions.size() == 0) || count == 13) {
					noSongsLeft = true;
				}
			}
		}

	}

	public void main(String[] args) throws IOException, SQLException {

		frame1 = new JFrame("SwiftList");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.add(new MoodPage(emotionsChosen));
		frame1.setBounds(300, 500, 1000, 700);
		frame1.setBackground(new Color(100, 0, 60));
		frame1.setLocationRelativeTo(null);
		frame1.setVisible(true);
		frame1.setResizable(true);

	}

}