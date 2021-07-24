package bank;

import domain.MyInform;
import domain.User;

import java.util.HashMap;
import java.util.Map;

public class ShinhanInform implements MyInform {

    private static Map<String, User> shinhanStore = new HashMap<>();
    private static Map<Integer, User> shinhanStoreAcc = new HashMap<>();
    private static Map<Integer, Integer> shinhanStoreMon = new HashMap<>();

    @Override
    public User GetUser(int account, String password) {
        User user = shinhanStoreAcc.get(account);
        if (shinhanStoreMon.get(account) != user.getMoney())
            user.setMoney(shinhanStoreMon.get(account));
        if (user.getPassword().equals(password))
            return user;
        else
            return null;
    }

    @Override
    public User GetUser(String name,String password) {
        User user = shinhanStore.get(name);
        if (user.getPassword().equals(password))
            return user;
        else
            return null;
    }

    @Override
    public void CreateUser(User user) {
        shinhanStore.put(user.getName(),user);
        shinhanStoreAcc.put(user.getAccount(),user);
        shinhanStoreMon.put(user.getAccount(), 0);
        System.out.println("계좌번호는 " + user.getAccount() + "입니다.");
    }
    @Override
    public int PlusMoney(User user, int money) {
        Integer tmp = shinhanStoreMon.get(user.getAccount()) + money;
        shinhanStoreMon.put(user.getAccount(),tmp);
        return shinhanStoreMon.get(user.getAccount());
    }

    @Override
    public int MinusMoney(User user, int money) {
        int tmp = shinhanStoreMon.get(user.getAccount()) - money;
        if (tmp < 0)
            System.out.println("잔액이 부족합니다.");
        else
            shinhanStoreMon.put(user.getAccount(),tmp);
        return shinhanStoreMon.get(user.getAccount());
    }
}
