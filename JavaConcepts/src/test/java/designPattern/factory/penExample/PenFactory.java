package designPattern.factory.penExample;

public class PenFactory 
{
	/*Polymorphism Example
	where do u have implemented oops concept in your project?
	Ans-Infactory design pattern- encapsulation,abstraction, Polymorphism*/
	
	public static PenManager getInstance(String color) 
	{
		PenManager penManager=null;
		if(color.equalsIgnoreCase("pink")) 
			// what ingonore case does=
			//Compares this String to another String, ignoring case considerations.
		{
			//child-Parent relation so polymorphism
			penManager = new PinkPen();
		}else if(color.equalsIgnoreCase("blue")) 
		{
			penManager = new BluePen();
		}else 
		{
			penManager = new RedPen();	
		}
		return penManager;//object
	}
}
