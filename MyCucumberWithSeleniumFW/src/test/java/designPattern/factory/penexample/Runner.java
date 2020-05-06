package designPattern.factory.penexample;

import designPattern.factory.penexample.PenFactory;
import designPattern.factory.penexample.PenManager;

public class Runner 
{
	public static void main(String[] args) {

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
