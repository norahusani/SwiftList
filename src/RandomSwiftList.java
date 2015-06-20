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
	private ArrayList<JButton> songButtons = new ArrayList<JButton>();
	private ArrayList<String> songTitles;
	private ArrayList<Integer> ids = new ArrayList<Integer>();
	private JDBC db;
	private static MP3 mp3 = new MP3();
	private ArrayList<Boolean> thisSongPlaying = new ArrayList<Boolean>();
	private boolean songPlaying = false;

	public RandomSwiftList() throws SQLException {
		super();

		FlowLayout experimentLayout = new FlowLayout();
		this.setLayout(experimentLayout);

		// set all thisSongPlaying booleans to false
		for (int i = 0; i < 13; i++) {
			thisSongPlaying.add(false);
		}

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

		btn2 = new JButton("PLAY MY SWIFTLIST!");
		buttonWidth = 200;
		btn2.setBounds(390, 90, buttonWidth, buttonHeight);
		btn2.setBackground(new Color(206, 184, 95));
		btn2.setOpaque(true);
		btn2.setBorder(null);
		this.add(btn2);

		ids = chooseRandomSongs();
		songTitles = getSongTitles();
		createSongButtons();

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
			rs = db.getSongTitleById(ids.get(i));
			try {
				temp.add(rs.getString(1));
			} catch (SQLException e) {
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
			e.printStackTrace();
		}
		int total = 0;
		int temp;
		while (total < 13) {
			temp = (int) (numOfSongs * Math.random() + 1);
			if (!result.contains(temp)) {
				result.add(temp);
				total++;
			}
		}
		return result;
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
				try {
					mp3.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			} else if (e.getSource() == btn2) {

				Playlist play = new Playlist(ids);
				play.main(null);
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
						e1.printStackTrace();
					}
					unclickAllButtons(0);
					songPlaying = false;
				}
				if (thisSongPlaying.get(0) == false) {
					songButtons.get(0).setBackground(new Color(206, 184, 95));
					mp3.play("music/" + ids.get(0) + ".mp3");
					thisSongPlaying.set(0, true);
					songPlaying = true;
				} else {
					songButtons.get(0).setBackground(new Color(50, 184, 95));
					try {
						mp3.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					thisSongPlaying.set(0, false);
				}
			} else if (e.getSource() == songButtons.get(1)) {
				if (songPlaying == true) {
					try {
						mp3.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					unclickAllButtons(1);
					songPlaying = false;
				}
				if (thisSongPlaying.get(1) == false) {
					songButtons.get(1).setBackground(new Color(206, 184, 95));
					mp3.play("music/" + ids.get(1) + ".mp3");
					thisSongPlaying.set(1, true);
					songPlaying = true;
				} else {
					songButtons.get(1).setBackground(new Color(50, 184, 95));
					try {
						mp3.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					thisSongPlaying.set(1, false);
				}
			} else if (e.getSource() == songButtons.get(2)) {
				if (songPlaying == true) {
					try {
						mp3.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					unclickAllButtons(2);
					songPlaying = false;
				}
				if (thisSongPlaying.get(2) == false) {
					songButtons.get(2).setBackground(new Color(206, 184, 95));
					mp3.play("music/" + ids.get(2) + ".mp3");
					thisSongPlaying.set(2, true);
					songPlaying = true;
				} else {
					songButtons.get(2).setBackground(new Color(50, 184, 95));
					try {
						mp3.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					thisSongPlaying.set(2, false);
				}
			}

			else if (e.getSource() == songButtons.get(3)) {
				if (songPlaying == true) {
					try {
						mp3.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					unclickAllButtons(3);
					songPlaying = false;
				}
				if (thisSongPlaying.get(3) == false) {
					songButtons.get(3).setBackground(new Color(206, 184, 95));
					mp3.play("music/" + ids.get(3) + ".mp3");
					thisSongPlaying.set(3, true);
					songPlaying = true;
				} else {
					songButtons.get(3).setBackground(new Color(50, 184, 95));
					try {
						mp3.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					thisSongPlaying.set(3, false);
				}
			}

			else if (e.getSource() == songButtons.get(4)) {
				if (songPlaying == true) {
					try {
						mp3.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					unclickAllButtons(4);
					songPlaying = false;
				}
				if (thisSongPlaying.get(4) == false) {
					songButtons.get(4).setBackground(new Color(206, 184, 95));
					mp3.play("music/" + ids.get(4) + ".mp3");
					thisSongPlaying.set(4, true);
					songPlaying = true;
				} else {
					songButtons.get(4).setBackground(new Color(50, 184, 95));
					try {
						mp3.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					thisSongPlaying.set(4, false);
				}
			}

			else if (e.getSource() == songButtons.get(5)) {
				if (songPlaying == true) {
					try {
						mp3.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					unclickAllButtons(5);
					songPlaying = false;
				}
				if (thisSongPlaying.get(5) == false) {
					songButtons.get(5).setBackground(new Color(206, 184, 95));
					mp3.play("music/" + ids.get(5) + ".mp3");
					thisSongPlaying.set(5, true);
					songPlaying = true;
				} else {
					songButtons.get(5).setBackground(new Color(50, 184, 95));
					try {
						mp3.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					thisSongPlaying.set(5, false);
				}
			}

			else if (e.getSource() == songButtons.get(6)) {
				if (songPlaying == true) {
					try {
						mp3.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					unclickAllButtons(6);
					songPlaying = false;
				}
				if (thisSongPlaying.get(6) == false) {
					songButtons.get(6).setBackground(new Color(206, 184, 95));
					mp3.play("music/" + ids.get(6) + ".mp3");
					thisSongPlaying.set(6, true);
					songPlaying = true;
				} else {
					songButtons.get(6).setBackground(new Color(50, 184, 95));
					try {
						mp3.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					thisSongPlaying.set(6, false);
				}
			}

			else if (e.getSource() == songButtons.get(7)) {
				if (songPlaying == true) {
					try {
						mp3.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					unclickAllButtons(7);
					songPlaying = false;
				}
				if (thisSongPlaying.get(7) == false) {
					songButtons.get(7).setBackground(new Color(206, 184, 95));
					mp3.play("music/" + ids.get(7) + ".mp3");
					thisSongPlaying.set(7, true);
					songPlaying = true;
				} else {
					songButtons.get(7).setBackground(new Color(50, 184, 95));
					try {
						mp3.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					thisSongPlaying.set(7, false);
				}
			}

			else if (e.getSource() == songButtons.get(8)) {
				if (songPlaying == true) {
					try {
						mp3.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					unclickAllButtons(8);
					songPlaying = false;
				}
				if (thisSongPlaying.get(8) == false) {
					songButtons.get(8).setBackground(new Color(206, 184, 95));
					mp3.play("music/" + ids.get(8) + ".mp3");
					thisSongPlaying.set(8, true);
					songPlaying = true;
				} else {
					songButtons.get(8).setBackground(new Color(50, 184, 95));
					try {
						mp3.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					thisSongPlaying.set(8, false);
				}
			}

			else if (e.getSource() == songButtons.get(9)) {
				if (songPlaying == true) {
					try {
						mp3.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					unclickAllButtons(9);
					songPlaying = false;
				}
				if (thisSongPlaying.get(9) == false) {
					songButtons.get(9).setBackground(new Color(206, 184, 95));
					mp3.play("music/" + ids.get(9) + ".mp3");
					thisSongPlaying.set(9, true);
					songPlaying = true;
				} else {
					songButtons.get(9).setBackground(new Color(50, 184, 95));
					try {
						mp3.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					thisSongPlaying.set(9, false);
				}
			}

			else if (e.getSource() == songButtons.get(10)) {
				if (songPlaying == true) {
					try {
						mp3.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					unclickAllButtons(10);
					songPlaying = false;
				}
				if (thisSongPlaying.get(10) == false) {
					songButtons.get(10).setBackground(new Color(206, 184, 95));
					mp3.play("music/" + ids.get(10) + ".mp3");
					thisSongPlaying.set(10, true);
					songPlaying = true;
				} else {
					songButtons.get(10).setBackground(new Color(50, 184, 95));
					try {
						mp3.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					thisSongPlaying.set(10, false);
				}
			}

			else if (e.getSource() == songButtons.get(11)) {
				if (songPlaying == true) {
					try {
						mp3.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					unclickAllButtons(11);
					songPlaying = false;
				}
				if (thisSongPlaying.get(11) == false) {
					songButtons.get(11).setBackground(new Color(206, 184, 95));
					mp3.play("music/" + ids.get(11) + ".mp3");
					thisSongPlaying.set(11, true);
					songPlaying = true;
				} else {
					songButtons.get(11).setBackground(new Color(50, 184, 95));
					try {
						mp3.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					thisSongPlaying.set(11, false);
				}
			}

			else if (e.getSource() == songButtons.get(12)) {
				if (songPlaying == true) {
					try {
						mp3.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					unclickAllButtons(12);
					songPlaying = false;
				}
				if (thisSongPlaying.get(12) == false) {
					songButtons.get(12).setBackground(new Color(206, 184, 95));
					mp3.play("music/" + ids.get(12) + ".mp3");
					thisSongPlaying.set(12, true);
					songPlaying = true;
				} else {
					songButtons.get(12).setBackground(new Color(50, 184, 95));
					try {
						mp3.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					thisSongPlaying.set(12, false);
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