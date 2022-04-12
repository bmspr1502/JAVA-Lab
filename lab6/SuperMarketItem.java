import java.util.Arrays;
import java.util.Scanner;

class Driver{
    private SuperMarketItem [] ItemsList = new SuperMarketItem[1];
    public double cost=0;
    public int count = 0;
    public double AddItem(SuperMarketItem item){
        count+=1;
        SuperMarketItem[] temp = ItemsList;
        if(ItemsList.length <= count){
            temp = new SuperMarketItem[ItemsList.length*2];
            for(int i=0; i<ItemsList.length; i++){
                temp[i] = ItemsList[i];
            }
        }
        temp[count-1] = item;
        ItemsList = temp;
        cost+=item.Price;
        return this.cost;
    }

    public void displayAllItems(){
        for(int i=0; i<this.count; i++){
            System.out.println("Item["+i+"] details: ");
            ItemsList[i].ToString();
        }
    }

    public static void main(String[] args) {
        Driver d = new Driver();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter any number to continue, -1 to exit after seeing the list of Items and total cost.\n");
            int ch = sc.nextInt();
            if(ch==-1){
                d.displayAllItems();
                break;
            }
            sc.nextLine();
            System.out.println("Enter description: ");
            String desc = sc.nextLine();
            System.out.println("Enter Stock: ");
            int stock = sc.nextInt();
            System.out.println("Enter Price: ");
            double price = sc.nextDouble();

            System.out.println("Current Cost = "+ d.AddItem(new SuperMarketItem(desc, stock, price)));
            System.out.println("===============================\n");
            
            
        }

        sc.close();
    }
}

class SuperMarketItem {
    private String Description;
    public int Stock;
    public double Price;

    SuperMarketItem(String d, int s, double p){
        Description = d;
        Stock = s;
        Price = p;
    }



    public void ToString(){
        System.out.println("Description of Item: "+ Description + "\nRemaining Stock: "+ Stock + "\nPrice of Item: "+ Price);
        System.out.println("===============================\n");
    }
}
