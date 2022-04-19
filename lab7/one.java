package lab7;

import java.util.Scanner;

public class one {
    public static void print(String x){
        System.out.print(x);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        print("\nEnter number of values: \n");
        int n = sc.nextInt();

        Item[] items = new Item[n];
        print("Enter values: \n");
        int i=0;
        while(i<n){
            float val = sc.nextFloat();
            if(val==(float)-1f){
                break;
            }

            items[i] = new Item(val);
            i++;
        }

        float sum = 0;

        for(Item it: items){
            if(it==null)
                break;
            sum+=it.value;
        }
        print("Sum of all elements: "+sum +"\n");


        print("\nAvg of all items: "+ Item.avg(items));
        int x = Item.maxInd(items);
        print("\n Maximum index of item = "+ x + ", value = "+items[x].value + "\n\n");

        sc.close();
    }
}

class Item{
    public float value;
    Item(float val){
        this.value = val;
    }
    public static float avg(Item[] items){

        float sum = 0;
        int n = items.length;
        for(Item it: items){
            sum+=it.value;
        }
        return sum/n;
    }

    public static int maxInd(Item[] items){
        int maxI = 0;
        float maxV = items[0].value;

        for(int i=1; i<items.length; i++){
            if(items[i].value>maxV){
                maxI = i;
                maxV = items[i].value;
            }
        }
        return maxI;
    }
}
