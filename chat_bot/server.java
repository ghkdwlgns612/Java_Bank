package chat_bot;

import java.io.*;
import java.net.*;

public class server {
	
    public static void main(String[] args){
        final int SERVER_PORT = 5000;

        ServerSocket serverSocket = null;
        
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
 
        OutputStream os = null;
        OutputStreamWriter osw = null;
        PrintWriter pw = null;
        
        try{
            serverSocket = new ServerSocket();

            String localHostAddress = InetAddress.getLocalHost().getHostAddress();
            serverSocket.bind(new InetSocketAddress(localHostAddress, SERVER_PORT));
            System.out.println("[server] binding! \naddress:" + localHostAddress + ", port:" + SERVER_PORT);

            Socket socket = serverSocket.accept();
            
            InetSocketAddress remoteSocketAddress =(InetSocketAddress)socket.getRemoteSocketAddress();
            String remoteHostName = remoteSocketAddress.getAddress().getHostAddress();
            System.out.println(remoteHostName);
            int remoteHostPort = remoteSocketAddress.getPort();
            System.out.println("[server] connected! \nconnected socket address:" + remoteHostName
                    + ", port:" + remoteHostPort);
            while (true)
            {
	            is = socket.getInputStream();
	            isr = new InputStreamReader(is, "UTF-8");
	            br = new BufferedReader(isr);
	
	            os = socket.getOutputStream();
	            osw = new OutputStreamWriter(os, "UTF-8");
	            pw = new PrintWriter(osw, true);
	            
	            String buffer = null;
	            buffer = br.readLine();
	            if (buffer == null)
	            	break ;
	            
	            System.out.println("[server] recived : " + buffer);
	            pw.println(buffer);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally{
            try{
                if( serverSocket != null && !serverSocket.isClosed() ){
                    serverSocket.close();
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
