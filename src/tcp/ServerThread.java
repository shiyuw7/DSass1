package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class ServerThread extends Thread{
	private Socket client;
	private server serverIO;
	private DataOutputStream os;
	private DataInputStream is;
	
	public ServerThread(Socket client,server serverIO) {
		this.client=client;
		this.serverIO=serverIO;
		
		}
	public void run() {
		try {
			os= new DataOutputStream(this.client.getOutputStream());
			is= new DataInputStream(this.client.getInputStream());
			String data=null;
			String[] str= new String[3];
			while((data=is.readUTF())!=null) {
				str=data.split(" ");
				String respond=null;
				switch(str[0]) {
				case"search":
					respond=serverIO.searchWord(str[1]);
					break;
				case"add":
					respond=serverIO.addWord(str[1], str[2]);
					break;
				case"delete":
					respond=serverIO.deleteWord(str[1]);
					break;
				}
				os.writeUTF(respond);
			//	System.out.println("from client:"+data);
			//	os.writeUTF("receive your msg:"+data);
			}
		}catch(SocketException e1) {
			System.out.println("client disconnect");
			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
