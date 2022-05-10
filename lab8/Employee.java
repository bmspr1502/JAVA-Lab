import java.util.*;

class Driver{
    public static void main(String[] args) {
        System.out.println("\nInitializing an empty Employee - a");
        Employee a = new Employee();
        a.display();

        System.out.println("\nInitializing an Employee - b ('pranav', 12, 15000)");
        Employee b = new Employee("pranav", 12, 15000);
        b.display();

        System.out.println("\nSetting his salary as 20000");
        b.setSalary(20000);
        b.display();

        System.out.println("\nCreating Permanent employee c");
        Permanent c = new Permanent();
        c.display();

        System.out.println("\nChanging values of c to be equal to b");
        c.setSalary(b.getSalary());
        System.out.println("Salary of c before calculating = " + c.getSalary());
        c.setName(b.getName());
        c.setID(b.getID());
        c.setDOJ(17, 5, 2002);
        c.setDesignation("Manager");
        c.display();


        System.out.println("\nUsing Constructor: ");
        Permanent d = new Permanent("raman", 23, 35000, 28, 4, 2008, "Executive");
        d.display();

        System.out.println("\nCreating a DailyWages employee e");
        DailyWages e = new DailyWages();
        e.display();


        System.out.println("\nUsing Set functions for e");
        e.setName(b.getName());
        e.setID(b.getID());
        e.setWagePerHour(234);
        e.setNoOfHoursWorked(23);
        e.display();
    }
}

class DailyWages extends Employee{
    private double WagePerHour;
    private int NoOfHoursWorked;

    DailyWages(){
        this.WagePerHour = 0;
        this.NoOfHoursWorked = 0;
    }

    DailyWages(String name, int ID, double Salary, double WagePerHour, int NoOfHoursWorked){
        this.setName(name);
        this.setID(ID);
        this.setSalary(Salary);
        this.WagePerHour = WagePerHour;
        this.NoOfHoursWorked = NoOfHoursWorked;
    }

    public void setWagePerHour(double num){
        this.WagePerHour = num;
    }

    public void setNoOfHoursWorked(int num){
        this.NoOfHoursWorked = num;
    }

    public void ComputeSalary(){
        this.setSalary(WagePerHour * NoOfHoursWorked);
    }

    public void display(){
        this.ComputeSalary();
        System.out.println("Name = " + this.getName() + "\n ID = " + this.getID() + "\n Salary = " + this.getSalary());
        System.out.println("WagePerHour = " + this.WagePerHour + "\n NoOfHoursWorked = " + this.NoOfHoursWorked);
    }
}

class Permanent extends Employee {
    private Date DOJ;
    private String Designation;

    Permanent(){
        this.DOJ = new Date();
        this.Designation = "";
    }

    Permanent(String name, int ID, double Salary, int date, int month, int year, String Designation){
        this.setName(name);
        this.setID(ID);
        this.setSalary(Salary);

        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.MONTH, month);
        c1.set(Calendar.DATE, date);
        c1.set(Calendar.YEAR, year);
        this.DOJ = c1.getTime()  ;

        this.Designation = Designation;
    }

    public double ComputeSalary() {

        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.MONTH, 1);
        c1.set(Calendar.DATE, 10);
        c1.set(Calendar.YEAR, 2007);
        Date currDate = c1.getTime()  ;

        Date currtime = new Date();

        System.out.println("Experience  = " + (currtime.getYear() - this.DOJ.getYear()) + " years");
        if (DOJ.before(currDate)) {
            if (Designation.equals("Manager")) {
                setSalary(70000);
                return this.getSalary();
            } else if (Designation.equals("Executive")) {
                setSalary(50000);
                return this.getSalary();
            } else if (Designation.equals("Technician")) {
                setSalary(30000);
                return this.getSalary();
            }
        } else {
            if (Designation.equals("Manager")) {
                setSalary(50000);
                return this.getSalary();
            } else if (Designation.equals("Executive")) {
                setSalary(30000);
                return this.getSalary();
            } else if (Designation.equals("Technician")) {
                setSalary(25000);
                return this.getSalary();
            }
        }

        return 0;
    }

    public void setDOJ(int date, int month, int year){
        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.MONTH, month);
        c1.set(Calendar.DATE, date);
        c1.set(Calendar.YEAR, year);
        this.DOJ = c1.getTime()  ;
    }

    public void setDesignation(String desig){
        this.Designation = desig;
    }

    public void display() {
        this.ComputeSalary();
        System.out.println(" Name = " + this.getName() + "\n ID = " + this.getID() + "\n Salary = " + this.getSalary());
        System.out.println(" Date of joining = " + this.DOJ + "\n Designation = " + this.Designation);
    }
}

class Employee {
    private String name;
    private int ID;
    private double Salary;

    Employee(){
        name="";
        ID=0;
        Salary = 0;
    }
    Employee(String name, int ID, double Salary){
        this.name = name;
        this.ID = ID;
        this.Salary = Salary;
    }
    public void setSalary(double sal) {
        this.Salary = sal;
    }


    public void setName(String name){
        this.name = name;
    }

    public void setID(int ID){
        this.ID = ID;
    }
    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public double getSalary() {
        return Salary;
    }

    public void display() {
        System.out.println(" Name = " + name + "\n ID = " + ID + "\n Salary = " + Salary);
    }
}