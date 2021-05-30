package practice;

import java.io.*;
import java.util.*;
import java.net.*;


public class client {
    private static final String SERVER_IP = "192.168.191.134";
    private static final int SERVER_PORT = 5000;

    public static void main(String[] args) {
        Socket socket  = null;
        Scanner sc = new Scanner(System.in);
        
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
 
        OutputStream os = null;
        OutputStreamWriter osw = null;
        PrintWriter pw = null;
        
        try{
            socket = new Socket();
            socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));

            while (true)
            {
	            is = socket.getInputStream();
	            isr = new InputStreamReader(is, "UTF-8");
	            br = new BufferedReader(isr);
	
	            os = socket.getOutputStream();
	            osw = new OutputStreamWriter(os, "UTF-8");
	            pw = new PrintWriter(osw, true);
	            
	            System.out.print(">>");
	            String data = sc.nextLine();
	            if ("exit".equals(data))
	            {
	            	System.out.print("채팅을 종료합니다.");
	            	break ;
	            }
	            pw.println(data);
	            
	
	            data = br.readLine();
	            System.out.println("<< " + data);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try{
                if(socket != null && !socket.isClosed()){
                    socket.close();
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
