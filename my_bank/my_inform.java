package my_bank;

public class my_inform {
	
	static my_inform[][] arrBank = new my_inform[3][100];
	static int[] bank_count = {0, 0 ,0};

	int money;
	int account;
	String name;
	String phone;
	String password;
	

	static my_inform check_phone(String phone, int bank_num)
	{
		my_inform phone_chk = null;
		
		int i = 0;
			while (i < bank_count[bank_num])
			{
				if (arrBank[bank_num][i].phone.equals(phone)) 
				{
					phone_chk = arrBank[bank_num][i];
					break ;
				}
				i++;
			}
		return (phone_chk);
	}
	
	static my_inform check_account(int account, int bank_num)
	{
		my_inform account_chk = null;
		
		int i = 0;
			while (i < bank_count[bank_num])
			{
				if (arrBank[bank_num][i].account == account) 
				{
					account_chk = arrBank[bank_num][i];
					break ;
				}
				i++;
			}
		return (account_chk);
	}
	
	static my_inform check_password(String password, int bank_num)
	{
		my_inform password_chk = null;
		
		int i = 0;
			while (i < bank_count[bank_num])
			{
				if (arrBank[bank_num][i].password.equals(password)) 
				{
					password_chk = arrBank[bank_num][i];
					break ;
				}
				i++;
			}
		return (password_chk);
	}

	
	static int check_money(String name, String password, int bank_num)
	{
		int i = 0;
			while (i < bank_count[bank_num])
			{
				if (arrBank[bank_num][i].name.equals(name) && arrBank[bank_num][i].password.equals(password)) 
					return (arrBank[bank_num][i].money);
				i++;
			}
		return (-1);
	}
	
	static String check_phone_num(String phone, int bank_num)
	{
		int i = 0;
		while (i < phone.length())
		{
			if (phone.charAt(i) < '0' || phone.charAt(i) > '9')
				{System.out.println("숫자만 입력하세요."); break ;}
			if (phone.length() != 11)
				{System.out.println("휴대폰 번호만 입력하세요. 길이가 다릅니다."); break ;}
			i++;
		}
		if (i == phone.length())
			return phone;
		else
			return null;
	}
	
	static String check_dup_account(int account, int bank_num)
	{
		int i = 0;
		while (i < bank_count[bank_num])
		{
			if (arrBank[bank_num][i].account == account)
				return null;
			else
				i++;
		}
		return ("a");
	}
	
	static String chekc_password_format(String password, int bank_num)
	{
		int i = 0;
		while (true)
		{
			if (password.length() != 4)
				return null;
			if ((password.charAt(i) < '0' || password.charAt(i) > '9') && i < password.length())
				return null;
			i++;
			if (i == password.length())
				break ;
		}
		return (password);
	}
	
	int ft_extract(int money, my_inform mine)
	{
		if (money > mine.money)
			System.out.println("잔고가 부족합니다.");
		else
			mine.money -= money;
		return (mine.money);
	}
	
	int ft_create()
	{
		return (1000);
	}
	
	void ft_print_money(int money)
	{
		System.out.println(money + "원");	
	}
}
