package my_bank;

import java.util.Random;
import java.util.Scanner;

public class my_atm {
	public static void main(String[] args) {
		String chk_bank = "1.��������\n2.��������\n3.�츮����\n4.������";
		String chk_work = "1.���°���\n2.������ȸ\n3.�ܰ���ȸ\n4.��.���\n5.������";
		
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
					{System.out.println("���α׷� ����"); break;}
				switch (work_num) {
					case 1: //���°��� random,�̸�,��й�ȣ �ʿ�
						while (true)
						{
							account = "" + (random.nextInt(90000) + 10000);
							System.out.println(account);
							break;
						}
					case 2: //������ȸ ���¹�ȣ,��й�ȣ
					case 3: //�ܰ���ȸ ���¹�ȣ,��й�ȣ
					case 4: //��.��� �׼�,���¹�ȣ,��й�ȣ
				}	
			}
		}
}
}
