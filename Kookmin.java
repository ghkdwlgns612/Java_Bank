package my_bank;

public class Kookmin extends my_inform {
	// �Աݽ� ������ 50%
	@Override
	int ft_extract(int money,my_inform mine) {
		money *= 0.5;
		return super.ft_extract(money, mine);
	}
	
}