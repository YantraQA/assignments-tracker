package javaconcept;

import java.util.ArrayList;
import java.util.Iterator;
import org.junit.Test;

public class ArrayTopic {
@Test
public void Array_list_topic() {
	ArrayList<String> list=new ArrayList<String>();//string for printing element is in string 
	list.add("pavan");
	list.add("prit");
	list.add("pavanprit");
	System.out.println(list.toString());//tostring is only use for arraylist library
	//to print all list add value
	///adding new element
	list.add("bababa");
	//to add in betwen at posion index 1
	list.add(1,"ram");
	
	System.out.println(list.toString());
	//to get index 2
	System.out.println("2nd element of the list"+list.get(2));
	//to remove
	list.remove(2);
	System.out.println(list.toString());
	
	//to merge
	ArrayList<String> list1=new ArrayList<String>(); 
	list1.add("pavan1");
	list1.add("prit1");
	list1.add("pavanprit1");
     
	list.addAll(2,list1);
	
	System.out.println(list1.toString());
	
	//iteration by for loop
	for(int i=0; i<list.size(); i++) {
		System.out.println(list.get(i));
	}
	Iterator it=list.iterator();
	while(it.hasNext()) {
		System.out.println("itlator looping"+ it.next());
	}
}
}
