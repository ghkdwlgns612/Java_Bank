package my_bank;

import java.util.Random;
import java.util.Scanner;

public class my_atm {
	public static void main(String[] args) {
		String chk_bank = "1.국민은행\n2.신한은행\n3.우리은행\n4.나가기";
		String chk_work = "1.계좌개설\n2.계좌조회\n3.잔고조회\n4.입.출금\n5.나가기";
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		my_inform user = null;
		
		int bank_num;
		int work_num;
		String account = "";
		while(true)
		{
			System.out.println(chk_bank);
			bank_num = scanner.nextInt();
			scanner.nextLine();
			if (bank_num == 4)
				break;
			while(true)
			{
				System.out.println(chk_work);
				work_num = scanner.nextInt();
				scanner.nextLine();
				if (work_num == 5)
					{System.out.println("프로그램 종료"); break;}
				switch (work_num) {
					case 1: //계좌개설 random,이름,비밀번호 필요
						while (true)
						{
							account = "" + (random.nextInt(90000) + 10000);
							System.out.println(account);
							break;
						}
					case 2: //계좌조회 계좌번호,비밀번호
					case 3: //잔고조회 계좌번호,비밀번호
					case 4: //입.출금 액수,계좌번호,비밀번호
				}	
			}
		}
}
}
