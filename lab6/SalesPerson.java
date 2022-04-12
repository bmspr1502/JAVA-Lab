import java.util.Scanner;

class Test{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name of Sales Person :");
        String name = sc.nextLine();

        System.out.print("Enter age of "+name+" :");
        int age = sc.nextInt();

        System.out.print("Enter salary of "+name+" :");
        double salary = sc.nextDouble();

        SalesPerson x = new SalesPerson(age, name, salary);
        int ch=0;

        do{
            System.out.println("=============================================");
            System.out.print("1. Add New Sales, 2. Add Sales to another month, 3. Get number of sales, 4. Total Sales Amount, 5. Display Full Details");
            System.out.print(", 6. Find Bonus of the salesPerson, 7. Find Total Salary, 8. Change current month, 9, Show monthly sales data.");
            System.out.print("\nEnter your choice (1-9, 0 to exit): ");

            ch = sc.nextInt();

            switch(ch){
                case 1: double sales = sc.nextDouble();
                        x.addSale(sales);
                    break;
                case 2: sales = sc.nextDouble();
                        int month = sc.nextInt();
                        x.addSale(sales, month);
                    break;
                case 3: System.out.println("Total Sales made = "+ x.getSales());
                    break;
                case 4: System.out.println("Total Sales Amount made = "+ x.getTotalSalesAmount());
                    break;
                case 5: x.displayDetails();
                    break;
                case 6: System.out.println("Bonus made = "+ x.findBonus());
                    break;
                case 7: System.out.println("Total Salary = "+ x.findTotalSalary());
                    break;
                case 8: x.changeMonth();
                    break;
                case 9: x.showMonthlySales();
                    break;
                default: break;
            }

        }while(ch!=0);

        sc.close();
    }
}


class SalesPerson {
    private int age;
    private String name;
    private double salary;
    private double salesAmount;
    private int noOfSales;
    public double SalesPerYear[] = new double[12];
    public static String[] months = {
        "January",
        "February",
        "March",
        "April",
        "May",
        "June",
        "July",
        "August",
        "September",
        "October",
        "November",
        "December"
    };

    SalesPerson(int age, String name, double salary){
        this.age=age;
        this.name = name;
        this.salary = salary;
        this.salesAmount=0;
        this.noOfSales=0;
    }

    public void addSale(double amount){
        this.salesAmount+=amount;
        this.SalesPerYear[currMonth]+=amount;
        System.out.println("Sales of Rs."+amount+" added to the month : "+ months[currMonth]);
        this.noOfSales+=1;
    }

    public void addSale(double amount, int month){
        this.SalesPerYear[month]+=amount;
        this.noOfSales+=1;
        System.out.println("Sales of Rs."+amount+" added to the month : "+ months[month]);
        this.salesAmount+=amount;
    }

    public int getSales(){
        return this.noOfSales;
    }

    public double getTotalSalesAmount(){
        return this.salesAmount;
    }

    public void displayDetails(){
        System.out.println("\nName = "+this.name +"\nAge = "+this.age+"\nSalary = "+this.salary + "\nCount of Sales made = "+this.noOfSales + "\nSales Amount = "+this.salesAmount);
        System.out.println("=======================\n");
    }

    public double findBonus(){
        if(this.noOfSales>10 && this.noOfSales<=20){
            return 1000;
        }else if(this.noOfSales>20 && this.noOfSales<=40){
            return 2000;
        }else if(this.noOfSales>40)
            return 5000;

        return 0;
    }

    public double findTotalSalary(){
        return this.salary + this.findBonus();
    }

    private int currMonth = 0;

    public void changeMonth(){
        currMonth+=1;
    }

    public void showMonthlySales(){
        for(int i=0; i<12; i++){
            System.out.println("Sales in "+ months[i]+" month = "+SalesPerYear[i]);
        }
    }

}
