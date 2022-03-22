import java.util.Arrays;
import java.util.Scanner;

public class SelectElectives {
    static final String [] Electives= {
        "Machine Learning",
        "Java Programming",
        "Image Processing",
        "Soft Computing",
        "Python Programming",
        "Deep Learning"
    };

    public static void print(String arg){
        System.out.print(arg);
    }

    public static void bubbleSort(String Elective[], int Rating[]){
		for(int i=0; i<Rating.length; i++){
			for(int j=0; j<Rating.length-1-i; j++){
				if(Rating[j]<Rating[j+1]){
                    String temp = Elective[j];
                    Elective[j] = Elective[j+1];
                    Elective[j+1] = temp;

					int tmp = Rating[j];
					Rating[j] = Rating[j+1];
					Rating[j+1] = tmp;
				}
			}
		}
	}

    public static String[] electiveSet(String Elective[]){
        Scanner sc = new Scanner(System.in);
        int []ratings =  new int[Elective.length];

        String NewElective[] = Arrays.copyOf(Elective, Elective.length);
        for(int i=0; i<NewElective.length; i++){
            String elec = NewElective[i];

            print("How much would you rate "+ elec+" (1-10) : ");
            ratings[i] = sc.nextInt();
        }

        bubbleSort(NewElective, ratings);

        sc.close();
        return NewElective;
    }

    public static void main(String args[]){
        print("The set of Electives are: "+ Arrays.toString(Electives) + "\n");
        print("\nGive your preferred ratings: \n");
        String NewElectives[] =  electiveSet(Electives);
        print("\nThe set of Electives in the decreasing order of preference are: \n"+ Arrays.toString(NewElectives) + "\n\n");
    }
}
