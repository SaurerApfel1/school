package Schule.Kapitel._07_OOP.HA_1_ErsteKlassen;


public class Account {
    private int accountBalance;
    private String accountNumber;
    private User accountUser;

    public Account(String accountNumber, int accountBalance, User accountUser){
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountUser = accountUser;
    }

    public String getAccountNumber() {return accountNumber;}
    public int getAccountBalance() {return accountBalance;}
    public User getAccountUser() {return accountUser;}

    public void setAccountNumber(String number) {this.accountNumber = number;}
    public void setAccountBalance(int amount) {this.accountBalance = amount;}
    public void setAccountUser(User user) {this.accountUser = user;}

    public void balance(){
        System.out.println("Kontostand: "+getAccountBalance()+"€");
        System.out.println("Dein Geld: "+getAccountUser().getMoney()+"€");
    }

    public void deposit(int amount){
        if (amount > getAccountUser().getMoney()){
            System.out.println("❌ Geben Sie einen gültigen Betrag ein");
        }
        else {
            setAccountBalance(getAccountBalance()+amount);
            getAccountUser().setMoney(getAccountUser().getMoney()-amount);
            System.out.println("✅ Erfolgreich "+amount+"€ eingezahlt.");balance();
        }
    }
    public void withdraw(int amount){
        if (amount>getAccountBalance()){
            System.out.println("❌ Geben Sie einen gültigen Betrag ein");
        }
        else {
            setAccountBalance(getAccountBalance()-amount);
            getAccountUser().setMoney(getAccountUser().getMoney()+amount);
            System.out.println("✅ Erfolgreich "+amount+"€ ausgezahlt.");balance();
        }
    }

}
