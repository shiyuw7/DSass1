package client;




import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
;


public class MainWindow extends JFrame {

	//private JFrame frame;
	private JTextField textField=new JTextField("") ;
	private JButton btnNewButton=new JButton("search");
	private JButton btnAdd=new JButton("add");
	private JButton btnDelete=new JButton("delete");
	private JTextArea textArea=new JTextArea("");;
	private JLabel lblNewLabel = new JLabel("");

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	//public MainWindow() {
		//initialize();
	//}

	/**
	 * Initialize the contents of the frame.
	 */
	public MainWindow() {
		//frame = new JFrame();
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		textField.setBounds(26, 10, 297, 33);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		
		textArea.setBounds(26, 81, 297, 154);
		getContentPane().add(textArea);
		
		
		btnNewButton.setFont(new Font("等线", Font.PLAIN, 16));
		btnNewButton.setBounds(331, 15, 93, 23);
		getContentPane().add(btnNewButton);
		
		
		btnAdd.setFont(new Font("等线", Font.PLAIN, 16));
		btnAdd.setBounds(333, 81, 93, 23);
		getContentPane().add(btnAdd);
		
		
		btnDelete.setFont(new Font("等线", Font.PLAIN, 16));
		btnDelete.setBounds(331, 152, 93, 23);
		getContentPane().add(btnDelete);
		
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(36, 48, 217, 23);
		getContentPane().add(lblNewLabel);
		
		
	}
	
	void addButtonActionListener(ActionListener listenerForButtons) {
		btnNewButton.addActionListener(listenerForButtons);
		btnAdd.addActionListener(listenerForButtons);
		btnDelete.addActionListener(listenerForButtons);
	}
	

	public JTextField getTextField() {
		return textField;
	}

	

	public JTextArea getTextArea() {
		return textArea;
	}

	public JLabel getLabel() {
		return lblNewLabel;
	}
	
	
	/*void addResearchActionListener(ActionListener listenerForResearch) {
		btnNewButton.addActionListener(listenerForResearch);
	}
	
	void addAddActionListener(ActionListener listenerForAdd) {
		btnAdd.addActionListener(listenerForAdd);
	}
	
	void addDeleteActionListener(ActionListener listenerForDelete) {
		btnDelete.addActionListener(listenerForDelete);
	}*/
}
