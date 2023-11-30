import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Image;
import javax.swing.JPanel;


import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

public class CeeLoGUI {

	private JFrame parentFrame = new JFrame("Cee-Lo");
	private JFrame loginFrame = new JFrame();
	Image backGround;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CeeLoGUI window = new CeeLoGUI();
					window.parentFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CeeLoGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		parentFrame = new JFrame();
		parentFrame.setBounds(100, 100, 1280, 720);
		JLabel label = new JLabel(new ImageIcon("/home/kevinren/Documents/CeeLoFinal/CeeLoFinal/rsc/CeeLo_title.png"));
		parentFrame.setContentPane(label);
		parentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		parentFrame.getContentPane().setLayout(null);
		parentFrame.setVisible(true);
		
		ImageIcon icon = new ImageIcon("/home/kevinren/Documents/CeeLoFinal/CeeLoFinal/rsc/Ceelo_title.jpg");
		parentFrame.setIconImage(icon.getImage());
	
		JButton start = new JButton("Start");
		start.setBounds(300,200,100,100);
	
		
		JLabel Dice1 = new JLabel("New label");
		Dice1.setBounds(516, 211, 97, 154);
		parentFrame.getContentPane().add(Dice1);
		
		JLabel Dice2 = new JLabel("New label");
		Dice2.setBounds(625, 211, 97, 154);
		parentFrame.getContentPane().add(Dice2);
		
		JLabel Dice3 = new JLabel("New label");
		Dice3.setBounds(734, 211, 97, 154);
		parentFrame.getContentPane().add(Dice3);
		
		JLabel player1 = new JLabel("Player[0].getName()");
		player1.setBounds(1021, 606, 60, 17);
		parentFrame.getContentPane().add(player1);
		
		JLabel player2 = new JLabel("New label");
		player2.setBounds(52, 118, 60, 17);
		parentFrame.getContentPane().add(player2);
		
		JLabel player3 = new JLabel("New label");
		player3.setBounds(601, 12, 60, 17);
		parentFrame.getContentPane().add(player3);
		
		JLabel player4 = new JLabel("New label");
		player4.setBounds(1122, 118, 60, 17);
		parentFrame.getContentPane().add(player4);
		
		JToggleButton actionToggleButton = new JToggleButton("Action");
		actionToggleButton.setBounds(79, 601, 147, 27);
		parentFrame.getContentPane().add(actionToggleButton);
	}
}
