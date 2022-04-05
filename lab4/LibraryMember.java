import java.util.*;

class TestLibrary{
    private static HashMap<Integer, LibraryMember> map = new HashMap<Integer, LibraryMember>(100);
    private static Scanner sc = new Scanner(System.in);

    public static void questionTwo(){
        sc.nextLine();
        System.out.print("Enter the name of the borrower : ");
        String name = sc.nextLine();
        System.out.print("Enter membership number: ");
        int mno = sc.nextInt();
        System.out.print("Enter membership fee paid: ");
        int fee = sc.nextInt();

        LibraryMember a = new LibraryMember(name,mno,fee);

        int ch = 0;
        do{
            System.out.println("Enter choice (1-borrow, 2-return, 0-exit): ");
            ch=sc.nextInt();

            if(ch==1){
                int n=0;
                System.out.print("Enter number of books: ");
                n = sc.nextInt();
                a.borrowBooks(n);
            }else if(ch==2){
                int n=0;
                System.out.print("Enter number of books: ");
                n = sc.nextInt();
                a.returnBooks(n);
            }

            a.getDetails();

        }while(ch!=0);
        // sc.close();
    }

    public static void searchDetails(){
        sc.nextLine();
        System.out.print("Enter the number : ");
        int mno = sc.nextInt();
        if(map.containsKey(mno)){
            LibraryMember x = map.get(mno);
            x.getDetails();
        }else{
            System.out.println("No such member number exists..");
        }
    }

    public static void addMember(){
        // Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.print("Enter the name of the borrower : ");
        String name = sc.nextLine();
        System.out.print("Enter membership number: ");
        int mno = sc.nextInt();
        if(map.containsKey(mno)){
            System.out.println("Entered number already exists, start over...");
            // sc.close();
            return;
        }
        System.out.print("Enter membership fee paid: ");
        int fee = sc.nextInt();

        LibraryMember a = new LibraryMember(name,mno,fee);
        map.put(mno, a);
        // sc.close();
    }

    public static void deleteMember(){
        sc.nextLine();
        System.out.print("Enter the number : ");
        int mno = sc.nextInt();

        if(map.containsKey(mno)){
            map.remove(mno);
        }else{
            System.out.println("Entered number doesnot exists, start over...");
        }
    }

    public static void showAllMembers(){
        for(LibraryMember tmp: map.values()){
            System.out.println("Details of " + tmp.getMembershipNo() + ": \n");
            tmp.getDetails();
            System.out.println("");
        }
    }
    public static void questionThree(){
        
        int ch = 0;
        do{

            System.out.println("Enter choice: (1- add member), (2- delete member), (3-search member), (4-show all members), (0-exit): ");
            ch = sc.nextInt();
            if(ch==1){
                addMember();
            }else if(ch==2){
                deleteMember();
            }else if(ch==3){
                searchDetails();
            }else if(ch==4){
                showAllMembers();
            }

            // sc.close();
        } while(ch!=0);
       
    }
    public static void main(String args[]){
        // Scanner sc = new Scanner(System.in);
        int ch = 0;
        do{
            System.out.print("Enter qn number (0 to exit): ");
            ch = sc.nextInt();

            if(ch==1){
                LibraryMember a = new LibraryMember();
                LibraryMember b = new LibraryMember("Pranav", 10, 100);

                System.out.println("Name of member = "+ a.getName() + "\nDetails:  ");
                a.getDetails();
                System.out.println("\nName of member = "+ b.getName() + "\nDetails:");
                b.getDetails();
            }else if(ch==2){
                questionTwo();
            }else if(ch ==3){
                questionThree();
            }
        }while(ch!=0);
  

        sc.close();
    }
}

public class LibraryMember {
    private String name;
    private int membershipNo;
    private double membershipFee;
    private int numberOfBooks;

    public int getMembershipNo(){
        return this.membershipNo;
    }
    LibraryMember(String name, int membershipNo, double membershipFee){
        this.name = name;
        this.membershipFee = membershipFee;
        this.membershipNo = membershipNo;
        numberOfBooks = 0;
    }

    LibraryMember(){
        this.name = "Default";
        this.membershipFee = 0;
        this.membershipNo = (int) Math.random() * 1000000;
        numberOfBooks = 0;
    }

    public void borrowBooks(int n){
        if(n<=5){
        this.numberOfBooks +=n;
        }else{
            System.out.println("Given number of books to borrow exceeds limit");
        }
    }

    public void returnBooks(int n){
        this.numberOfBooks -=n;
    }



    public String getName(){
        return this.name;
    }


    public void getDetails(){
        System.out.println("\nName of the Member = " + this.name);
        System.out.println("Membership Fee paid by "+this.membershipNo + " is = "+this.membershipFee);
        System.out.println("Number of Books Borrowed = "+ this.numberOfBooks);
    }
}

