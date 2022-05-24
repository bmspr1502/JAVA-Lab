class Test{
    public static void main(String[] args) {
        RandomSleep r = new RandomSleep();
        try {
            while(r.isAlive()){
                System.out.println("Main Thread executing.");
                Thread.sleep(1000);
            }
           
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Main Thread interrupted. " + e);
        }

        System.out.println("Main thread is over.");
    }
}

class RandomSleep extends Thread {
    RandomSleep(){
        super("Random Sleep thread extending");
        System.out.println("My thread created " + this);
        start();
    }

    public void run(){
        double n = (Math.random() * 10) + 1;
        try {
            Thread.sleep( (long) (n * 1000));
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Error thread interrupted. + " + e);
        }

        System.out.println("Thread waited " + n + " Seconds");
    }
}
