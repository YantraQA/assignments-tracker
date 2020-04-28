package designPattern.factory.penExample;

public class RedPen extends PenManager {

	@Override
	public void drawLine() 
	{
		System.out.println("Draw Red Line");
	}


}
