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

public class RandomSwiftList extends JPanel {

	static JFrame frame1;
	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
			btn10, btn11, btn12, btn13, btn14, btn15;
	private JLabel label1, label2;
	public ArrayList<JButton> songButtons = new ArrayList<JButton>();
	private ArrayList<String> songTitles;
	public ArrayList<Integer> ids = new ArrayList<Integer>();
	private JDBC db;
	public static MP3 mp3;
	boolean b2 = false;
	boolean song1 = false;
	private ArrayList<String> result;

	public RandomSwiftList() throws SQLException {
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

		// for getting the song titles
		db = new JDBC();
		ResultSet rs = null;
		rs = db.getSongTitleById(1);

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

		ids = chooseRandomSongs();
		songTitles = getSongTitles(ids);
		createSongButtons(songTitles);

		// size of frame
		setSize(300, 300);
		setVisible(true);
		setLayout(new BorderLayout());

		// set up button action
		ButtonResponder br = new ButtonResponder();
		btn1.addActionListener(br);
		btn2.addActionListener(br);
		songButtons.get(0).addActionListener(br);

	}

	private void createSongButtons(ArrayList<String> songTitles)
			throws SQLException {
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

	public ArrayList<String> getSongTitles(ArrayList<Integer> songIds) {
		db = new JDBC();
		// ResultSet rs = null;
		ArrayList<String> temp = new ArrayList<String>();
		for (int i = 0; i < 13; i++) {
			ResultSet rs = null;
			rs = db.getSongTitleById(songIds.get(i));
			try {
				System.out.println(rs.getString(1));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				temp.add(rs.getString(1));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return temp;

	}

	public ArrayList<Integer> chooseRandomSongs() {
		db = new JDBC();
		ResultSet rs = null;
		rs = db.executeQuery("SELECT COUNT(Id) FROM Songs");
		ArrayList<Integer> result = new ArrayList<Integer>();
		int numOfSongs = 0;
		try {
			numOfSongs = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(numOfSongs);
		int total = 0;
		int temp;
		while (total < 13) {
			temp = (int) (numOfSongs * Math.random() + 1);
			if (!result.contains(temp)) {
				result.add(temp);
				total++;
				System.out.println(temp);
			}
		}
		System.out.println(result.size());
		return result;

	}

	public class ButtonResponder implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btn1) {

				GUI home = new GUI();
				home.setVisible(true);
				home.main(null);
				CloseFrame();
				try {
					mp3.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

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

			}

			else if (e.getSource() == songButtons.get(0)) {
				if (song1 == false) {
					songButtons.get(0).setBackground(new Color(206, 184, 95));
					mp3 = new MP3();
					mp3.play("music/" + ids.get(0) + ".mp3");
					song1 = true;
				} else {
					songButtons.get(0).setBackground(new Color(50, 184, 95));
					try {
						mp3.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					song1 = false;
				}
			}

			repaint();

		}

	}

	private void CloseFrame() {
		frame1.dispose();
	}

	public static void main(String[] args) throws IOException, SQLException {

		frame1 = new JFrame("SwiftList");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.add(new RandomSwiftList());
		frame1.setBounds(300, 500, 1000, 700);
		frame1.setBackground(new Color(100, 0, 60));
		frame1.setLocationRelativeTo(null);
		frame1.setVisible(true);
		frame1.setResizable(true);

	}

}