package my_bank;

public class my_inform {
	
	static my_inform[][] arrBank = new my_inform[3][100];
	static int[] bank_count = {0, 0 ,0};

	int money;
	String name;
	String account;
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
	
	static String check_phone_num(String phone, int bank_num)
	{
		int i = 0;
		while (i < phone.length())
		{
			if (phone.charAt(i) < '0' || phone.charAt(i) > '9')
				break ;
			i++;
		}
		if (i == phone.length())
			return phone;
		else
			return null;
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
//	public my_inform() {};
//	
//	static my_inform checkDup(String account)
//	{
//		my_inform a;
//		return a;
//	}
//	
//	static my_inform login(String account, String password)
//	{
//		
//	}
//	void deposit(int money)
//	{
//		
//	}
//	boolean withdraw(int money)
//	{
//		
//	}
//	void chekc_money()
//	{
//		
//	}
//	public static void main(String[] args)
//	{
//		
//	}
}
