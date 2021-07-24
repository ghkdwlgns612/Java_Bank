package bank;

import domain.MyInform;
import domain.User;

import java.util.HashMap;
import java.util.Map;

public class WooriInform implements MyInform {

    private static Map<String, User> wooriStore = new HashMap<>();
    private static Map<Integer, User> wooriStoreAcc = new HashMap<>();
    private static Map<Integer, Integer> wooriStoreMon = new HashMap<>();

    @Override
    public User GetUser(int account, String password) {
        User user = wooriStoreAcc.get(account);
        if (wooriStoreMon.get(account) != user.getMoney())
            user.setMoney(wooriStoreMon.get(account));
        if (user.getPassword().equals(password))
            return user;
        else
            return null;
    }

    @Override
    public User GetUser(String name,String password) {
        User user = wooriStore.get(name);
        if (user.getPassword().equals(password))
            return user;
        else
            return null;
    }

    @Override
    public void CreateUser(User user) {
        wooriStore.put(user.getName(),user);
        wooriStoreAcc.put(user.getAccount(),user);
        wooriStoreMon.put(user.getAccount(),0);
        System.out.println("계좌번호는 " + user.getAccount() + "입니다.");
    }

    @Override
    public int PlusMoney(User user,int money) {
        Integer tmp = wooriStoreMon.get(user.getAccount()) + money;
        wooriStoreMon.put(user.getAccount(),tmp);
        return wooriStoreMon.get(user.getAccount());
    }

    @Override
    public int MinusMoney(User user, int money) {
        int tmp = wooriStoreMon.get(user.getAccount()) - money;
        if (tmp < 0)
            System.out.println("잔액이 부족합니다.");
        else
            wooriStoreMon.put(user.getAccount(),tmp);
        return wooriStoreMon.get(user.getAccount());
    }
}
