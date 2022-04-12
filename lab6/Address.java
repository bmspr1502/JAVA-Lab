class Test{
    public static void main(String[] args) {
        Address ad = new Address("Anna Nagar", "Chennai", 600026);
        Account ac1 = new Account(1923, "Pranav", 432.43, ad);
        Account ac2 = new Account(1243, "Raman", 42341.32, "CEG","Guindy", 600025);

        ad.toDisplay();

        ac1.DisplayAccountDetails();
        ac2.DisplayAccountDetails();
    }
}

class Account{
    private int account_number;
    private String account_name;
    private double balance;
    private Address acc_holder_adr;

    Account(int ac, String name, double bal, Address adr){
        account_number = ac;
        account_name = name;
        balance = bal;
        acc_holder_adr = adr;
    }

    Account(int ac, String name, double bal, String sn, String city, int pin){
        account_number = ac;
        account_name = name;
        balance = bal;
        acc_holder_adr = new Address(sn, city, pin);
    }

    void DisplayAccountDetails(){
        System.out.println("Account Details: \nName: "+account_name + "\nAc no: "+ account_number +"\nBalance: "+balance);
        acc_holder_adr.toDisplay();
    }
}

class Address {
   private String street_name;
   private String city;
   private int pincode;


   Address(String sn, String c, int pin){
       this.street_name = sn;
       this.city = c;
       this.pincode = pin;
   }


   public void toDisplay(){
       System.out.println("Address:\nName: "+this.street_name+"\nCity: "+this.city+"\nPincode: "+this.pincode);
       System.out.println("=================================\n");
   }
}
