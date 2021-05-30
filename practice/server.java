package practice;

import java.io.*;
import java.net.*;

public class server {

	   public static void main(String[] args) {
	        int port = 5050;    // 서버 소켓을 생성
	        try {
	            @SuppressWarnings("resource")
	            ServerSocket ssk = new ServerSocket(port);
	            System.out.println("난 서버, 접속 대기중~");            
	            while (true) {
	                Socket scok = ssk.accept();
	                System.out.println("난 서버, 사용자가 접속했습니다.");
	                System.out.println("난 서버, 클라이언트 ip : " +scok.getInetAddress().getHostAddress());
	                scok.close();
	            }
	        } catch (IOException e) {
	            // TODO 자동 생성된 catch 블록
	            e.printStackTrace();
	        }        
	    }
}
