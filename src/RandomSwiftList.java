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
	private JButton btn1, btn2;
	private JLabel label1, label2;
	public ArrayList<JButton> songButtons = new ArrayList<JButton>();
	private ArrayList<String> songTitles;
	public ArrayList<Integer> ids = new ArrayList<Integer>();
	private JDBC db;
	public static MP3 mp3 = new MP3();
	boolean b2 = false;
	boolean song1 = false, song2 = false, song3 = false, song4 = false,
			song5 = false, song6 = false, song7 = false, song8 = false,
			song9 = false, song10 = false, song11 = false, song12 = false,
			song13 = false;
	private ArrayList<String> result;
	private boolean songPlaying = false;

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

	private void repaintButtons() {
		for (int i = 0; i < songButtons.size(); i++) {
			songButtons.get(i).setBackground(new Color(50, 184, 95));
		}
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
				if (songPlaying == true) {
					try {
						mp3.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					repaintButtons();
					songPlaying = false;
				}
				if (song1 == false) {
					songButtons.get(0).setBackground(new Color(206, 184, 95));
					mp3.play("music/" + ids.get(0) + ".mp3");
					song1 = true;
					songPlaying = true;
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
			} else if (e.getSource() == songButtons.get(1)) {
				if (songPlaying == true) {
					try {
						mp3.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					repaintButtons();
					songPlaying = false;
				}
				if (song2 == false) {
					songButtons.get(1).setBackground(new Color(206, 184, 95));
					mp3.play("music/" + ids.get(1) + ".mp3");
					song2 = true;
					songPlaying = true;
				} else {
					songButtons.get(1).setBackground(new Color(50, 184, 95));
					try {
						mp3.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					song2 = false;
				}
			} else if (e.getSource() == songButtons.get(2)) {
				if (songPlaying == true) {
					try {
						mp3.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					repaintButtons();
					songPlaying = false;
				}
				if (song3 == false) {
					songButtons.get(2).setBackground(new Color(206, 184, 95));
					mp3.play("music/" + ids.get(2) + ".mp3");
					song3 = true;
					songPlaying = true;
				} else {
					songButtons.get(2).setBackground(new Color(50, 184, 95));
					try {
						mp3.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					song3 = false;
				}
			}

			else if (e.getSource() == songButtons.get(3)) {
				if (songPlaying == true) {
					try {
						mp3.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					repaintButtons();
					songPlaying = false;
				}
				if (song4 == false) {
					songButtons.get(3).setBackground(new Color(206, 184, 95));
					mp3.play("music/" + ids.get(3) + ".mp3");
					song4 = true;
					songPlaying = true;
				} else {
					songButtons.get(3).setBackground(new Color(50, 184, 95));
					try {
						mp3.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					song4 = false;
				}
			}

			else if (e.getSource() == songButtons.get(4)) {
				if (songPlaying == true) {
					try {
						mp3.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					repaintButtons();
					songPlaying = false;
				}
				if (song5 == false) {
					songButtons.get(4).setBackground(new Color(206, 184, 95));
					mp3.play("music/" + ids.get(4) + ".mp3");
					song5 = true;
					songPlaying = true;
				} else {
					songButtons.get(4).setBackground(new Color(50, 184, 95));
					try {
						mp3.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					song5 = false;
				}
			}

			else if (e.getSource() == songButtons.get(5)) {
				if (songPlaying == true) {
					try {
						mp3.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					repaintButtons();
					songPlaying = false;
				}
				if (song6 == false) {
					songButtons.get(5).setBackground(new Color(206, 184, 95));
					mp3.play("music/" + ids.get(5) + ".mp3");
					song6 = true;
					songPlaying = true;
				} else {
					songButtons.get(5).setBackground(new Color(50, 184, 95));
					try {
						mp3.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					song6 = false;
				}
			}

			else if (e.getSource() == songButtons.get(6)) {
				if (songPlaying == true) {
					try {
						mp3.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					repaintButtons();
					songPlaying = false;
				}
				if (song7 == false) {
					songButtons.get(6).setBackground(new Color(206, 184, 95));
					mp3.play("music/" + ids.get(6) + ".mp3");
					song7 = true;
					songPlaying = true;
				} else {
					songButtons.get(6).setBackground(new Color(50, 184, 95));
					try {
						mp3.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					song7 = false;
				}
			}

			else if (e.getSource() == songButtons.get(7)) {
				if (songPlaying == true) {
					try {
						mp3.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					repaintButtons();
					songPlaying = false;
				}
				if (song8 == false) {
					songButtons.get(7).setBackground(new Color(206, 184, 95));
					mp3.play("music/" + ids.get(7) + ".mp3");
					song8 = true;
					songPlaying = true;
				} else {
					songButtons.get(7).setBackground(new Color(50, 184, 95));
					try {
						mp3.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					song8 = false;
				}
			}

			else if (e.getSource() == songButtons.get(8)) {
				if (songPlaying == true) {
					try {
						mp3.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					repaintButtons();
					songPlaying = false;
				}
				if (song9 == false) {
					songButtons.get(8).setBackground(new Color(206, 184, 95));
					mp3.play("music/" + ids.get(8) + ".mp3");
					song9 = true;
					songPlaying = true;
				} else {
					songButtons.get(8).setBackground(new Color(50, 184, 95));
					try {
						mp3.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					song9 = false;
				}
			}

			else if (e.getSource() == songButtons.get(9)) {
				if (songPlaying == true) {
					try {
						mp3.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					repaintButtons();
					songPlaying = false;
				}
				if (song10 == false) {
					songButtons.get(9).setBackground(new Color(206, 184, 95));
					mp3.play("music/" + ids.get(9) + ".mp3");
					song10 = true;
					songPlaying = true;
				} else {
					songButtons.get(9).setBackground(new Color(50, 184, 95));
					try {
						mp3.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					song10 = false;
				}
			}

			else if (e.getSource() == songButtons.get(10)) {
				if (songPlaying == true) {
					try {
						mp3.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					repaintButtons();
					songPlaying = false;
				}
				if (song11 == false) {
					songButtons.get(10).setBackground(new Color(206, 184, 95));
					mp3.play("music/" + ids.get(10) + ".mp3");
					song11 = true;
					songPlaying = true;
				} else {
					songButtons.get(10).setBackground(new Color(50, 184, 95));
					try {
						mp3.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					song11 = false;
				}
			}

			else if (e.getSource() == songButtons.get(11)) {
				if (songPlaying == true) {
					try {
						mp3.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					repaintButtons();
					songPlaying = false;
				}
				if (song12 == false) {
					songButtons.get(11).setBackground(new Color(206, 184, 95));
					mp3.play("music/" + ids.get(11) + ".mp3");
					song12 = true;
					songPlaying = true;
				} else {
					songButtons.get(11).setBackground(new Color(50, 184, 95));
					try {
						mp3.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					song12 = false;
				}
			}

			else if (e.getSource() == songButtons.get(12)) {
				if (songPlaying == true) {
					try {
						mp3.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					repaintButtons();
					songPlaying = false;
				}
				if (song13 == false) {
					songButtons.get(12).setBackground(new Color(206, 184, 95));
					mp3.play("music/" + ids.get(12) + ".mp3");
					song13 = true;
					songPlaying = true;
				} else {
					songButtons.get(12).setBackground(new Color(50, 184, 95));
					try {
						mp3.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					song13 = false;
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