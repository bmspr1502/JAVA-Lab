import java.util.InputMismatchException;
import java.util.Scanner;

class Driver{
    public static void main(String[] args) {
        System.out.println("=============================================");
        System.out.println("\t\tCIRCLES");
        System.out.println("=============================================");
        Circle a = new Circle();
        Circle b = new Circle();

        Scanner sc = new Scanner(System.in);
        
        try {
            int p,q;
            System.out.println("Enter the x for centre of circle a: ");
            p = sc.nextInt();

            System.out.println("Enter the y for centre of circle a: ");
            q = sc.nextInt(); 

            System.out.println("Enter the radius of circle a: ");
            double radius = sc.nextDouble(); 
            System.out.println("Setting Circle a's points as ("+ p + ","+ q +") radius = " + radius);
            a.Get(p,q,radius);

            a.PrintDetails();
            System.out.println("Checking if point 4,5  is inside circle a:");
            Point check = new Point(4,5);
            System.out.println("Point is contained in circle a: " + a.Contains(check));
        }catch (InputMismatchException e){
            System.out.println(e + ": Point should not contain decimal values" + "\nCircle a doesn't exist");
        } 
        catch (Exception e) {
            System.out.println(e.getMessage() + "\nCircle a doesn't exist");
        }

        try {
            System.out.println("\nSetting Circle b's points as (1.4,2.5) and r = 7");
            a.Get(1.4,2.5,7);
            a.PrintDetails();
            System.out.println("Checking if point 4,5  is inside circle a:");
            Point check = new Point(4,5);
            System.out.println("Point is contained: " + a.Contains(check));
        }catch (InputMismatchException e){
            System.out.println(e + ": Point should not contain decimal values" + "\nCircle a doesn't exist");
        } 
        catch (Exception e) {
            System.out.println(e.getMessage() + "\nCircle a doesn't exist");
        }




        System.out.println("=============================================");
        System.out.println("\t\tRECTANGLES");
        System.out.println("=============================================");

        Rectangle t = new Rectangle();
        Rectangle r = new Rectangle();

        try {
            int p,q;
            System.out.println("Enter the x for topleftcorner of rectangle t: ");
            p = sc.nextInt();

            System.out.println("Enter the y for topleftcorner of rectangle t: ");
            q = sc.nextInt(); 

            System.out.println("Enter the height of rectangle t:");
            double height = sc.nextDouble(); 
            System.out.println("Enter the width of rectangle t:");
            double width = sc.nextDouble(); 
            System.out.println("Setting Rectangle t's top left corner as ("+ p + ","+ q +") height = " + height + " width = " + width);
            t.Get(p,q,height,width);

            t.PrintDetails();

            System.out.println("\nEnter the x for point to check inside rectangle t");
            p = sc.nextInt();

            System.out.println("Enter the y for point to check inside rectangle t: ");
            q = sc.nextInt(); 
            System.out.println("Checking if point "+ p + ", "+ q +" is inside Rectangle t:");
            Point check = new Point(p,q);
            System.out.println("Point is contained inside Rectangle t: " + t.Contains(check));
        }catch (InputMismatchException e){
            System.out.println(e + ": Point should not contain decimal values" + "\nRectangle t doesn't exist");
        } 
        catch (Exception e) {
            System.out.println(e.getMessage() + "\nRectangle t doesn't exist");
        }

        try{
            System.out.println("\nSetting Rectagle r's leftcorner as (1.4,2.5), h = 7, w = 7");
            r.Get(1.4,2.5,7,7);
            r.PrintDetails();
            System.out.println("Checking if point 4,5  is inside Rectagle r:");
            Point check = new Point(4,5);
            System.out.println("Point is contained: " + r.Contains(check));

        }catch (InputMismatchException e){
            System.out.println(e + ": Point should not contain decimal values" + "\nRectangle r doesn't exist");
        } 
        catch (Exception e) {
            System.out.println(e.getMessage() + "\nRectangle r doesn't exist");
        }
    }

}

interface InterfaceRegion{

    boolean Contains(Point a);
    double Area();
    void PrintDetails(); 
}


abstract class Region implements InterfaceRegion{
    private String NameOfTheRegion;

    public String GetRegionName(){
        return this.NameOfTheRegion;
    }

}
class Point{
    private int x;
    private int y;

    Point(){
        x = 0;
        y = 0;
    }

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    Point(double x, double y)throws ArithmeticException{
        throw new ArithmeticException("Point should not contain decimal values");
    }

    public int GetX() {return x;}
    public int GetY() {return y;}


    public double GetDistance(Point z){
        return Math.sqrt(Math.pow((z.GetX() - this.x), 2) + Math.pow((z.GetY() - this.y), 2));
    }
}

class Circle extends Region{
    private Point centre;
    private double radius;


    Circle(){
        centre = new Point();
        radius = 0;
    }

    public void Get(int x, int y, double r){
        centre = new Point(x,y);
        radius = r;
    }

    public void Get(double x, double y, double r){
        centre = new Point(x,y);
        radius = r;
    }

    public double Area(){
        return Math.PI*this.radius*this.radius;
    }

    public boolean Contains(Point x){

        if(centre.GetDistance(x) <= radius){
            return true;
        }

        return false;
    }

    public void PrintDetails(){
        System.out.println("\nCircle's centre = (" + centre.GetX() + "," + centre.GetY() + ")");
        System.out.println("Circle's Radius = " + this.radius);
        System.out.println("Circle's Area = " + this.Area());
    }
}


class Rectangle extends Region{
    private Point topleftcorner;
    private double height;
    private double width;


    Rectangle(){
        topleftcorner = new Point();
        height = 0;
        width = 0;
    }

    public void Get(int x, int y, double h, double w){
        topleftcorner = new Point(x,y);
        height = h;
        width = w;
    }

    public void Get(double x, double y, double h, double w){
        topleftcorner = new Point(x,y);
        height = h;
        width = w;
    }

    public double Area(){
        return this.height * this.width;
    }

    public boolean Contains(Point x){

        if(x.GetX()>=topleftcorner.GetX() && x.GetX() <=(topleftcorner.GetX() + (int) width)
                && x.GetY()<=topleftcorner.GetY() && x.GetY()>=(topleftcorner.GetY() - (int) height)){
                    return true;
        }

        return false;
    }

    public void PrintDetails(){
        System.out.println("\nRectangle's Top Left Corner = (" + topleftcorner.GetX() + "," + topleftcorner.GetY() + ")");
        System.out.println("Rectangle's Height = " + this.height);
        System.out.println("Rectangle's Width = " + this.width);
        System.out.println("Rectangle's Area = " + this.Area());
    }
}