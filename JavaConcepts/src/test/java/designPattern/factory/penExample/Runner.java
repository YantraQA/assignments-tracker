package designPattern.factory.penExample;

public class Runner
{
	public static void main(String[] args) {

		//accessing diff.pens using PenManager and PenFactory.
		//no need to create a object in the form of new.
			
		PenManager penManager = PenFactory.getInstance("blue");
		penManager.drawLine();
		
		PenManager penManager1 = PenFactory.getInstance("pink");
		penManager1.drawLine();
		
		PenManager penManager2 = PenFactory.getInstance("red");
		penManager2.drawLine();
	}
	// output-
	/*
	Draw Blue Line
	Draw Pink Line
	Draw Red Line*/
}
