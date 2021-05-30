package practice;

import java.io.*;
import java.util.*;
import java.net.*;


public class client {
    // 1. TCP 서버의 IP와 PORT를 상수로 할당
    // 실제로는 서버의 IP보다는 도메인을 작성하는 것이 좋다. 
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
            // 2. 서버와 연결을 위한 소켓을 생성
            socket = new Socket();

            // 3. 생성한 소켓을 서버의 소켓과 연결(connect)
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
                if( socket != null && !socket.isClosed()){
                    socket.close();
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
