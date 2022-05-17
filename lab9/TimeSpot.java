import java.time.Clock;
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
            System.out.println(e);
        } finally {
            sc.close();
        }

        Clock24 t1 = new Clock24();
        Clock12 t2 = new Clock12();

        System.out.println("\nNow changing the the times using set functions");
        System.out.println("==============================================");

        System.out.println("\nSetting t1 as 18:32:43");
        try {
            t1.setHours(18);
            t1.setMinutes(32);
            t1.setSeconds(43);

            t1.Display();
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("\nSetting t2 as 31:12:43");
        try {
            t2.setHours(31);
            t2.setMinutes(12);
            t2.setSeconds(43);

            t2.Display();
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("\nSetting t2 as 23:59:60");
        try {
            t2.setHours(23);
            t2.setMinutes(59);
            t2.setSeconds(60);

            t2.Display();
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("\nSetting t2 as 23:59:59");
        try {
            t2.setHours(23);
            t2.setMinutes(59);
            t2.setSeconds(59);

            t2.Display();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

abstract class Time {
    protected int seconds;
    protected int minutes;
    protected int hour;

    Time() {
        this.seconds = 0;
        this.minutes = 0;
        this.hour = 0;
    }

    Time(int hour, int minutes, int seconds) {
        this.seconds = seconds;
        this.minutes = minutes;
        this.hour = hour;
    }

    public void Display() {
        System.out.println("Hours: " + this.hour + "Minutes: " + this.minutes + "Seconds: " + this.seconds);
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public int getSeconds() {
        return this.seconds;
    }

    public void setHours(int x) {
        if (x < 0 || x >= 24) {
            throw new IllegalArgumentException("Hours Should be between 0 and 24");
        }
        this.hour = x;
    }

    public void setMinutes(int x) {
        if (x < 0 || x > 59) {
            throw new IllegalArgumentException("Minutes Should be between 0 and 59");
        }
        this.minutes = x;
    }

    public void setSeconds(int x) {
        if (x < 0 || x > 59) {
            throw new IllegalArgumentException("Seconds Should be between 0 and 59");
        }
        this.seconds = x;
    }
}

class Clock24 extends Time {
    Clock24() {
        super();
    }

    Clock24(int hour, int minutes, int seconds) {
        super(hour, minutes, seconds);
    }

    public void Display() {
        System.out.println("24 Hrs Time: " + this.hour + ":" + this.minutes + ":" + this.seconds);
    }

}

class Clock12 extends Time {
    Clock12() {
        super();
    }

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
