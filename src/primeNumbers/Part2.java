package primeNumbers;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Part2 extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	//Setting up components for GUI
	JLabel title = new JLabel("Enter Range", SwingConstants.CENTER);
	JLabel nth = new JLabel("Find nth Prime", SwingConstants.CENTER);
	JLabel from = new JLabel("From: ");
	JLabel to = new JLabel("To: ");
	JLabel nLabel = new JLabel("N: ");
	JLabel answerLabel = new JLabel("Answer: ");
	
	JButton button1 = new JButton("Submit");
	JButton button2 = new JButton("Submit");
	
	JTextArea answerText = new JTextArea(5, 25);
	
	JTextField fromText = new JTextField();
	JTextField toText = new JTextField();
	JTextField n = new JTextField();
	JTextField answer = new JTextField();
	
	//Creating extra panels for formatting
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
	
	
	public Part2(){
		//Create JFrame
	    JFrame frame = new JFrame("Find Prime Numbers!");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Container contain = frame.getContentPane();
	    contain.setPreferredSize(new Dimension(350, 210));
	    frame.pack();
	    frame.setResizable(false);

	    //Add Components to frame
  		title.setPreferredSize(new Dimension(300,50));
  		contain.add(title, BorderLayout.NORTH);
  		contain.add(panel, BorderLayout.CENTER);
  		contain.add(panel2, BorderLayout.SOUTH);
  		
  		panel.add(to);
  		toText.setPreferredSize(new Dimension(75, 20));
  		panel.add(toText);
  		
  		panel.add(from);
		fromText.setPreferredSize(new Dimension(75, 20));
		panel.add(fromText);
		
  		button1.setPreferredSize(new Dimension(75, 20));
  		panel.add(button1);
  		button1.addActionListener(this);
  		
  		//Set text area size and add scroll bar. 
  		answerText.setEditable(false);
  		answerText.setLineWrap(true);
  		JScrollPane scroll = new JScrollPane(answerText);
  		scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
  		panel.add(scroll);
  		
  		
  		panel.add(nth);
  		panel2.add(nLabel);
  		
  		n.setPreferredSize(new Dimension(75, 20));
  		panel2.add(n);
  		panel2.add(answerLabel);
  		
  		answer.setPreferredSize(new Dimension(75, 20));
  		answer.setEditable(false);
  		panel2.add(answer);
  		
  		button2.setPreferredSize(new Dimension(75, 20));
  		panel2.add(button2);
  		button2.addActionListener(this);
  		
  		//Show the frame on the screen
  		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//If running the range function
		if (e.getSource() == button1){
			try{
				int num1 = Integer.parseInt(fromText.getText());
				int num2 = Integer.parseInt(toText.getText());
				boolean isPrime;
				
				//If a negative number is entered throw exception
				if(num1 < 0 || num2 < 0){
					throw new NumberFormatException();
				}
				
				//Clear text area before starting to add values
				answerText.setText("");
				
				//If num1 is bigger than num2, swap them
				if(num1 > num2){
					int temp = num2;
					num2 = num1;
					num1 = temp;
				}
				//Making sure that 2 is printed
				if(num1 == 1 || num1 == 2){
					answerText.append("2");
	            }

				//If num1 is even, add one (need to start loop with odd number) and print two 
				if(num1 % 2 == 0){
					num1 += 1;
				}
				
				//Loops to check if numbers are prime
				for(int i = num1; i < num2; i+=2){
					isPrime = true;
					//1 is not prime
					if(i == 1){
						isPrime = false;
					}
					for(int j = 3; j <= (int)Math.sqrt(i); j+=2){
						if(i%j == 0){
							isPrime = false;
							break;
						}
					}
					if(isPrime){
						//If it is the first number to be added, don't put a comma at the front
						if(answerText.getText().equals("")){
							answerText.append(i + "");
						}
						else{
							answerText.append(", " + i);
						}
					}
				}
			}
			catch (NumberFormatException ex){
				JOptionPane.showMessageDialog(null, "Please enter positive integer values.");
				toText.setText("");
				fromText.setText("");
			}
		}
		//If user running the nth prime function
		else if (e.getSource() == button2){
			try{
				//Setting variables
				boolean isPrime;
				int num = Integer.parseInt(n.getText());
				
				//Throwing an exception if the entered number is too high 
				//Limited to one million in this case, as numbers above that start to become difficult to process for the average computer
				if(num > 1000000){
					throw new NullPointerException();
				}
				else if (num < 0){
					throw new NumberFormatException();
				}
				
				int count = 1;
				
				//Making sure that 2 is printed if needed
				if(num == 1){
					answer.setText("2");
				}
				else{
					int currentNum = 3;
					while(count < num){
						isPrime = true;

						for(int j = 3; j <= (int)Math.sqrt(currentNum); j+=2){
							if(currentNum % j == 0){
								isPrime = false;
								break;
							}
						}
						if(isPrime){
							count++;
							if (count == num){
								answer.setText(currentNum + "");
							}
						}
						currentNum+=2;
					}
				}
			}
			catch (NumberFormatException ex){
				JOptionPane.showMessageDialog(null, "Please enter a positive integer.");
				n.setText("");
			}
			catch (NullPointerException ex){
				JOptionPane.showMessageDialog(null, "Maximum value is 1 000 000.");
				n.setText("");
			}
		}
		
	}
	
	public static void main(String[] args){
		//Running the GUI
		new Part2();
	}
}

