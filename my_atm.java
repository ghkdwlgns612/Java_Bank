package my_bank;

import java.util.Random;
import java.util.Scanner;

public class my_atm {
	public static void main(String[] args) {
		String chk_bank = "1.��������\n2.��������\n3.�츮����\n";
		String chk_work = "1.���°���\n2.������ȸ\n3.�ܰ���ȸ\n4.��.���\n";
		
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
				case 1: //���°���
				case 2: //������ȸ
				case 3: //�ܰ���ȸ
				case 4: //��.���
			}	
		}
	}
}
