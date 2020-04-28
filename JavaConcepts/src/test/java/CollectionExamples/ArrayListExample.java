package collectionExamples;

import java.util.ArrayList;
import java.util.Iterator;

import javax.jws.soap.SOAPBinding;

import org.junit.Test;

public class ArrayListExample
{
	@Test
	public void tc_01_arrayList_Opertaions()
	{
		//ordered list
		//Declaration and initialisation
		ArrayList<String> list= new ArrayList();
		list.add("Pornima");
		list.add("Neha");
		list.add("Aditi");

		//to print the list
		System.out.println(list.toString());

		//Element added at the bottom
		list.add("rahul");
		System.out.println(list.toString());

		//fetching the element ffrom the list
		System.out.println("2nd element of the list:"+list.get(2));

		//remove thr element
		list.add(1, "pornima1");
		System.out.println(list.toString());

		//merge two lists
		ArrayList<String> list1= new ArrayList();
		list1.add("Pornima");
		list1.add("Neha");
		list1.add("Aditi");

		list.addAll(2, list1);
		System.out.println(list.toString());

		//Iteration-method 1
		for(int i=0; i<list.size();i++)
		{
			System.out.println(list.get(i));
		}

		//Iteration method-2
		Iterator itr=list.iterator();
		while(itr.hasNext())
		{
			System.out.println("looping using Iterator:"+itr.next());
		}

	}

	@Test
	public void tc_02_MultidimentionalarrayList_Opertaions()
	{
		//Data- 1,2,3,4,5

		//two dimentional Array
		/*0,1,2,
		 *3,4,5
		 *6,7,8
		 */

		//Initialisation of  a parent collection
		ArrayList<ArrayList<Integer>> parent=new ArrayList<ArrayList<Integer>>();

		//creating a  1st row
		ArrayList<Integer> colomn_ListRow1=new ArrayList<>();
		colomn_ListRow1.add(0);
		colomn_ListRow1.add(1);
		colomn_ListRow1.add(2);

		//adding a 1st row
		parent.add(colomn_ListRow1);

		//Creating a 2nd row
		ArrayList<Integer> colomn_ListRow2=new ArrayList<>();
		colomn_ListRow2.add(3);
		colomn_ListRow2.add(4);
		colomn_ListRow2.add(5);

		//Adding a second row
		parent.add( colomn_ListRow2);

		System.out.println(parent.toString());

	}
}
//output-
/*Aditi
	Neha
	Aditi
	rahul
	looping using Iterator:Pornima
	looping using Iterator:pornima1
	looping using Iterator:Pornima
	looping using Iterator:Neha
	looping using Iterator:Aditi
	looping using Iterator:Neha
	looping using Iterator:Aditi
	looping using Iterator:rahul
	[[0, 1, 2], [3, 4, 5]]*/


