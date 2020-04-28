package collectionExamples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class useArrayList 
{
//ArrayList-follows sequence when we add element
// we can heterogenous elementslike 10,"ponu",null
// disimilar elements 
 // also duplicate elements 
	
	@Test
	public void array_list() {
		
		List<String> list = new ArrayList<String>();
		
		list.add("pornima");
		list.add("sparsh");
		list.add("aditi");
		list.add("kajal");
		list.add("neha");
		
		System.out.println(list.toString());
       // System.out.println(list);
		
		//Add one list to another List
		List<String> list1 = new ArrayList<String>();
		list1.add("wow");
		list1.add("Cool");
		list.addAll(2,list1);
		System.out.println(list.toString());
       // System.out.println(list);
		
		//Search for element in List
		System.out.println(list.contains("kajal"));
		System.out.println(list.containsAll(list1));
		
		//How to iterate-Method 1
        // Iterator itr = new Iterator();
        //as we know we cant create the object of Interface so we need to write following using list in collection
		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		//How to iterate-Method 2
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
	}

	@Test
	public void array_list_with_out_generics() {
        //generics like <String> ,<Integer>
		List list = new ArrayList();
		list.add("pornima");
		list.add(1);
		list.add(true);
		
		System.out.println(list.toString());
        //System.out.println(list); this will also works
		
	}
}
//Output-
/*wow
Cool
aditi
kajal
neha
pornima
sparsh
wow
Cool
aditi
kajal
neha
[pornima, 1, true]*/


