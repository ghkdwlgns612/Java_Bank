package my_bank;

import java.util.Random;
import java.util.Scanner;

public class my_atm {
	public static void main(String[] args) {
		String chk_bank = "1.국민은행\n2.신한은행\n3.우리은행\n";
		String chk_work = "1.계좌개설\n2.계좌조회\n3.잔고조회\n4.입.출금\n";
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		my_inform user = new my_inform();
		
		System.out.println(chk_bank);
		int bank_num = scanner.nextInt();
		System.out.println(chk_work);
		int work_num = scanner.nextInt();
		while(true)
		{
			switch (work_num) {
				case 1: //계좌개설
				case 2: //계좌조회
				case 3: //잔고조회
				case 4: //입.출금
			}	
		}
	}
}
