package tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;


public class server {
	Map<String , String> dic = new HashMap<String, String>();
	int count=1;
	public static void main(String[] arg) {
		new server().getConnection();;
			}
	
	public void getConnection() {
		try {
			ServerSocket server = new ServerSocket(9765);
			System.out.println("server start");
			while(true) {
				Socket client = server.accept();
				System.out.println("client: "+count);
				count++;
				ServerThread serverthread =new ServerThread(client,this);
				serverthread.start();}
			} catch(SocketException e) {
				System.out.println("client disconnect");
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	public synchronized String addWord(String word,String meanings) {
		String respond=null;
		if(dic.containsKey(word)) 
			respond="notify*the word has already existed!!";	
		else {
			dic.put(word, meanings);
			respond="notify*add successfully!!";
			}
		return respond;
		}
	
	public synchronized String searchWord(String word) {
		String respond=null;
		if(dic.containsKey(word)) 
			respond="mean*"+dic.get(word);		
		else 
			respond="notify*the word does not exist!!";
		return respond;
	}
	
	public synchronized String deleteWord(String word) {
		String respond=null;
		if(dic.containsKey(word)) { 
			dic.remove(word);
			respond="notify*delete successfully!!";
			}
		else 
			respond="notify*the word does not exist!!";
		return respond;
	}
	}

