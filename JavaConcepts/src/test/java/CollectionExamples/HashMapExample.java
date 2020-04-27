package CollectionExamples;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class HashMapExample 
{
	@Test
	public void tc_01_HashMap_Example()
	{
		//Data 1234 -

		//Data: a-1,b-2,c-3; 

		HashMap <String,Integer> hm = new HashMap <String,Integer>();
		hm.put("a", 1);
		hm.put("b", 2);
		hm.put("c", 3);

		System.out.println(hm.toString());

		if(hm.containsKey("b"))
		{
			System.out.println("Key as b is found");
		}
		else
		{
			System.out.println("Key as b is not found");
		}
		
		//Iterate a HashMap
		//unordered list
		for(Map.Entry<String, Integer>entry:hm.entrySet())
		{
			System.out.println("key is:" +entry.getKey());
			System.out.println("Value is:" +entry.getValue());
			//entry.getKey();
			//entry.getValue();
		}
		
	}
	@Test
	public void t_01_DualHash_Map(){
		
		//Create Dual Hash Map
		/*example
		 * pornima marks- p>30
		 * 				  c>35
		 * 				  M>40
		 * Nita- marks -  p>35
		 * 				  c>33
		 * 				  M>42
		 * */
	
		HashMap<String,Integer> pornima_marks_hm= new HashMap<String,Integer>();
		pornima_marks_hm.put("p", 30);
		pornima_marks_hm.put("c", 35);
		pornima_marks_hm.put("m", 40);
		
		HashMap<String,Integer> nita_marks_hm= new HashMap<String,Integer>();
		nita_marks_hm.put("p", 35);
		nita_marks_hm.put("c", 33);
		nita_marks_hm.put("m", 42);
		
		//parent_hm
		HashMap<String,HashMap<String,Integer>>hm_parent= new HashMap<String,HashMap<String,Integer>>();
		hm_parent.put("Pornima", pornima_marks_hm);
		hm_parent.put("Nita",  nita_marks_hm);
		
		//System.out.println(hm_parent);
		System.out.println(hm_parent.toString()); // both will work
	}
		
	//output-
	/*{a=1, b=2, c=3}
	Key as b is found
	key is:a
	Value is:1
	key is:b
	Value is:2
	key is:c
	Value is:3
	{Pornima={p=30, c=35, m=40}, Nita={p=35, c=33, m=42}}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	

}
