package practice;

import java.io.*;
import java.net.*;


public class client {

	   public static void main(String[] args) {
	        try {
	            @SuppressWarnings({ "unused", "resource" })
	            Socket sk = new Socket("127.0.0.1", 5050);
	            System.out.println("�� Ŭ���̾�Ʈ, ������ ������ �Ǿ����ϴ�....");
	        } catch (UnknownHostException e) {        
	            e.printStackTrace();
	            System.out.println("���� ����, UnknownHostException");
	        } catch (IOException e) {        
	            e.printStackTrace();
	            System.out.println("���� ����, IOException");
	        }
	    }
}
