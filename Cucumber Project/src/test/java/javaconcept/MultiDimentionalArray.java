package javaconcept;

import java.util.ArrayList;

import org.junit.Test;

public class MultiDimentionalArray {

	/*two dimentional aray
	  0 1 2
	  3 4 5 
	  6 7 8
	  */
	@Test
	public void multidiamentional()
	{
		ArrayList<ArrayList<Integer>> Parent_row=new ArrayList<ArrayList<Integer>>();

		//for 1st row
		ArrayList<Integer> arry_row1=new ArrayList<Integer>();
			arry_row1.add(0);
			arry_row1.add(1);
			arry_row1.add(2);
	        Parent_row.add(arry_row1);
            System.out.println(Parent_row.toString());
            
            //for 2nd row
            ArrayList<Integer> arry_row2=new ArrayList<Integer>();
			arry_row2.add(3);
			arry_row2.add(4);
			arry_row2.add(5);
	        Parent_row.add(arry_row2);
            System.out.println(Parent_row.toString());
            
          //for 3nd row
            ArrayList<Integer> arry_row3=new ArrayList<Integer>();
			arry_row3.add(6);
			arry_row3.add(7);
			arry_row3.add(8);
	        Parent_row.add(arry_row3);
            System.out.println(Parent_row.toString());
}
}