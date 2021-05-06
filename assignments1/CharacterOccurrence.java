package week3day2.assignments1;
import java.util.LinkedHashMap;
import java.util.Map;


public class CharacterOccurrence {



			public static void main(String[] args) {
				// TODO Auto-generated method stub
				
			

		         String data = "welcome to Selenium automation";

						char [] input = data.toCharArray();
						
						Map<Character,Integer> mapinput = new LinkedHashMap <Character,Integer>();
						
					
						
						for(int i=0; i<input.length;i++)
						{
							if(mapinput.containsKey(input[i]))
							{
								Integer val = mapinput.get(input[i]);
								int newval = val+1;
								mapinput.put(input[i], newval);
								
							}
							else
							{
								mapinput.put(input[i],1);
							}
						}
						
						System.out.println("The Occurance of Each Character in the given String" + mapinput);
						
						
						
					}

				
			

			

		


	}


