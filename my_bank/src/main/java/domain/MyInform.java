package domain;

public interface MyInform {
    int MinusMoney(User user,int money);
    int PlusMoney(User user,int money);
    User GetUser(String name,String password);
    User GetUser(int account, String password);
    void CreateUser(User user);
}
