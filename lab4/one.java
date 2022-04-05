import java.util.*;
class Main {
    public static void main(String args[]){
        Area a1 = new Area(2.5f);
        Area a2 = new Area(4.5f, 6.2f);
        Area a3 = new Area(5.5f, true);
        
        System.out.println(a1.get());
        System.out.println(a2.get());
        System.out.println(a3.get());
    }
}

class Area{
    public float val;
    Area(float r){
        this.val = (float) Math.PI * r *r;
    }
    Area(float a, boolean t){
        this.val = new Area(a, a).get();
    }

    Area(float l, float b){
        this.val = l *b;
    }

    public float get(){
        return this.val;
    }
}