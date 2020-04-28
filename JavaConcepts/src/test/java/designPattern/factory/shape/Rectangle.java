package designPattern.factory.shape;

public class Rectangle extends Shape
{	
	@Override
	protected void draw() 
	{
		System.out.println("I will draw a Rectangle now.");
	}
}
