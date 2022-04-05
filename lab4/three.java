import java.util.*;


class Test{
    public static void main(String args[]){
        Coords a = new Coords(1, 2);
        Coords b = new Coords(5, -4, 3);

        System.out.println(a.getDistance(b));

    }
}

class Coords{
    private int x=0,y=0,z=0;

    Coords(int x, int y){
        this.x = x;
        this.y = y;
    }

    Coords(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }


    public float getDistance(Coords C){
        return (float) Math.sqrt(Math.pow((this.x - C.x), 2) + Math.pow((this.y - C.y), 2) + Math.pow((this.z - C.z), 2));
    }
}