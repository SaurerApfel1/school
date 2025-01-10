package Schule.Kapitel._07_OOP.HA_1_ErsteKlassen;

import java.util.ArrayList;

public class User {
    public String name;
    public int money;
    public ArrayList<Account> accounts = new ArrayList<>();

    public User(String name, int money, ArrayList<Account> accounts){
        this.name = name;
        this.money = money;
        this.accounts = accounts;
    }
    public String getName() {return name;}
    public int getMoney() {return money;}
    public ArrayList<Account> getAccountsList() {return accounts;}
    public Account getAccount(int index){return getAccountsList().get(index);}

    public void setName(String name) {this.name = name;}
    public void setMoney(int money) {this.money = money;}
    public void setAccounts(ArrayList<Account> account) {this.accounts = account;}

    public boolean hasAccounts(){
        return !(getAccountsList().isEmpty());
    }

    public void listAccounts(){
        int count = 1;
        for (Account account : accounts){
            System.out.println("->"+count+". "+account.getAccountNumber()+" ("+account.getAccountBalance()+"€)");
            count++;
        }
    }
}
