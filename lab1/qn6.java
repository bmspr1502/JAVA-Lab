import java.util.*;

class Reverse {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your number: ");
		int number = sc.nextInt();
		
		System.out.println("Reversing using while");
		int newnum = 0;
		int i = 1;
		while(number>0 ){
			System.out.println("Curr status = " + newnum);
			newnum*=10;
			newnum += number%10;
			i = i*10;
			number /=10;
		}
		System.out.println("New NUM = " + newnum);
		System.out.println("Reversing using do-while");
		number =  newnum;
		newnum = 0;
		i = 1;
		do{
			System.out.println("Curr status = " + newnum);
			newnum*=10;
			newnum += number%10;
			i = i*10;
			number /=10;
		}while(number>0);
		System.out.println("New NUM = " + newnum);
	}
}
