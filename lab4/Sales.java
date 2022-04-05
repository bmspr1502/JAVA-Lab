import java.util.*;
class slipClass{
	public int sno, pno, val;
	slipClass(int s,int p, int v){
		sno = s;
		pno = p;
		val = v;
	}
	
}

class sales{
	public static void main(String args[]){
		int [][] arr = new int [6][5];

		Scanner sc = new Scanner(System.in);
		slipClass [] slip = new slipClass[20];
		System.out.println("Enter slip values(20)");
		for(int i=0;i<20;i++)
		{	
			int p = sc.nextInt();
			int s = sc.nextInt();
			int v = sc.nextInt();

			slip[i] = new slipClass(p,s,v);
		}

		for(int i=0;i<20;i++)
		{
			arr[slip[i].pno-1][slip[i].sno-1] += slip[i].val;
			arr[slip[i].pno-1][4] += slip[i].val;
			arr[5][slip[i].sno-1] += slip[i].val;
		}

		System.out.print("Products and Sales\n");
		for(int i=0;i<5;i++)
		{
			System.out.print("Product NO:" + " "+(i+1)+" : ");
			for(int j=0;j<4;j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
		
	
		System.out.print("Cross Products Totals\n");
		for(int i=0;i<5;i++)
		{
			System.out.println("Product" + " No "+(i+1)+"\tTotal: "+arr[i][4]);
		}


		System.out.print("Cross SalesPersons' Totals\n");
		for(int i=0;i<4;i++)
		{
			System.out.println("Sales Person  "+(i+1)+"\tTotal: "+arr[5][i]);
		}

	}
}
