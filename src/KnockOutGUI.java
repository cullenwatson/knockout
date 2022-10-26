/*
 * Cullen Watson
 */

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class KnockOutGUI extends JFrame {

	JTextArea output;
	JScrollPane scrollPane;
	JButton button1;
	JButton button2;

	public KnockOutGUI() throws HeadlessException {
		
		// create and add widgets in the Constructor
		this.setTitle("Knock Out!");
		
		// creates two buttons.
		button1 = new JButton();
		button2 = new JButton();
		button1.setEnabled(true);
		button1.setText("Play");
		button2.setEnabled(false);
		button2.setText("Reset");
		
		// adds two buttons to frame
		add(button1);
		add(button2);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		output = new JTextArea(20, 30);
		output.setEditable(false);
		
		// adding textArea
		add(output);
		scrollPane = new JScrollPane(output);
		
		// Adds scrolling 
		add(scrollPane);

		// Action Listener for Play button
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startGame();
			}
		});
		
		// Action Listener for Reset button
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Toggling two buttons
				button1.setEnabled(true);
				button2.setEnabled(false);
				
				// Clearing TextArea
				output.setText("");
			}
		});
	}

	public void startGame() {
		
		// toggling to buttons
		button1.setEnabled(false);
		button2.setEnabled(true);
		output.setText("New Game!!");
		
		// adding logs to TextArea
		output.append("\n" + new KnockOut().playGame());
	}

}
