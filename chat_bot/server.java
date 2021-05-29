package chat_bot;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class server {

	public static int PORT = 6005;
	public static void main(String[] args)
	{
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
 
        OutputStream os = null;
        OutputStreamWriter osw = null;
        PrintWriter pw = null;
        Scanner sc = new Scanner(System.in);
        
		try {
			ServerSocket server_socket = new ServerSocket();
			
			InetAddress address = InetAddress.getLocalHost();
			String host = address.getHostAddress();
//			System.out.println(address); //LAPTOP-N1HNO2EV/192.168.191.134
//			System.out.println(host); //192.168.191.134

			server_socket.bind(new InetSocketAddress(host, PORT));
			System.out.println("[server] binding " + host);
			
			Socket socket = server_socket.accept();
			InetSocketAddress socketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
            System.out.println("[server] connected by client");
            System.out.println("[server] Connect with " + socketAddress.getHostString() + " " + socket.getPort());
			
            while (true)
            {
                is = socket.getInputStream();
                isr = new InputStreamReader(is, "UTF-8");
                br = new BufferedReader(isr);
 
                // outputStream 가져와서 (주 스트림) StreamWriter와 PrintWriter로 감싸준다 (보조 스트림)
                os = socket.getOutputStream();
                osw = new OutputStreamWriter(os, "UTF-8");
                pw = new PrintWriter(osw, true);
 
                String buffer = null;
                buffer = br.readLine(); // Blocking
                if (buffer == null) {
 
                    // 정상종료 : remote socket close()
                    // 메소드를 통해서 정상적으로 소켓을 닫은 경우
                    System.out.println("[server] closed by client");
                    break;
 
                }
 
                System.out.println("[server] recived : " + buffer);
                pw.println(buffer);
            }
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
