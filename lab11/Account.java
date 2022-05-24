class Driver{
    public static void main(String[] args) {
        System.out.println("Creating 2 accounts.");
        Account a =  new SavingsAccount(1234, "Pranava", 2500);
        Account b = new CheckingsAccount(1345, "Raman", 1345);

        try {
            MyThread t = new MyThread("Savings Account 1st thread", a);
            MyThread u = new MyThread("Savings Account 2nd thread", a);
            MyThread v = new MyThread("Checkings Account thread", b);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class MyThread implements Runnable{
    Thread aThread;
    Account account;

    MyThread(String val, Account account){
        this.account = account;
        aThread = new Thread(this, val);
        aThread.start();
    }

    public void run(){
        double [] values = new double[3];
        for(int i=0; i<3; i++){
            values[i] = Math.random()*1000 + 1;
            if(i%2==0){
                account.deposit(values[i]);
            }else{
                account.withdraw(values[i]);
            }

            System.out.println("Using Thread:" + Thread.currentThread().getName() + "\n" + account.toString());
            System.out.println("======================\n");
        }

    }

}

class CheckingsAccount extends Account{
    CheckingsAccount(int acno, String name, double bal){
        super(acno, name, bal);
    }

    public void deposit(double amt){

        System.out.println(">> Depositing " + amt + " to " + this.accountName + " .");
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println(e);
        }
      
        this.balance += amt;
    }

    public void withdraw(double amt){
        System.out.println("<< Withdrawing " + amt + " from " + this.accountName + " .");
        try {
            Thread.sleep(500);
            if(this.balance-amt <1000){
                System.out.println("XX Withdrawing " + amt + " from " + this.accountName + " unsuccessful as balance will become below 1000 .");
            }else{
            this.balance -= amt;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
      
      
    }
}

class SavingsAccount extends Account{
    private int noOfTransactions;

    SavingsAccount(int acno, String name, double bal){
        super(acno, name, bal);
        this.noOfTransactions = 0;
    }

    public void deposit(double amt){
        synchronized(this){
       
        try {
            System.out.println(">> Depositing " + amt + " to " + this.accountName + " .");
            Thread.sleep(500);
            this.noOfTransactions +=1;
            this.balance += amt;
        } catch (Exception e) {
            System.out.println(e);
        }
        }
       
        
    }

    public void withdraw(double amt){
        synchronized(this){
            try {
            System.out.println("<< Withdrawing " + amt + " from " + this.accountName + " .");

                Thread.sleep(500);
        
            this.noOfTransactions +=1;
            this.balance -= amt;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
  
    }

    public String toString(){
        return "Name : " + this.accountName +"\nAccount No.: " + this.accountNo + "\nBalance = " + this.balance + "\nNo. of Transactions = "+ this.noOfTransactions;
    }
}

abstract class Account {
    protected int accountNo;
    protected String accountName;
    protected double balance;

    Account(){
        accountName = "";
        accountNo = 0;
        balance = 0;
    }
    Account(int acno, String name, double bal){
        this.accountNo = acno;
        this.accountName = name;
        this.balance = bal;
    }

    abstract void deposit(double amt);
    abstract void withdraw(double amt);
    public String toString(){
        return "Name : " + this.accountName +"\nAccount No.: " + this.accountNo + "\nBalance = " + this.balance;
    }
}
