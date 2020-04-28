package designPattern.factory.shape;

public class Circle extends Shape 
{
	@Override
	protected void draw() 
	{
		System.out.println("I will draw a Circle now.");
	}
}
