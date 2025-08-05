import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		boolean tag = false;
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0 ; i < str.length() ; i++)
		{
			if(str.charAt(i) == '<')
			{
				tag = true;
				while(!stack.isEmpty())
				{
					System.out.print(stack.pop());	
				}
				System.out.print(str.charAt(i));
			}
			else if(str.charAt(i) == '>')
			{
				tag = false;
				System.out.print(str.charAt(i));
			}
			else if(tag)	
			{
				System.out.print(str.charAt(i));
			}
			else if(!tag)	
			{
				if(str.charAt(i) == ' ')
				{
					while(!stack.isEmpty())
					{
						System.out.print(stack.pop());
					}
					System.out.print(str.charAt(i));
				}
				else
				{
					
					stack.push(str.charAt(i));
				}
			}
			
		}
		while(!stack.isEmpty())
		{
			System.out.print(stack.pop());	
		}
		
	}

}