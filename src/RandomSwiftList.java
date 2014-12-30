import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RandomSwiftList extends JPanel {

	static JFrame frame1;
	private JButton btn1, btn2, btn3;
	private JLabel label1;

	public RandomSwiftList() {
		super();

		FlowLayout experimentLayout = new FlowLayout();
		this.setLayout(experimentLayout);

		// set up the buttons
		btn1 = new JButton("HOME");
		int buttonHeight = 50;
		int buttonWidth = 200;
		btn1.setBounds(200, 10, buttonWidth, buttonHeight);
		btn1.setBackground(new Color(206, 184, 95));
		btn1.setOpaque(true);
		btn1.setBorder(null);
		this.add(btn1);

		// set up label
		label1 = new JLabel("Enjoy your SwiftList!", JLabel.CENTER);
		// size of frame
		setSize(200, 200);
		setVisible(true);
		setLayout(new BorderLayout());

		// Image to show
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(getClass().getResource(
					"/images/Random.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JLabel headerImage = new JLabel(new ImageIcon(myPicture));
		headerImage.setBounds(100, 60, 200, 150);
		this.add(headerImage);

		// set up button action
		ButtonResponder br = new ButtonResponder();
		btn1.addActionListener(br);

	}

	public class ButtonResponder implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btn1) {

			}

		}

	}

	private void CloseFrame() {
		frame1.dispose();
	}

	public static void main(String[] args) {

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
		MP3 mp3 = new MP3(filename);
		mp3.play();

		// when the computation is done, stop playing it
		mp3.close();

		// play from the beginning
		mp3 = new MP3(filename);
		mp3.play();
		// instead of repaint call new class

	}

}