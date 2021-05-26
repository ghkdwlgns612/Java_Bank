package my_bank;

import java.util.Random;
import java.util.Scanner;

public class my_atm {
	public static void main(String[] args) {
		String chk_bank = "0.국민은행\n1.신한은행\n2.우리은행\n3.나가기";
		String chk_work = "1.계좌개설\n2.계좌조회\n3.잔고조회\n4.입금\n5.출금\n6.나가기";
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		
		int bank_num;
		int work_num;
		int account = 0;
		String name = "", phone = "", password = "";
		while(true)
		{
			System.out.println(chk_bank);
			bank_num = scanner.nextInt();
			scanner.nextLine();
			if (bank_num == 3)
				{System.out.println("프로그램 종료"); break;}
			while(true)
			{
				System.out.println(chk_work);
				work_num = scanner.nextInt();
				scanner.nextLine();
				if (work_num == 6)
					break;
				switch (work_num) {
				
					case 1: //계좌개설 random,이름,비밀번호 필요
						my_inform[] local_bank = {new Kookmin(), new Shinhan(), new Woori()};
						while (true)
						{
							local_bank[bank_num].account = (random.nextInt(90000) + 100000);// 0 ~ 90000까지의 난수를 발생시키고 + 100000을 해줌.
							if (my_inform.check_dup_account(local_bank[bank_num].account,bank_num) == null)
								{System.out.println("중복 계좌가 존재합니다. 다시 입력해주세요.");}
							else
								break;
						}
						System.out.println("예금주 : ");
						local_bank[bank_num].name = scanner.next();
						if (local_bank[bank_num].name.length() > 4 || local_bank[bank_num].name.length() < 2)
							{System.out.println("이름이 형식에 맞지 않습니다."); break ;}
						while (true)
						{
							System.out.print("핸드폰 번호 [  '-' 제외 ] : ");
							phone = scanner.next();
							local_bank[bank_num].phone = my_inform.check_phone_num(phone, bank_num);
							if (local_bank[bank_num].phone != null)
								break ;
						}
						while (true)
						{
							System.out.println("비밀번호 : ");
							local_bank[bank_num].password = scanner.next();
							if (my_inform.chekc_password_format(local_bank[bank_num].password, bank_num) != null)
								break ;
							else
								System.out.println("비밀번호를 다시 입력하세요.");
						}
						local_bank[bank_num].money = 1000;
						my_inform.arrBank[bank_num][my_inform.bank_count[bank_num]] = local_bank[bank_num];
						my_inform.bank_count[bank_num]++;
						break ;
						
					case 2: //계좌조회 계좌번호,비밀번호
						my_inform buf;
						System.out.print("계좌 개설시 등록한 핸드폰 번호 : ");
						phone = scanner.next();
						buf = my_inform.check_phone(phone, bank_num);
						if (buf == null)
							System.out.println("존재하지 않는 계좌입니다.");
						else
							System.out.println(buf.account);
						break ;
						
					case 3: //잔고조회 계좌번호,비밀번호
						int money;
						while (true)
						{
							System.out.println("이름 : ");
							name = scanner.next();
							System.out.println("비밀번호 : ");
							password = scanner.next();
							money = my_inform.check_money(name, password, bank_num);
							if (money == -1)
								System.out.println("다시 한 번 입력해주세요.");
							else
							{
								System.out.println(money);
								break ;
							}
						}
						break ;
					case 4: //입금 액수,계좌번호,비밀번호
						while(true)
						{
							System.out.println("계좌번호 : ");
							account = scanner.nextInt();
							buf = my_inform.check_account(account, bank_num);
							if (buf == null)
								System.out.println("존재하지 않는 계좌번호입니다.");
							else
								break ;
						}
						while (true)
						{
							System.out.println("비밀번호 : ");
							password = scanner.next();
							buf = my_inform.check_password(password, bank_num);
							if (buf == null)
								System.out.println("비밀번호가 일치하지 않습니다.");
							else
							{
								System.out.println("입금금액 : ");
								money = scanner.nextInt();
								buf.money += money;
								break ;
							}
						}
						break ;
					case 5: //출금 계좌번호.비밀번호
						while(true)
						{
							System.out.println("계좌번호 : ");
							account = scanner.nextInt();
							buf = my_inform.check_account(account, bank_num);
							if (buf == null)
								System.out.println("존재하지 않는 계좌번호입니다.");
							else
								break ;
						}
						while (true)
						{
							System.out.println("비밀번호 : ");
							password = scanner.next();
							buf = my_inform.check_password(password, bank_num);
							if (buf == null)
								System.out.println("비밀번호가 일치하지 않습니다.");
							else
							{
								while(true)
								{
									System.out.println("출금금액 : ");
									money = scanner.nextInt();
									if (money > buf.money)
										System.out.println("잔고가 부족합니다.");
									else
									{
										buf.money -= money;
										break ;
									}
								}
								break ;
							}
						}
						break ;
				}
			}
		}
		scanner.close();
}
}
