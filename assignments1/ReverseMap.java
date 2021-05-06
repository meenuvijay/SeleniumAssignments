package week3day2.assignments1;

import java.util.Collections;
import java.util.TreeMap;

public class ReverseMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Insert elements to the TreeMap
		/*
		 * Input: Employee Info:
		 * 
		 * Emp_id|Emp_name 100 Hari 101 Naveen 102 Sam 104 Balaji
		 * 
		 * OutPut: Print Employee info in reverse order based on Emp_d
		 */
		
		// Creating an empty TreeMap
		TreeMap<Integer, String> tree_map_emp
        = new TreeMap<Integer, String>(Collections.reverseOrder());
        
     // Mapping string values to int keys
        tree_map_emp.put(100, "Hari");
        tree_map_emp.put(101, "Naveen");
        tree_map_emp.put(102, "Sam");
        tree_map_emp.put(104, "Balaji");
      
        System.out.println("Employee info in reverse order"  + tree_map_emp );

	}

}
