package my_bank;

import java.util.Random;
import java.util.Scanner;

public class my_atm {
	public static void main(String[] args) {
		String chk_bank = "0.국민은행\n1.신한은행\n2.우리은행\n3.나가기";
		String chk_work = "1.계좌개설\n2.계좌조회\n3.잔고조회\n4.입.출금\n5.나가기";
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		my_inform user = null;
		
		int bank_num;
		int work_num;
		int index1 = 0;
		int index2 = 0;
		int index3 = 0;
		String account = "", name = "", phone = "", password = "";
		
		while(true)
		{
			System.out.println(chk_bank);
			bank_num = scanner.nextInt();
			scanner.nextLine();
			if (bank_num == 3)
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
						my_inform[] local_bank = {new Kookmin(), new Shinhan(), new Woori()};
						while (true)
						{
							local_bank[bank_num].account = "" + (random.nextInt(90000) + 10000);
							break;
						}
						System.out.println("예금주 : ");
						local_bank[bank_num].name = scanner.next();
						while (true)
						{
							System.out.print("핸드폰 번호 [  '-' 제외 ] : ");
							local_bank[bank_num].phone = scanner.next();
							int i = 0;
							while (i < local_bank[bank_num].phone.length())
							{
								if (local_bank[bank_num].phone.charAt(i) < '0' || local_bank[bank_num].phone.charAt(i) > '9')
									break ;
								i++;
							}
							if (i == local_bank[bank_num].phone.length())
								break ;
						}
						System.out.println("비밀번호 : ");
						local_bank[bank_num].password = scanner.next();
						my_inform.arrBank[bank_num][my_inform.bank_count[bank_num]] = local_bank[bank_num];
						my_inform.bank_count[bank_num]++;
						break ;
						
					case 2: //계좌조회 계좌번호,비밀번호
						System.out.print("계좌 개설시 등록한 핸드폰 번호 : ");
						phone = scanner.next();
						int i = 0;
						int flag = 0;
						int len = phone.length();
						int j = 0;
						while (i < my_inform.bank_count[bank_num])
						{
							while (phone.charAt(j) == my_inform.arrBank[bank_num][i].phone.charAt(j) && j < len)
							{
								j++;
								if (j == len)
									break ;
							}
							if (j == len)
							{
								System.out.println(my_inform.arrBank[bank_num][i].account);
								j = 0;
							}
							else
								j = 0;
							i++;
						}
						break ;
					case 3: //잔고조회 계좌번호,비밀번호
					case 4: //입.출금 액수,계좌번호,비밀번호
						
				}
			}
		}
		scanner.close();
}
}
