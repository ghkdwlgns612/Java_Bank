package my_bank;

public class Kookmin extends my_inform {
	// ��� �� ������ 100�� �߻�.
	@Override
	int ft_extract(int money,my_inform mine) {
		money += 100;
		return super.ft_extract(money, mine);
	}
}