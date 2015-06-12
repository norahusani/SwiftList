import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RandomSwiftList extends JPanel {

	static JFrame frame1;
	private JButton btn1;
	private JLabel label1, label2, label3, label4, label5, label6, label7,
			label8, label9, label10, label11, label12, label13, label14,
			label15;
	private JDBC db;
	public static MP3 mp3;

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

		db = new JDBC();
		ResultSet rs = null;
		rs = db.getSongTitleById(1);

		label3 = new JLabel("Track 01: " + rs.getString("Title"));
		label3.setBounds(455, 150, 700, 50);
		label3.setFont(label3.getFont().deriveFont(14f));
		this.add(label3);

		label4 = new JLabel("Track 02:");
		label4.setBounds(455, 170, 700, 50);
		label4.setFont(label4.getFont().deriveFont(14f));
		this.add(label4);

		label5 = new JLabel("Track 03:");
		label5.setBounds(455, 190, 700, 50);
		label5.setFont(label5.getFont().deriveFont(14f));
		this.add(label5);

		label6 = new JLabel("Track 04:");
		label6.setBounds(455, 210, 700, 50);
		label6.setFont(label6.getFont().deriveFont(14f));
		this.add(label6);

		label7 = new JLabel("Track 05:");
		label7.setBounds(455, 230, 700, 50);
		label7.setFont(label7.getFont().deriveFont(14f));
		this.add(label7);

		label8 = new JLabel("Track 06:");
		label8.setBounds(455, 250, 700, 50);
		label8.setFont(label8.getFont().deriveFont(14f));
		this.add(label8);

		label9 = new JLabel("Track 07:");
		label9.setBounds(455, 270, 700, 50);
		label9.setFont(label9.getFont().deriveFont(14f));
		this.add(label9);

		label10 = new JLabel("Track 08:");
		label10.setBounds(455, 290, 700, 50);
		label10.setFont(label10.getFont().deriveFont(14f));
		this.add(label10);

		label11 = new JLabel("Track 09:");
		label11.setBounds(455, 310, 700, 50);
		label11.setFont(label11.getFont().deriveFont(14f));
		this.add(label11);

		label12 = new JLabel("Track 10:");
		label12.setBounds(455, 330, 700, 50);
		label12.setFont(label12.getFont().deriveFont(14f));
		this.add(label12);

		label13 = new JLabel("Track 11:");
		label13.setBounds(455, 350, 700, 50);
		label13.setFont(label13.getFont().deriveFont(14f));
		this.add(label13);

		label14 = new JLabel("Track 12:");
		label14.setBounds(455, 370, 700, 50);
		label14.setFont(label14.getFont().deriveFont(14f));
		this.add(label14);

		label15 = new JLabel("Track 13:");
		label15.setBounds(455, 390, 700, 50);
		label15.setFont(label15.getFont().deriveFont(14f));
		this.add(label15);

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

		// set up button action
		ButtonResponder br = new ButtonResponder();
		btn1.addActionListener(br);

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

		// play the song
		String filename = "/Users/sillyjokes83/desktop/LoveStory.mp3";
		mp3 = new MP3();
		mp3.play();

		// when the computation is done, stop playing it
		mp3.close();

		// play from the beginning
		mp3 = new MP3();
		mp3.play();
		// instead of repaint call new class

	}

}