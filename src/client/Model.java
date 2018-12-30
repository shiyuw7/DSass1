package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Model {
	private static Socket client;
	private static DataOutputStream os;
	private static DataInputStream is;
	
	public Model(){
		try {
			client = new Socket("localhost",9765);
			os= new DataOutputStream(client.getOutputStream());
			is=new DataInputStream(client.getInputStream());
		} catch(SocketException e) {
			System.out.println("server disconnect");
			return;
		}catch (UnknownHostException e) {
			System.out.println("unknown host");
			
		} catch (IOException e) {
			System.out.println("IO error");
		}
	}
	
	public void closeSocket() {
		try {
			is.close();
			os.close();
			client.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendMsg(String msg) throws IOException,SocketException {
		//try {
			os.writeUTF(msg);
		/*} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SockrException e) {
			System.out.println("server disconnect");
		}*/
	}
	
	public String readMsg() {
		String data=null;
		try {
			data=is.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	public DataInputStream getIs() {
		return is;
	}
	
	
}
