package practice;

import java.io.*;
import java.net.*;

public class server {

	   public static void main(String[] args) {
	        int port = 5050;    // ���� ������ ����
	        try {
	            @SuppressWarnings("resource")
	            ServerSocket ssk = new ServerSocket(port);
	            System.out.println("�� ����, ���� �����~");            
	            while (true) {
	                Socket scok = ssk.accept();
	                System.out.println("�� ����, ����ڰ� �����߽��ϴ�.");
	                System.out.println("�� ����, Ŭ���̾�Ʈ ip : " +scok.getInetAddress().getHostAddress());
	                scok.close();
	            }
	        } catch (IOException e) {
	            // TODO �ڵ� ������ catch ���
	            e.printStackTrace();
	        }        
	    }
}
