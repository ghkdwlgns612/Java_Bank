package chat_bot;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client {
	   public static void main(String[] args){
		   
	 
	        Socket socket = new Socket();
	        Scanner sc = new Scanner(System.in);	        
	 
	        SocketAddress address;
			try {
				address = new InetSocketAddress(InetAddress.getLocalHost(),6005);
		        try {
					socket.connect(address);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
//	        System.out.println(address);//LAPTOP-N1HNO2EV/172.30.1.13:6005
	        

	    }
	 
}
