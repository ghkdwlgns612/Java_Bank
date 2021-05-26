package my_bank;

import java.util.Random;
import java.util.Scanner;

public class my_atm {
	public static void main(String[] args) {
		String chk_bank = "0.��������\n1.��������\n2.�츮����\n3.������";
		String chk_work = "1.���°���\n2.������ȸ\n3.�ܰ���ȸ\n4.�Ա�\n5.���\n6.������";
		
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
				{System.out.println("���α׷� ����"); break;}
			while(true)
			{
				System.out.println(chk_work);
				work_num = scanner.nextInt();
				scanner.nextLine();
				if (work_num == 6)
					break;
				switch (work_num) {
				
					case 1: //���°��� random,�̸�,��й�ȣ �ʿ�
						my_inform[] local_bank = {new Kookmin(), new Shinhan(), new Woori()};
						while (true)
						{
							local_bank[bank_num].account = (random.nextInt(90000) + 100000);// 0 ~ 90000������ ������ �߻���Ű�� + 100000�� ����.
							if (my_inform.check_dup_account(local_bank[bank_num].account,bank_num) == null)
								{System.out.println("�ߺ� ���°� �����մϴ�. �ٽ� �Է����ּ���.");}
							else
								break;
						}
						System.out.println("������ : ");
						local_bank[bank_num].name = scanner.next();
						if (local_bank[bank_num].name.length() > 4 || local_bank[bank_num].name.length() < 2)
							{System.out.println("�̸��� ���Ŀ� ���� �ʽ��ϴ�."); break ;}
						while (true)
						{
							System.out.print("�ڵ��� ��ȣ [  '-' ���� ] : ");
							phone = scanner.next();
							local_bank[bank_num].phone = my_inform.check_phone_num(phone, bank_num);
							if (local_bank[bank_num].phone != null)
								break ;
						}
						while (true)
						{
							System.out.println("��й�ȣ : ");
							local_bank[bank_num].password = scanner.next();
							if (my_inform.chekc_password_format(local_bank[bank_num].password, bank_num) != null)
								break ;
							else
								System.out.println("��й�ȣ�� �ٽ� �Է��ϼ���.");
						}
						local_bank[bank_num].money = 1000;
						my_inform.arrBank[bank_num][my_inform.bank_count[bank_num]] = local_bank[bank_num];
						my_inform.bank_count[bank_num]++;
						break ;
						
					case 2: //������ȸ ���¹�ȣ,��й�ȣ
						my_inform buf;
						System.out.print("���� ������ ����� �ڵ��� ��ȣ : ");
						phone = scanner.next();
						buf = my_inform.check_phone(phone, bank_num);
						if (buf == null)
							System.out.println("�������� �ʴ� �����Դϴ�.");
						else
							System.out.println(buf.account);
						break ;
						
					case 3: //�ܰ���ȸ ���¹�ȣ,��й�ȣ
						int money;
						while (true)
						{
							System.out.println("�̸� : ");
							name = scanner.next();
							System.out.println("��й�ȣ : ");
							password = scanner.next();
							money = my_inform.check_money(name, password, bank_num);
							if (money == -1)
								System.out.println("�ٽ� �� �� �Է����ּ���.");
							else
							{
								System.out.println(money);
								break ;
							}
						}
						break ;
					case 4: //�Ա� �׼�,���¹�ȣ,��й�ȣ
						while(true)
						{
							System.out.println("���¹�ȣ : ");
							account = scanner.nextInt();
							buf = my_inform.check_account(account, bank_num);
							if (buf == null)
								System.out.println("�������� �ʴ� ���¹�ȣ�Դϴ�.");
							else
								break ;
						}
						while (true)
						{
							System.out.println("��й�ȣ : ");
							password = scanner.next();
							buf = my_inform.check_password(password, bank_num);
							if (buf == null)
								System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
							else
							{
								System.out.println("�Աݱݾ� : ");
								money = scanner.nextInt();
								buf.money += money;
								break ;
							}
						}
						break ;
					case 5: //��� ���¹�ȣ.��й�ȣ
						while(true)
						{
							System.out.println("���¹�ȣ : ");
							account = scanner.nextInt();
							buf = my_inform.check_account(account, bank_num);
							if (buf == null)
								System.out.println("�������� �ʴ� ���¹�ȣ�Դϴ�.");
							else
								break ;
						}
						while (true)
						{
							System.out.println("��й�ȣ : ");
							password = scanner.next();
							buf = my_inform.check_password(password, bank_num);
							if (buf == null)
								System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
							else
							{
								while(true)
								{
									System.out.println("��ݱݾ� : ");
									money = scanner.nextInt();
									if (money > buf.money)
										System.out.println("�ܰ� �����մϴ�.");
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
