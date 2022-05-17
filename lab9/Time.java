import java.util.*;

class Test {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        try {

            System.out.println("Enter time(hour,min,sec):");
            int h = sc.nextInt();
            int m = sc.nextInt();
            int s = sc.nextInt();

            if (h >= 24 || h < 0 || m > 59 || m < 0 || s > 59 || s < 0)
                throw new Exception("Invalid Time Input");

            Clock24 t1 = new Clock24(h, m, s);
            t1.Display();
            Clock12 t2 = new Clock12(h, m, s);
            t2.Display();

        } catch (Exception e) {
            System.out.println(e + ":" + e.getMessage());
        } finally {
            sc.close();
        }

    }
}

abstract class Time {
    protected int seconds;
    protected int minutes;
    protected int hour;

    Time() {
    }

    Time(int hour, int minutes, int seconds) {
        this.seconds = seconds;
        this.minutes = minutes;
        this.hour = hour;
    }

    void Display() {
        System.out.println("Hours: " + this.hour + "Minutes: " + this.minutes + "Seconds: " + this.seconds);
    }

    int getHour() {
        return this.hour;
    }

    int getMinutes() {
        return this.minutes;
    }

    int getSeconds() {
        return this.seconds;
    }
}

class Clock24 extends Time {
    Clock24(int hour, int minutes, int seconds) {
        super(hour, minutes, seconds);
    }

    public void Display() {
        System.out.println("24 Hrs Time: " + this.hour + ":" + this.minutes + ":" + this.seconds);
    }

}

class Clock12 extends Time {
    Clock12(int hour, int minutes, int seconds) {
        super(hour, minutes, seconds);
    }

    public String suffix = "AM";

    public void Display() {
        int hr = this.hour;
        if (this.hour > 12) {
            hr = this.hour - 12;
        }
        if (this.hour == 0) {
            hr = 12;
        }

        if (this.hour >= 12) {
            suffix = "PM";
        }
        System.out.println("12 Hrs Time: " + hr + ":" + this.minutes + ":" + this.seconds + "  " + suffix);
    }

}
