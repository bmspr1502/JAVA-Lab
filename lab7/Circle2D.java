package lab7;
class Driver{

    public static void print(String x){
        System.out.print(x);
    }
    public static void main(String[] args) {
        print("Demonstrating functions: \n");
        print("\n1. No arg constructor for circle a (center (0,0), radius 1): ");
        Circle2D a = new Circle2D();

        print("Area of circle = " + a.getArea() + "\nPerimeter = "+ a.getPerimeter());

        print("\n\n2. Initializing circle b with points 4,3 and radius 5: \n");
        Circle2D b = new Circle2D(4, 3, 5);

        print("Area of circle = " + b.getArea() + "\nPerimeter = "+ b.getPerimeter());

        print("\n\n3. Checking if (0,0) is contained in both circles: \n");
        print("For circle a - " + a.contains(0, 0) + "\nFor circle b: " + b.contains(0, 0));

        print("\n\n4. Checking if a contains b or b contains a: \n");
        print("a.contains(b) = " + a.contains(b) + "\nb.contains(a): " + b.contains(a));

        print("\n\n5. Checking if a overlaps b \n");
        print("a.overlaps(b) = " + a.overlaps(b));

        print("\n\nCreating new circle c (centre(-2,4), radius 2) that will not overlap with b : ");
        Circle2D c = new Circle2D(-2, 4, 2);
        print("\n6. Checking if c overlaps b \n");
        print("c.overlaps(b) = " + c.overlaps(b));

        print("\n\nCreating new circle d (centre(3,2), radius 2) that will be contained in b : ");
        Circle2D d = new Circle2D(3, 2, 2);
        print("\n7. Checking if d contains b or b contains d: \n");
        print("d.contains(b) = " + d.contains(b) + "\nb.contains(d): " + b.contains(d));

        print("\n\n8.Finding the circle with maximum area amongst a,b,c,d: ");
        Circle2D[] cirArr = {a,b,c,d};
        for(int i=0; i<cirArr.length; i++){
            print("\nDetails of " + (int)(i+1)+"th circle = ");
            cirArr[i].getDetails();
            print("\nArea = "+cirArr[i].getArea());
        }
        print("\n\n Details of the circle with maximum area = \n");
        Circle2D max = Circle2D.findBiggestCircle(cirArr);
        max.getDetails();
        print("\nArea = "+max.getArea() + "\n\n");



    }
}

class Circle2D{
    private double x;
    private double y;
    private double radius;

    Circle2D(){
        x=0;
        y=0;
        radius=1f;
    }

    Circle2D(double x, double y, double r){
        this.x = x;
        this.y = y;
        this.radius = r;
    }

    public double getArea(){
        return (Math.PI * this.radius * this.radius);
    }

    public double getPerimeter(){
        return (2 * Math.PI * this.radius);
    }


    public boolean contains(double x, double y){
        double dist = Math.sqrt(Math.pow((this.x - x), 2) + Math.pow((this.x - x), 2));
        if(dist <= radius)
            return true;

        return false;
    }
    
    public static Circle2D findBiggestCircle(Circle2D[] circles){
        int maxI = 0;
        double maxArea = circles[0].getArea();

        for(int i=1; i<circles.length; i++){
            if(maxArea < circles[i].getArea()){
                maxI=i;
                maxArea = circles[i].getArea();
            }
        }

        return circles[maxI];
    }

    public boolean overlaps(Circle2D circle){
        double dist = Math.sqrt(Math.pow((this.x - circle.x), 2) + Math.pow((this.x - circle.x), 2)) - circle.radius;

        if(dist <= this.radius){
            return true;
        }

        return false;
    }

    public boolean contains(Circle2D circle){
        double dist = Math.sqrt(Math.pow((this.x - circle.x), 2) + Math.pow((this.x - circle.x), 2)) + circle.radius;

        if(dist <= this.radius){
            return true;
        }

        return false;
    }

    public void getDetails(){
        System.out.print("x = "+this.x+", y = "+this.y + ", radius = "+this.radius);
    }
}