import java.util.*;

public class Driver {
      public static void main(String[] args) {
            
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter the number of objects to produce : ");
            int n = sc.nextInt();

            Storage st = new Storage();
            Counter c = new Counter(st , n );
            Printer p = new Printer(st , n );
            new Thread(c,"Counter").start();  //start the counter
            new Thread(p,"Printer").start();   //start the printer

            sc.close();
      }
}

class Counter implements  Runnable{       
      Storage st;
      int n ;
      public Counter(Storage store , int n){
            st = store;
            this.n = n ;
      }
      @Override
      public void run() {
            synchronized(st) {
                  for(int i = 0 ; i < n; i++){
                        try {
                              while(!st.isPrinted()) {   
                                    try {
                                          st.wait();
                                    } 
                                    catch(Exception e) {
                                          System.out.println(e);
                                    }
                              }
                              System.out.println(Thread.currentThread().getName() + " Produced " + i);
                              st.setValue(i);
                              st.setPrinted(false);
                              Thread.sleep(1000);
                              st.notify();
                        } catch (Exception e) {
                              System.out.println(e);
                        }

                  }
            }
      }
}
class Printer implements Runnable{
      Storage st;
      int n ;

      public Printer(Storage st , int n){
            this.st = st;
            this.n = n ;
      }
      @Override
      public void run() {
            synchronized(st) {
                  try {
                        for(int i = 0; i < n; i++) {
                              while(st.isPrinted()) {
                                    try {
                                          st.wait();
                                    } 
                                    catch(Exception e) { 
                                          System.out.println(e);
                                    }
                              }
                              System.out.println(Thread.currentThread().getName() + " Consumed " + st.getValue() + "\n");
                              st.setPrinted(true);
                              Thread.sleep(1000);
                              st.notify();
                        }
                        
                  } catch (Exception e) {
                        System.out.println(e);
                  }

            }
      }      
}
class Storage{
      int  i;
      boolean printed = true;
      public void setValue(int i){
            this.i = i;
      }
      public int getValue(){
            return this.i;
      }
      public boolean isPrinted() {
            return printed;
      }
      public void setPrinted(boolean p) {
            printed = p;
      }
}

