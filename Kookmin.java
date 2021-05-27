package my_bank;

public class Kookmin extends my_inform {
	// 입금시 수수료 50%
	@Override
	int ft_extract(int money,my_inform mine) {
		money *= 0.5;
		return super.ft_extract(money, mine);
	}
	
}