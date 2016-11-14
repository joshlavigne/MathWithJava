package post0;
import java.awt.*;
import javax.swing.*;

public class BasicGUI {
	public BasicGUI(){
		//Setting up components for GUI
		JLabel label1 = new JLabel("Title Goes Here", SwingConstants.CENTER);
		JButton button1 = new JButton("Submit");
		JTextField text1 = new JTextField("Text Example");
		JPanel panel = new JPanel();
		
		//Create JFrame
		JFrame frame = new JFrame("Basic GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contain = frame.getContentPane();
		contain.setPreferredSize(new Dimension(300, 100));
		frame.pack();
		frame.setVisible(true);
		
		//Add Components
		label1.setPreferredSize(new Dimension(300,50));
		contain.add(label1, BorderLayout.NORTH);
		contain.add(panel, BorderLayout.CENTER);
		
		text1.setPreferredSize(new Dimension(200, 30));
		panel.add(text1);
		
		button1.setPreferredSize(new Dimension(75, 30));
		panel.add(button1);
		
	}
	
	public static void main(String[] args) {
		//new BasicGUI();
	}
}
