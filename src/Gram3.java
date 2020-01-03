import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Gram3 
{
	public static void main(String args[]) {	
		Scanner scan = new Scanner(System.in);
		
		System.out.print("INPUT : ");
		String input = scan.nextLine();
		
		System.out.print("INPUT2 : ");
		String input2 = scan.nextLine();
		
		System.out.print("K Value : ");
		int k = scan.nextInt();
		
		// k에 값에 따라 글자 수를 가진 집합을 생성
		HashSet<String> set_a = new HashSet<String>();
		HashSet<String> set_b = new HashSet<String>();
		
		for (int i = 0; i < input.length()-k+1; i++)
		{
			String temp = input.substring(i, i+k);
			
			set_a.add(temp);
		}
		
		for (int i = 0; i < input2.length()-k+1; i++)
		{
			String temp = input2.substring(i, i+k);
			
			set_b.add(temp);
		}
	
		HashSet<String> set_inter = getSet_Inter(set_a, set_b);
		HashSet<String> set_sum = getSet_Sum(set_a, set_b);	
		
		double result = (double)set_inter.size() / set_sum.size();
		System.out.println(set_inter.size() + " / " + set_sum.size() + " = " + result);
	}
	
	public static HashSet<String> getSet_Inter(HashSet<String> set_a, HashSet<String> set_b)
	{
		HashSet<String> temp_a = (HashSet<String>) set_a.clone();
		HashSet<String> temp_b = (HashSet<String>) set_b.clone();
		temp_a.retainAll(temp_b);
		return temp_a;
	}
	
	public static HashSet<String> getSet_Sum(HashSet<String> set_a, HashSet<String> set_b)
	{
		HashSet<String> temp_a = (HashSet<String>) set_a.clone();
		HashSet<String> temp_b = (HashSet<String>) set_b.clone();
		temp_a.addAll(temp_b);
		return temp_a;
	}
}