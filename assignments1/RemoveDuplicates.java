package week3day2.assignments1;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Input: "PayPal India"
			// Output:PaylIndi

					
					
//					Declare a String as PayPal India

//					Convert it into a character array

//					Declare a Set as charSet for Character

//					Declare a Set as dupCharSet for duplicate Character

//					Iterate character array and add it into charSet

//					if the character is already in the charSet then, add it to the dupCharSet

//					Check the dupCharSet elements and remove those in the charSet

//					Iterate using charSet

//					Check the iterator variable isn't equals to an empty space

//					print each character for charSet


		String input = "PayPal India";
		
//		Convert it into a character array
		
		char [] charArray = input.toCharArray();
		
//		Declare a Set as charSet for Character	
		
		Set<Character> charset =  new LinkedHashSet<Character>();
		
//		Declare a Set as dupCharSet for duplicate Character
		Set<Character> dupcharset =  new LinkedHashSet<Character>();
	
//		Iterate character array and add it into charSet
		for(int e =0; e <= charArray.length -1; e ++)
		{
			
			if(charset.contains(charArray[e]))
			{
//				if the character is already in the charSet then, add it to the dupCharSet
				dupcharset.add(charArray[e]);
			}
			else 
			{
					if (charArray[e]!=' ')
					{
						charset.add(charArray[e]);
					}
			}
			
		}
		
		System.out.println("The Charset" + charset);
		System.out.println("The duplicates" + dupcharset);
		
		
		

	}

}
