package bank;

import domain.MyInform;
import domain.User;

import java.util.HashMap;
import java.util.Map;

public class KookminInform implements MyInform {

    private static Map<String, User> kookminStore = new HashMap<>();
    private static Map<Integer, User> kookminStoreAcc = new HashMap<>();
    private static Map<Integer, Integer> kookminStoreMon = new HashMap<>();

    @Override
    public void CreateUser(User user) {
        kookminStore.put(user.getName(),user);
        kookminStoreAcc.put(user.getAccount(),user);
        kookminStoreMon.put(user.getAccount(),0);
        System.out.println("계좌번호는 " + user.getAccount() + "입니다.");
    }

    @Override
    public User GetUser(int account, String password) {
        User user = kookminStoreAcc.get(account);
        if (kookminStoreMon.get(account) != user.getMoney())
            user.setMoney(kookminStoreMon.get(account));
        if (user.getPassword().equals(password))
            return user;
        else
            return null;
    }

    @Override
    public User GetUser(String name,String password) {
        User user = kookminStore.get(name);
        if (user.getPassword().equals(password))
            return user;
        else
            return null;
    }

    @Override
    public int PlusMoney(User user,int money) {
        int tmp = kookminStoreMon.get(user.getAccount()) + money;
        kookminStoreMon.put(user.getAccount(),tmp);
        return kookminStoreMon.get(user.getAccount());
    }

    @Override
    public int MinusMoney(User user, int money) {
        int tmp = kookminStoreMon.get(user.getAccount()) - money;
        if (tmp < 0)
            System.out.println("잔액이 부족합니다.");
        else
            kookminStoreMon.put(user.getAccount(),tmp);
        return kookminStoreMon.get(user.getAccount());
    }
}
