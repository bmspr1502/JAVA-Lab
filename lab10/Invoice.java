import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;


class InvoiceReader{
    public static void main(String[] args) {
        Invoice [] inputArray = null;

        try{
            FileInputStream file = new FileInputStream("invoice.bin");
            ObjectInputStream in = new ObjectInputStream(file);

            inputArray = (Invoice[]) in.readObject();
            in.close();
            file.close();
        }catch(Exception e){
            System.out.println("Error: " + e);
        }

        System.out.println("The File has been read, it contains " + inputArray.length + " invoices. The values are: ");

        for(Invoice val: inputArray){
            System.out.println(val.toString());
            System.out.println("==========================");
        }

    }
}

class Test{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of invoices: ");
        int n = sc.nextInt();
        Invoice [] array = new Invoice[n];


        for(int i=0; i<n; i++){
            System.out.println("Enter the details of the invoice no.:" + (i+1));
            System.out.println("Enter Number: ");
            int num = sc.nextInt();

            sc.nextLine();
            System.out.println("Enter Description: ");
            String desc = sc.nextLine();
            System.out.println("Enter Quantity: ");
            int qty = sc.nextInt();
            System.out.println("Enter Price per item: ");
            double price = sc.nextDouble();


            array[i] = new Invoice(num,desc,qty,price);
        }


        try{
            FileOutputStream file = new FileOutputStream("invoice.bin");
            ObjectOutputStream output = new ObjectOutputStream(file);

            output.writeObject(array);

            output.close();
            file.close();
        }catch(Exception e){
            System.out.println("Error: " + e);
        }

    }
}

class Invoice implements Serializable{
    private int Number;
    private String Description;
    private int Qty;
    private double Price;

    Invoice(){
        Number = 0;
        Description = "";
        Qty = 0;
        Price = 0;
    }

    Invoice(int n, String d, int q, double p){
        this.Description = d;
        this.Number = n;
        this.Qty = q;
        this.Price = p;
    }

    public String toString(){
        return new String("Number = " + this.Number +"\nDescription = "+ this.Description + "\nQuantity = " + this.Qty + "\nPrice = "+this.Price);
    }
}
