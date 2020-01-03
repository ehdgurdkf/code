import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EditDistance {
	public static void main(String args[]) throws IOException {	

		Scanner scan = new Scanner(System.in);

		System.out.print("INPUT : ");
		String input = scan.nextLine();

		BufferedReader in = new BufferedReader(new FileReader(new File("file")));
		
		String line = "";
		String[] spliter;
		ArrayList<String> list = new ArrayList<String>();
		
		while ((line = in.readLine()) != null) {
			spliter = line.split(",");
			for(int i = 0; i < spliter.length; i ++){
				list.add(spliter[i]);
			}
		}
		
		int min = 10000;
		int index = 0;
		
		for(int i = 0; i < list.size(); i++) 
		{
			int cnt_ED = 0;
			
			if(list.get(i).length() == input.length())
			{
				String target = list.get(i);
				
				for (int j = 0; j < target.length(); j++)
				{
					if (input.charAt(j) != target.charAt(j))
					{
						cnt_ED++;
					}
				}
				
				if (min > cnt_ED) {
					min = cnt_ED;
					index = i;
				}
			}
		}
		
		ArrayList<String> minList = new ArrayList<String>();
		
		for(int i = 0; i < list.size(); i++) 
		{
			int cnt_ED = 0;
			
			if(list.get(i).length() == input.length())
			{
				String target = list.get(i);
				
				for (int j = 0; j < target.length(); j++)
				{
					if (input.charAt(j) != target.charAt(j))
					{
						cnt_ED++;
					}
				}
				if (min == cnt_ED) {
					minList.add(target);
				}
			}
		}
		
		System.out.print("Recommend Words : ");
		for (String s : minList)
		{
			System.out.print(s + " ");
		}
		System.out.println();
		System.out.println("Edit Distance Value : " + min);
	}
}
