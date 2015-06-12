import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class QuestionsPage extends JPanel {

	static JFrame frame1;
	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
			btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18,
			btn19, btn20, btn21, btn22;
	private JLabel label1, label2;
	public static MP3 mp3;
	boolean b2 = false, b3 = false, b4 = false, b5 = false, b6 = false,
			b7 = false, b8 = false, b9 = false, b10 = false, b11 = false,
			b12 = false, b13 = false, b14 = false, b15 = false, b16 = false,
			b17 = false, b18 = false, b19 = false, b20 = false, b21 = false;

	public QuestionsPage() {
		super();

		FlowLayout experimentLayout = new FlowLayout();
		this.setLayout(experimentLayout);

		// set up label
		label2 = new JLabel(
				"How are you feeling? Click as many emotions that currently apply:");
		label2.setBounds(260, 50, 700, 100);
		label2.setFont(label2.getFont().deriveFont(16f));
		this.add(label2);

		label1 = new JLabel("T-swift songs based on your mood!");
		label1.setBounds(320, 0, 500, 100);
		label1.setFont(label1.getFont().deriveFont(24f));
		this.add(label1);

		// set up the buttons
		btn1 = new JButton("HOME");
		int buttonHeight = 50;
		int buttonWidth = 200;
		btn1.setBounds(25, 15, buttonWidth, buttonHeight);
		btn1.setBackground(new Color(206, 184, 95));
		btn1.setOpaque(true);
		btn1.setBorder(null);
		this.add(btn1);

		buttonWidth = 150;

		btn2 = new JButton("HAPPY");
		btn2.setBounds(125, 150, buttonWidth, buttonHeight);
		btn2.setBackground(new Color(206, 184, 95));
		btn2.setOpaque(true);
		btn2.setBorder(null);
		this.add(btn2);

		btn3 = new JButton("SAD");
		btn3.setBounds(325, 150, buttonWidth, buttonHeight);
		btn3.setBackground(new Color(206, 184, 95));
		btn3.setOpaque(true);
		btn3.setBorder(null);
		this.add(btn3);

		btn4 = new JButton("MAD");
		btn4.setBounds(525, 150, buttonWidth, buttonHeight);
		btn4.setBackground(new Color(206, 184, 95));
		btn4.setOpaque(true);
		btn4.setBorder(null);
		this.add(btn4);

		btn5 = new JButton("FREE");
		btn5.setBounds(725, 150, buttonWidth, buttonHeight);
		btn5.setBackground(new Color(206, 184, 95));
		btn5.setOpaque(true);
		btn5.setBorder(null);
		this.add(btn5);

		btn6 = new JButton("CONFUSED");
		btn6.setBounds(125, 250, buttonWidth, buttonHeight);
		btn6.setBackground(new Color(206, 184, 95));
		btn6.setOpaque(true);
		btn6.setBorder(null);
		this.add(btn6);

		btn7 = new JButton("FRUSTRATED");
		btn7.setBounds(325, 250, buttonWidth, buttonHeight);
		btn7.setBackground(new Color(206, 184, 95));
		btn7.setOpaque(true);
		btn7.setBorder(null);
		this.add(btn7);

		btn8 = new JButton("REGRETFUL");
		btn8.setBounds(525, 250, buttonWidth, buttonHeight);
		btn8.setBackground(new Color(206, 184, 95));
		btn8.setOpaque(true);
		btn8.setBorder(null);
		this.add(btn8);

		btn9 = new JButton("NOSTALGIC");
		btn9.setBounds(725, 250, buttonWidth, buttonHeight);
		btn9.setBackground(new Color(206, 184, 95));
		btn9.setOpaque(true);
		btn9.setBorder(null);
		this.add(btn9);

		btn10 = new JButton("BETRAYED");
		btn10.setBounds(125, 350, buttonWidth, buttonHeight);
		btn10.setBackground(new Color(206, 184, 95));
		btn10.setOpaque(true);
		btn10.setBorder(null);
		this.add(btn10);

		btn11 = new JButton("LONELY");
		btn11.setBounds(325, 350, buttonWidth, buttonHeight);
		btn11.setBackground(new Color(206, 184, 95));
		btn11.setOpaque(true);
		btn11.setBorder(null);
		this.add(btn11);

		btn12 = new JButton("EMPOWERED");
		btn12.setBounds(525, 350, buttonWidth, buttonHeight);
		btn12.setBackground(new Color(206, 184, 95));
		btn12.setOpaque(true);
		btn12.setBorder(null);
		this.add(btn12);

		btn13 = new JButton("AFRAID");
		btn13.setBounds(725, 350, buttonWidth, buttonHeight);
		btn13.setBackground(new Color(206, 184, 95));
		btn13.setOpaque(true);
		btn13.setBorder(null);
		this.add(btn13);

		btn14 = new JButton("VENGEFUL");
		btn14.setBounds(125, 450, buttonWidth, buttonHeight);
		btn14.setBackground(new Color(206, 184, 95));
		btn14.setOpaque(true);
		btn14.setBorder(null);
		this.add(btn14);

		btn15 = new JButton("SARCASTIC");
		btn15.setBounds(325, 450, buttonWidth, buttonHeight);
		btn15.setBackground(new Color(206, 184, 95));
		btn15.setOpaque(true);
		btn15.setBorder(null);
		this.add(btn15);

		btn16 = new JButton("SOCIAL");
		btn16.setBounds(525, 450, buttonWidth, buttonHeight);
		btn16.setBackground(new Color(206, 184, 95));
		btn16.setOpaque(true);
		btn16.setBorder(null);
		this.add(btn16);

		btn17 = new JButton("HOPEFUL");
		btn17.setBounds(725, 450, buttonWidth, buttonHeight);
		btn17.setBackground(new Color(206, 184, 95));
		btn17.setOpaque(true);
		btn17.setBorder(null);
		this.add(btn17);

		btn18 = new JButton("DESPERATE");
		btn18.setBounds(125, 550, buttonWidth, buttonHeight);
		btn18.setBackground(new Color(206, 184, 95));
		btn18.setOpaque(true);
		btn18.setBorder(null);
		this.add(btn18);

		btn19 = new JButton("FOOLISH");
		btn19.setBounds(325, 550, buttonWidth, buttonHeight);
		btn19.setBackground(new Color(206, 184, 95));
		btn19.setOpaque(true);
		btn19.setBorder(null);
		this.add(btn19);

		btn20 = new JButton("AMAZED");
		btn20.setBounds(525, 550, buttonWidth, buttonHeight);
		btn20.setBackground(new Color(206, 184, 95));
		btn20.setOpaque(true);
		btn20.setBorder(null);
		this.add(btn20);

		btn21 = new JButton("BRAVE");
		btn21.setBounds(725, 550, buttonWidth, buttonHeight);
		btn21.setBackground(new Color(206, 184, 95));
		btn21.setOpaque(true);
		btn21.setBorder(null);
		this.add(btn21);

		buttonWidth = 400;

		btn22 = new JButton("CREATE MY SWIFTLIST");
		btn22.setBounds(300, 625, buttonWidth, buttonHeight);
		btn22.setBackground(new Color(206, 184, 200));
		btn22.setOpaque(true);
		btn22.setBorder(null);
		this.add(btn22);

		// size of frame
		setSize(300, 300);
		setVisible(true);
		setLayout(new BorderLayout());

		// set up button action
		ButtonResponder br = new ButtonResponder();
		btn1.addActionListener(br);
		ButtonResponder br2 = new ButtonResponder();
		btn2.addActionListener(br2);
		ButtonResponder br3 = new ButtonResponder();
		btn3.addActionListener(br3);
		ButtonResponder br4 = new ButtonResponder();
		btn4.addActionListener(br4);
		ButtonResponder br5 = new ButtonResponder();
		btn5.addActionListener(br5);
		ButtonResponder br6 = new ButtonResponder();
		btn6.addActionListener(br6);
		ButtonResponder br7 = new ButtonResponder();
		btn7.addActionListener(br7);
		ButtonResponder br8 = new ButtonResponder();
		btn8.addActionListener(br8);
		ButtonResponder br9 = new ButtonResponder();
		btn9.addActionListener(br9);
		ButtonResponder br10 = new ButtonResponder();
		btn10.addActionListener(br10);
		ButtonResponder br11 = new ButtonResponder();
		btn11.addActionListener(br11);
		ButtonResponder br12 = new ButtonResponder();
		btn12.addActionListener(br12);
		ButtonResponder br13 = new ButtonResponder();
		btn13.addActionListener(br13);
		ButtonResponder br14 = new ButtonResponder();
		btn14.addActionListener(br14);
		ButtonResponder br15 = new ButtonResponder();
		btn15.addActionListener(br15);
		ButtonResponder br16 = new ButtonResponder();
		btn16.addActionListener(br16);
		ButtonResponder br17 = new ButtonResponder();
		btn17.addActionListener(br17);
		ButtonResponder br18 = new ButtonResponder();
		btn18.addActionListener(br18);
		ButtonResponder br19 = new ButtonResponder();
		btn19.addActionListener(br19);
		ButtonResponder br20 = new ButtonResponder();
		btn20.addActionListener(br20);
		ButtonResponder br21 = new ButtonResponder();
		btn21.addActionListener(br21);
		ButtonResponder br22 = new ButtonResponder();
		btn22.addActionListener(br22);

	}

	public class ButtonResponder implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btn1) {
				GUI home = new GUI();
				home.setVisible(true);
				home.main(null);
				CloseFrame();
				repaint();
			}
			if (e.getSource() == btn2) {
				if (b2 == false) {
					b2 = true;
					btn2.setBackground(new Color(50, 184, 95));
				} else {
					b2 = false;
					btn2.setBackground(new Color(206, 184, 95));
				}
			}
			if (e.getSource() == btn3) {
				if (b3 == false) {
					b3 = true;
					btn3.setBackground(new Color(50, 184, 95));
				} else {
					b3 = false;
					btn3.setBackground(new Color(206, 184, 95));
				}
			}
			if (e.getSource() == btn4) {
				if (b4 == false) {
					b4 = true;
					btn4.setBackground(new Color(50, 184, 95));
				} else {
					b4 = false;
					btn4.setBackground(new Color(206, 184, 95));
				}
			}
			if (e.getSource() == btn5) {
				if (b5 == false) {
					b5 = true;
					btn5.setBackground(new Color(50, 184, 95));
				} else {
					b5 = false;
					btn5.setBackground(new Color(206, 184, 95));
				}
			}
			if (e.getSource() == btn6) {
				if (b6 == false) {
					b6 = true;
					btn6.setBackground(new Color(50, 184, 95));
				} else {
					b6 = false;
					btn6.setBackground(new Color(206, 184, 95));
				}
			}
			if (e.getSource() == btn7) {
				if (b7 == false) {
					b7 = true;
					btn7.setBackground(new Color(50, 184, 95));
				} else {
					b7 = false;
					btn7.setBackground(new Color(206, 184, 95));
				}
			}
			if (e.getSource() == btn8) {
				if (b8 == false) {
					b8 = true;
					btn8.setBackground(new Color(50, 184, 95));
				} else {
					b8 = false;
					btn8.setBackground(new Color(206, 184, 95));
				}
			}
			if (e.getSource() == btn9) {
				if (b9 == false) {
					b9 = true;
					btn9.setBackground(new Color(50, 184, 95));
				} else {
					b9 = false;
					btn9.setBackground(new Color(206, 184, 95));
				}
			}
			if (e.getSource() == btn10) {
				if (b10 == false) {
					b10 = true;
					btn10.setBackground(new Color(50, 184, 95));
				} else {
					b10 = false;
					btn10.setBackground(new Color(206, 184, 95));
				}
			}
			if (e.getSource() == btn11) {
				if (b11 == false) {
					b11 = true;
					btn11.setBackground(new Color(50, 184, 95));
				} else {
					b11 = false;
					btn11.setBackground(new Color(206, 184, 95));
				}
			}
			if (e.getSource() == btn12) {
				if (b12 == false) {
					b12 = true;
					btn12.setBackground(new Color(50, 184, 95));
				} else {
					b12 = false;
					btn12.setBackground(new Color(206, 184, 95));
				}
			}
			if (e.getSource() == btn13) {
				if (b13 == false) {
					b13 = true;
					btn13.setBackground(new Color(50, 184, 95));
				} else {
					b13 = false;
					btn13.setBackground(new Color(206, 184, 95));
				}
			}
			if (e.getSource() == btn14) {
				if (b14 == false) {
					b14 = true;
					btn14.setBackground(new Color(50, 184, 95));
				} else {
					b14 = false;
					btn14.setBackground(new Color(206, 184, 95));
				}
			}
			if (e.getSource() == btn15) {
				if (b15 == false) {
					b15 = true;
					btn15.setBackground(new Color(50, 184, 95));
				} else {
					b15 = false;
					btn15.setBackground(new Color(206, 184, 95));
				}
			}
			if (e.getSource() == btn16) {
				if (b16 == false) {
					b16 = true;
					btn16.setBackground(new Color(50, 184, 95));
				} else {
					b16 = false;
					btn16.setBackground(new Color(206, 184, 95));
				}
			}
			if (e.getSource() == btn17) {
				if (b17 == false) {
					b17 = true;
					btn17.setBackground(new Color(50, 184, 95));
				} else {
					b17 = false;
					btn17.setBackground(new Color(206, 184, 95));
				}
			}
			if (e.getSource() == btn18) {
				if (b18 == false) {
					b18 = true;
					btn18.setBackground(new Color(50, 184, 95));
				} else {
					b18 = false;
					btn18.setBackground(new Color(206, 184, 95));
				}
			}
			if (e.getSource() == btn19) {
				if (b19 == false) {
					b19 = true;
					btn19.setBackground(new Color(50, 184, 95));
				} else {
					b19 = false;
					btn19.setBackground(new Color(206, 184, 95));
				}
			}
			if (e.getSource() == btn20) {
				if (b20 == false) {
					b20 = true;
					btn20.setBackground(new Color(50, 184, 95));
				} else {
					b20 = false;
					btn20.setBackground(new Color(206, 184, 95));
				}
			}
			if (e.getSource() == btn21) {
				if (b21 == false) {
					b21 = true;
					btn21.setBackground(new Color(50, 184, 95));
				} else {
					b21 = false;
					btn21.setBackground(new Color(206, 184, 95));
				}
			}
			if (e.getSource() == btn22) {
				MoodPage mood = new MoodPage();
				mood.setVisible(true);
				try {
					mood.main(null);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				CloseFrame();
				repaint();
			}
		}
	}

	private void CloseFrame() {
		frame1.dispose();
	}

	public static void main(String[] args) {

		frame1 = new JFrame("SwiftList");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.add(new QuestionsPage());
		frame1.setBounds(300, 500, 1000, 700);
		frame1.setBackground(new Color(100, 0, 60));
		frame1.setLocationRelativeTo(null);
		frame1.setVisible(true);
		frame1.setResizable(true);

	}

}
