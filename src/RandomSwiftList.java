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
	private JDBC db;
	public static MP3 mp3;
	boolean b2 = false;

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

		btn3 = new JButton("Track 01: " + rs.getString("Title"));
		buttonHeight = 25;
		buttonWidth = 300;
		btn3.setBounds(340, 160, buttonWidth, buttonHeight);
		btn3.setBackground(new Color(50, 184, 95));
		btn3.setOpaque(true);
		btn3.setBorder(null);
		this.add(btn3);

		btn4 = new JButton("Track 02: ");
		buttonHeight = 25;
		buttonWidth = 300;
		btn4.setBounds(340, 200, buttonWidth, buttonHeight);
		btn4.setBackground(new Color(50, 184, 95));
		btn4.setOpaque(true);
		btn4.setBorder(null);
		this.add(btn4);

		btn5 = new JButton("Track 03: ");
		buttonHeight = 25;
		buttonWidth = 300;
		btn5.setBounds(340, 240, buttonWidth, buttonHeight);
		btn5.setBackground(new Color(50, 184, 95));
		btn5.setOpaque(true);
		btn5.setBorder(null);
		this.add(btn5);

		btn6 = new JButton("Track 04: ");
		buttonHeight = 25;
		buttonWidth = 300;
		btn6.setBounds(340, 280, buttonWidth, buttonHeight);
		btn6.setBackground(new Color(50, 184, 95));
		btn6.setOpaque(true);
		btn6.setBorder(null);
		this.add(btn6);

		btn7 = new JButton("Track 05: ");
		buttonHeight = 25;
		buttonWidth = 300;
		btn7.setBounds(340, 320, buttonWidth, buttonHeight);
		btn7.setBackground(new Color(50, 184, 95));
		btn7.setOpaque(true);
		btn7.setBorder(null);
		this.add(btn7);

		btn8 = new JButton("Track 06: ");
		buttonHeight = 25;
		buttonWidth = 300;
		btn8.setBounds(340, 360, buttonWidth, buttonHeight);
		btn8.setBackground(new Color(50, 184, 95));
		btn8.setOpaque(true);
		btn8.setBorder(null);
		this.add(btn8);

		btn9 = new JButton("Track 07: ");
		buttonHeight = 25;
		buttonWidth = 300;
		btn9.setBounds(340, 400, buttonWidth, buttonHeight);
		btn9.setBackground(new Color(50, 184, 95));
		btn9.setOpaque(true);
		btn9.setBorder(null);
		this.add(btn9);

		btn10 = new JButton("Track 08: ");
		buttonHeight = 25;
		buttonWidth = 300;
		btn10.setBounds(340, 440, buttonWidth, buttonHeight);
		btn10.setBackground(new Color(50, 184, 95));
		btn10.setOpaque(true);
		btn10.setBorder(null);
		this.add(btn10);

		btn11 = new JButton("Track 09: ");
		buttonHeight = 25;
		buttonWidth = 300;
		btn11.setBounds(340, 480, buttonWidth, buttonHeight);
		btn11.setBackground(new Color(50, 184, 95));
		btn11.setOpaque(true);
		btn11.setBorder(null);
		this.add(btn11);

		btn12 = new JButton("Track 10: ");
		buttonHeight = 25;
		buttonWidth = 300;
		btn12.setBounds(340, 520, buttonWidth, buttonHeight);
		btn12.setBackground(new Color(50, 184, 95));
		btn12.setOpaque(true);
		btn12.setBorder(null);
		this.add(btn12);

		btn13 = new JButton("Track 11: ");
		buttonHeight = 25;
		buttonWidth = 300;
		btn13.setBounds(340, 560, buttonWidth, buttonHeight);
		btn13.setBackground(new Color(50, 184, 95));
		btn13.setOpaque(true);
		btn13.setBorder(null);
		this.add(btn13);

		btn14 = new JButton("Track 12: ");
		buttonHeight = 25;
		buttonWidth = 300;
		btn14.setBounds(340, 600, buttonWidth, buttonHeight);
		btn14.setBackground(new Color(50, 184, 95));
		btn14.setOpaque(true);
		btn14.setBorder(null);
		this.add(btn14);

		btn15 = new JButton("Track 13: ");
		buttonHeight = 25;
		buttonWidth = 300;
		btn15.setBounds(340, 640, buttonWidth, buttonHeight);
		btn15.setBackground(new Color(50, 184, 95));
		btn15.setOpaque(true);
		btn15.setBorder(null);
		this.add(btn15);

		// size of frame
		setSize(300, 300);
		setVisible(true);
		setLayout(new BorderLayout());

		// set up button action
		ButtonResponder br = new ButtonResponder();
		btn1.addActionListener(br);
		btn2.addActionListener(br);

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
				ArrayList<Integer> songsToPlay = new ArrayList<Integer>();
				songsToPlay.add(1);
				songsToPlay.add(2);
				if (b2 == false) {
					b2 = true;
					mp3 = new MP3();
					for (int i = 0; i < songsToPlay.size(); i++) {
						mp3.play("music/" + songsToPlay.get(i) + ".mp3");
						synchronized (mp3) {
							try {
								mp3.wait(1000);
							} catch (InterruptedException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
						}
					}
				} else {
					b2 = false;
					try {
						mp3.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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