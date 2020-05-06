package designPattern.factory.penexample;

public class BluePen extends PenManager
{
	@Override
	public void drawLine() 
	{
		System.out.println("Draw Blue Line");	
	}
}
// output-
	/*Draw Blue Line
	Draw Pink Line
	Draw Red Line*/
