package domain;

import javax.sql.DataSource;

public class User {
    private String password;
    private String name;
    private int money;
    private int phone;
    private int account;

    public User(String password, String name, int money, int phone, int account) {
        this.password = password;
        this.name = name;
        this.money = money;
        this.phone = phone;
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }
}
