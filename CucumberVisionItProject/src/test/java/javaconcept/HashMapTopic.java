package javaconcept;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
public class HashMapTopic {

	@Test
	public void hash_map()
	{
	/*
	 data :1,2,3,4,5
	 data:a-1;b-2;c-3;d-4; 
	 */	
		HashMap<String,Integer> hash= new HashMap<String,Integer>();
		hash.put("a",1);
		hash.put("b",2);
		hash.put("c",3);
		System.out.println(hash.toString());
		
		if(hash.containsKey("b")) {
		System.out.println("b is found");}
			else {
	    System.out.println("not fount");
	}
		//to iterate hashmap
		
		/*to create dual hashmap
		 Pavan:-> p->35
		          C->35
		          m->35
		 Priti:-> p->80
		          c->90
		          m->80    */
		HashMap<String,Integer> Pavan_Marks=new HashMap<String,Integer>();
		Pavan_Marks.put("p",35 );
		Pavan_Marks.put("c",35);
		Pavan_Marks.put("m",35);
		
		HashMap<String,Integer> Priti_Marks=new HashMap<String,Integer>();
		Pavan_Marks.put("p",80);
		Pavan_Marks.put("c",80);
		Pavan_Marks.put("m",80);
		//parent
		HashMap<String,HashMap<String,Integer>> hashparent=new HashMap<String,HashMap<String,Integer>>();
	     
		hashparent.put("Pavan",Pavan_Marks);
		hashparent.put("Priti",Priti_Marks);
	}
	
}
