package my_bank;

import java.util.Random;
import java.util.Scanner;

public class my_atm {
	public static void main(String[] args) {
		String chk_bank = "0.��������\n1.��������\n2.�츮����\n3.������";
		String chk_work = "1.���°���\n2.������ȸ\n3.�ܰ���ȸ\n4.��.���\n5.������";
		
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
					{System.out.println("���α׷� ����"); break;}
				switch (work_num) {
				
					case 1: //���°��� random,�̸�,��й�ȣ �ʿ�
						my_inform[] local_bank = {new Kookmin(), new Shinhan(), new Woori()};
						while (true)
						{
							local_bank[bank_num].account = "" + (random.nextInt(90000) + 10000);
							break;
						}
						System.out.println("������ : ");
						local_bank[bank_num].name = scanner.next();
						while (true)
						{
							System.out.print("�ڵ��� ��ȣ [  '-' ���� ] : ");
							phone = scanner.next();
							local_bank[bank_num].phone = my_inform.check_phone_num(phone, bank_num);
							if (local_bank[bank_num].phone != null)
								break ;
						}
						System.out.println("��й�ȣ : ");
						local_bank[bank_num].password = scanner.next();
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
					case 4: //��.��� �׼�,���¹�ȣ,��й�ȣ
						
				}
			}
		}
		scanner.close();
}
}
