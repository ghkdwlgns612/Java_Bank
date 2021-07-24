package domain;

import bank.KookminInform;
import bank.ShinhanInform;
import bank.WooriInform;

import java.lang.reflect.Member;
import java.util.Random;
import java.util.Scanner;

public class MyAtm {
    public static void main(String[] args) {
        String chk_bank = "0.국민은행\n1.신한은행\n2.우리은행\n3.나가기";
        String chk_work = "1.계좌개설\n2.계좌조회\n3.잔고조회\n4.입금\n5.출금\n6.나가기";

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true)
        {
            int bank_index = getBank_index(chk_bank, scanner);
            if (bank_index > 2 || bank_index < 0)
                break ;
            MyInform myInform = MakeBank(bank_index);
            while (true)
            {
                int work_index = getBank_index(chk_work, scanner);
                if (work_index == 6)
                    break ;
                switch (work_index) {
                    case 1 : //계좌 개설. ACCOUNT,NAME,PASSWORD,PHONE필요. MONEY는 초기화 "0"
                        User user = createUser(scanner, random);
                        myInform.CreateUser(user);
                        break ;
                    case 2 : //계좌 조회. NAME, PASSWORD입력 후 ACCOUNT출력. 없으면 "계좌가 존재하지 않습니다."
                        User getUser1 = GetUserByName(scanner, myInform);
                        PrintAccount(getUser1);
                        break ;
                    case 3 : //잔고 조회. ACCOUNT, PASSWORD필요. MONEY 출력.
                        User getUser2 = GetUserByAccount(scanner, myInform);
                        PrintMoney(getUser2);
                        break ;
                    case 4 : //입금. ACCOUNT, PASSWORD필요. MONEY에 더하고 출력.
                        User getUser3 = GetUserByAccount(scanner, myInform);
                        PlusMoney(scanner, myInform, getUser3);
                        break ;
                    case 5 : //출금. ACCOUNT, PASSWORD필요. MONEY에 빼고 남은 돈 출력. 남은 돈 -일 경우 "잔고가 부족합니다."라고하고 다시 더해줌.
                        User getUser4 = GetUserByAccount(scanner, myInform);
                        MinusMoney(scanner, myInform, getUser4);
                        break ;
                }
            }
        }
    }

    private static void PlusMoney(Scanner scanner, MyInform myInform, User getUser3) {
        System.out.print("액수를 입력해주세요(입금) : ");
        int money = scanner.nextInt();
        int fmoney = myInform.PlusMoney(getUser3,money);
        System.out.println("잔액은 " + fmoney + " 입니다.");
    }

    private static void MinusMoney(Scanner scanner, MyInform myInform, User getUser4) {
        System.out.print("액수를 입력해주세요(출금) : ");
        int money = scanner.nextInt();
        int fmoney = myInform.MinusMoney(getUser4,money);
        System.out.println("잔액은 " + fmoney + " 입니다.");
    }

    private static void PrintMoney(User getUser2) {
        if (getUser2 == null)
            System.out.println("존재하지 않은 회원입니다.");
        else
            System.out.println("계좌번호는 " + getUser2.getAccount() + "이고 " + "잔액은 " + getUser2.getMoney() + "입니다.");
    }

    private static void PrintAccount(User getUser) {
        if (getUser == null)
            System.out.println("존재하지 않은 회원입니다.");
        else
            System.out.println("계좌번호는 " + getUser.getAccount() + " 입니다.");
    }

    private static User GetUserByAccount(Scanner scanner, MyInform myInform) {
        System.out.print("계좌번호를 입력하세요 : ");
        int account = scanner.nextInt();
        System.out.print("비밀번호를 입력하세요 : ");
        String password = scanner.next();
        User user = myInform.GetUser(account,password);
        return user;
    }

    private static User GetUserByName(Scanner scanner, MyInform myInform) {
        System.out.print("이름을 입력하세요 : ");
        String name = scanner.next();
        System.out.print("비밀번호를 입력하세요 : ");
        String password = scanner.next();
        User user = myInform.GetUser(name,password);
        return user;
    }

    private static User createUser(Scanner scanner, Random random) {
        System.out.print("이름을 입력하세요 : ");
        String name = scanner.next();
        System.out.print("비밀번호를 입력하세요 : ");
        String password = scanner.next();
        System.out.print("전화번호를 입력하세요(-제외) : ");
        int phone = scanner.nextInt();
        int account = random.nextInt(90000) + 100000;
        int money = 0;
        User user = new User(password,name,money,phone,account);
        return user;
    }

    private static MyInform MakeBank(int bank_index) {
        if (bank_index == 0) {return new KookminInform();}
        else if (bank_index == 1) {return new ShinhanInform();}
        return new WooriInform();
    }

    private static int getBank_index(String chk_bank, Scanner scanner) {
        System.out.println(chk_bank);
        return scanner.nextInt();
    }
}
