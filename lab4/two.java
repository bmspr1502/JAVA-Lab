import java.util.*;

class Test{
    public static void main(String args[]){
        Shape s1 = new Shape();
        Shape s2 = new Shape("Square");
        System.out.println(s1.getType());
        System.out.println(s2.getType());
    }
}

class Shape{
    public String type;
    Shape(String type){
        this.type = type;
    }

    Shape(){
        this.type = "Circle";
    }

    public String getType(){
        return this.type;
    }
}