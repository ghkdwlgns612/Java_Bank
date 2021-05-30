package practice;

import java.io.*;
import java.net.*;
import java.util.*;

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
        Scanner sc = new Scanner(System.in);

        try{
            // 1. ���� ���� ��ü ����
            serverSocket = new ServerSocket();

            // 2. ������ ȣ��Ʈ�� ��Ʈ�� binding
            String localHostAddress = InetAddress.getLocalHost().getHostAddress();
            serverSocket.bind(new InetSocketAddress(localHostAddress, SERVER_PORT));
            System.out.println("[server] binding! \naddress:" + localHostAddress + ", port:" + SERVER_PORT);

            // 3. Ŭ���̾�Ʈ�κ��� ���� ��û�� �� ������ ���
            // ���� ��û�� ���� ������ ������ block �����̸�,
            // TCP ���� ������ 3-way handshake�� ������ �Ǹ� ����� ���� Socket ��ü�� ��ȯ��
            // TCP ������ java���� ó�����ָ�, �� ���������δ� OS�� ó���Ѵ�.
            Socket socket = serverSocket.accept();

            // 4. ���� ��û�� ���� ������ �Ǿ��ٴ� �޽��� ���
            InetSocketAddress remoteSocketAddress =(InetSocketAddress)socket.getRemoteSocketAddress();
            String remoteHostName = remoteSocketAddress.getAddress().getHostAddress();
            int remoteHostPort = remoteSocketAddress.getPort();
            System.out.println("[server] connected! \nconnected socket address:" + remoteHostName
                    + ", port:" + remoteHostPort);
            while (true)
            {
	            // inputStream �����ͼ� (�� ��Ʈ��) StreamReader�� BufferedReader�� �����ش� (���� ��Ʈ��)
	            is = socket.getInputStream();
	            isr = new InputStreamReader(is, "UTF-8");
	            br = new BufferedReader(isr);
	
	            // outputStream �����ͼ� (�� ��Ʈ��) StreamWriter�� PrintWriter�� �����ش� (���� ��Ʈ��)
	            os = socket.getOutputStream();
	            osw = new OutputStreamWriter(os, "UTF-8");
	            pw = new PrintWriter(osw, true);
	            
	            String buffer = null;
	            buffer = br.readLine(); // Blocking
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
