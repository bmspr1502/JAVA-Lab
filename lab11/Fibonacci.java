class Driver {
    public static void main(String[] args) {
        Fibonacci a,b,c;

        try {
            System.out.println("Main Thread Executing");
            a = new Fibonacci(5);
            a.aThread.join();
            b = new Fibonacci(6);
            b.aThread.join();
            c = new Fibonacci(7);
            c.aThread.join();
        } catch (Exception e) {
            //TODO: handle exception

            System.out.println("Error thread interrupted. + " + e);
        }
        System.out.println("Main Thread over");
        System.out.println("==========================\n");


    }

}

class Fibonacci implements Runnable{
    Thread aThread;
    private int val;
    Fibonacci(int n){
        this.val = n;
        aThread = new Thread(this, "Fibonacci Runnable Thread " + n);
        System.out.println(aThread);
        aThread.start();
    }

    public void run(){
        try{
            int first = 0;
            int second = 1;
            int third = first+second;

            System.out.println("Fibonacci Series of " + this.val + " values: -");
            if(this.val <=0){
                aThread.interrupt();
            }
            System.out.println(first);

            if(this.val == 1){
                aThread.interrupt();
            }
            
            System.out.println(second);
        
            if(this.val == 2){
                aThread.interrupt();
            }

            for(int i=0; i<this.val - 2; i++){
                third = first+second;
                System.out.println(third);

                first = second;
                second = third;
            }

           
            Thread.sleep(1000);
        }catch(InterruptedException e){
            System.out.println(e);
        }
        System.out.println("==========================\n");
    }
}
