import java.awt.Color;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import javax.swing.JButton;

public class CeeloLogin {

	private JFrame frame;

	/**s
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CeeloLogin window = new CeeloLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CeeloLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.black);
		
		
		try {                
         	BufferedImage imageTitle = ImageIO.read(new File("/rsc/Ceelo_title.jpg"));
		 	frame.getContentPane().setLayout(null);
		 	JLabel lblCeelo = new JLabel(new ImageIcon(imageTitle));
		 	lblCeelo.setBounds(0, 0, 1280, 684);
		 	lblCeelo.setVerticalAlignment(SwingConstants.TOP);
			frame.getContentPane().add(lblCeelo);
			
			JButton btnStart = new JButton("Start");
			btnStart.setBounds(582, 546, 105, 27);
			frame.getContentPane().add(btnStart);
       } catch (IOException ex) {
			JLabel lblCeelo = new JLabel("");
            lblCeelo.setText("Ceelo");
			lblCeelo.setBounds(685, 103, 305, 174);
			frame.getContentPane().add(lblCeelo);
       }
    
	}
}
