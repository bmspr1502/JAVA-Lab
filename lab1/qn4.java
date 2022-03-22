import java.util.*;

class Grade {
	public static void main(String args[]) {
		System.out.println("Enter the marks you got: ");
		Scanner sc = new Scanner(System.in);
		int marks = sc.nextInt();

		System.out.println("Enter the maximum marks possible: ");
		int max = sc.nextInt();
		
		float per = ((float)marks/(float)max)*100;
		
		if(per>90){
			System.out.println("Grade A+");
		}else if(per>80){
			System.out.println("Grade A");
		}else if(per>70){
			System.out.println("Grade B");
		}else if(per>60){
			System.out.println("Grade C");
		}else if(per>50){
			System.out.println("Grade D");
		}else{
			System.out.println("Failed");
		}

	}
}
