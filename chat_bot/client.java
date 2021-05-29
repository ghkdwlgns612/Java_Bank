package chat_bot;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client {
	   public static void main(String[] args) {
		   
	 
	        Socket socket = new Socket();
	        Scanner sc = new Scanner(System.in);
	 
	        InputStream is = null;
	        InputStreamReader isr = null;
	        BufferedReader br = null;
	 
	        OutputStream os = null;
	        OutputStreamWriter osw = null;
	        PrintWriter pw = null;
	 
	        try {
	            socket.connect(new InetSocketAddress(InetAddress.getLocalHost(), 6005));
	            System.out.println("[client] connected with server");
	 
	            while (true) {
	 
	                is = socket.getInputStream();
	                isr = new InputStreamReader(is, "UTF-8");
	                br = new BufferedReader(isr);
	 
	                os = socket.getOutputStream();
	                osw = new OutputStreamWriter(os, "UTF-8");
	                pw = new PrintWriter(osw, true);
	 
	                // �д°�
	                System.out.print(">>");
	                String data = sc.nextLine();
	 
	                if ("exit".equals(data))
	                    break;
	 
	                pw.println(data);
	 
	                data = br.readLine();
	                System.out.println("<< " + data);
	 
	            }
	 
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } finally {
	            try {
	                if (socket != null && !socket.isClosed()) {
	                    socket.close();
	                }
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	 
	            sc.close();
	 
	        }
	 
	    }
	 
}
