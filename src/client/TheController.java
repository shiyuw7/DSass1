package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class TheController {
	Model theModel;
	MainWindow theView;
	
	public TheController(MainWindow theView,Model theModel) {
		this.theView=theView;
		this.theModel=theModel;
		this.theView.addButtonActionListener(new buttonsListener());
		//MsgListener ml=new MsgListener(theModel.getIs());
		//ml.start();
	}
	
	public boolean onlyLetter(String str) {
		  String regex = "[a-zA-Z]+";
		  return str.matches(regex);
		 }
	
	class buttonsListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String buttonType=e.getActionCommand();
			String msg=null;
			String word=theView.getTextField().getText();
			String meaning=theView.getTextArea().getText();
			switch(buttonType) {
			case"search":
				msg="search "+word+" null";
				break;
			case"add":	
				if(meaning.equals(""))
					msg="you need to input the meaning of the word here!!";
				else	
					msg="add "+word+" "+meaning;
				//theModel.sendMsg(msg);
				//theView.lblNewLabel.setText(theModel.receiveMsg());
				break;
			case"delete":
				msg="delete "+word+" null";	
				//theModel.sendMsg(msg);
				//theView.lblNewLabel.setText(theModel.receiveMsg());
				break;
				}
			theView.getTextArea().setText("");
			theView.getLabel().setText("");
			
			if(msg.equals("you need to input the meaning of the word here!!")) {
				theView.getTextArea().setText(msg);
				}
			else if(onlyLetter(word)==false) {
				theView.getTextArea().setText("you need to input a word!!");
				}
			else {
				try {
					theModel.sendMsg(msg);
				} catch (SocketException  | NullPointerException e1) {
					// TODO Auto-generated catch block
					theView.getLabel().setText("server disconnect");
					return;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String respond=theModel.readMsg();
				String[] res=new String[2];
				res=respond.split("[*]");
				if(res[0].equals("mean")) 
					theView.getTextArea().setText(res[1]);				
				else
					theView.getLabel().setText(res[1]);
			}
			
			
			
		}}
}
