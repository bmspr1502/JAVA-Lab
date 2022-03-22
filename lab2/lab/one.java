import java.util.*;

public class one{
	public static void main(String args[]){
		String elem;
		
		System.out.print("Enter string: ");
		
		Scanner sc = new Scanner(System.in);
		
		elem = sc.nextLine();
		int count[] = new int[26];
		
		for(int i=0; i<elem.length(); i++){
			char x = elem.charAt(i);
			if(x>='A' && x<='Z'){
				count[x-'A']++;
			}else if(x>='a' && x<='z')
				count[x-'a']++;
		}
		
		for(int i=0; i<26; i++){
			if(count[i]>0){
				System.out.println("Count["+(char)('a'+i)+"] = " + count[i]);
			}
		}
	}
}
