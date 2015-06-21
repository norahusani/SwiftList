import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI extends JPanel {

	static JFrame frame;
	private JButton btn1, btn2;
	private JDBC db;

	public GUI() {
		super();

		FlowLayout experimentLayout = new FlowLayout();
		this.setLayout(experimentLayout);

		// set up the buttons
		btn1 = new JButton("RANDOM SWIFTLIST");
		int buttonHeight = 50;
		int buttonWidth = 200;
		btn1.setBounds(280, 10, buttonWidth, buttonHeight);
		btn1.setBackground(new Color(206, 184, 95));
		btn1.setOpaque(true);
		btn1.setBorder(null);
		btn2 = new JButton("SWIFTLIST BASED ON MOOD");
		btn2.setSize(5, 5);
		buttonHeight = 50;
		buttonWidth = 200;
		btn2.setBounds(520, 10, buttonWidth, buttonHeight);
		btn2.setBackground(new Color(206, 184, 95));
		btn2.setOpaque(true);
		btn2.setBorder(null);
		this.add(btn1);
		this.add(btn2);

		// size of frame
		setSize(200, 200);
		setVisible(true);
		setLayout(new BorderLayout());

		// Image to show
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(getClass()
					.getResource("/images/Swift.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JLabel headerImage = new JLabel(new ImageIcon(myPicture));
		headerImage.setBounds(100, 60, 200, 150);
		this.add(headerImage);

		// set up button action
		ButtonResponder br = new ButtonResponder();
		btn1.addActionListener(br);
		ButtonResponder br2 = new ButtonResponder();
		btn2.addActionListener(br2);

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

	public class ButtonResponder implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btn1) {

				ArrayList<Integer> songsToPlay = new ArrayList<Integer>();
				songsToPlay = chooseRandomSongs();
				// rand = new RandomSwiftList();
				// rand.setVisible(true);
				// rand.main(null);
				Playlist play = new Playlist(songsToPlay);
				play.setVisible(true);
				play.main(null);

				CloseFrame();

			}

			if (e.getSource() == btn2) {

				QuestionsPage question = new QuestionsPage();
				question.setVisible(true);
				question.main(null);
				CloseFrame();

			}

			repaint();

		}

	}

	private void CloseFrame() {
		frame.dispose();
	}

	public static void main(String[] args) {

		frame = new JFrame("SwiftList");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new GUI());
		frame.setBounds(300, 500, 1000, 700);
		frame.setBackground(new Color(100, 0, 60));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(true);

	}

}
