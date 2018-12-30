package client;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Main {
	public static void main(String[] arg) {	
			Model theModel = new Model();
			MainWindow window=new MainWindow();
			TheController theController=new TheController(window,theModel);
			window.setVisible(true);
		
		
	}
}
