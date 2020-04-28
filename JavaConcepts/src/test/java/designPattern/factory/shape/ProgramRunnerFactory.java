package designPattern.factory.shape;

import designPattern.factory.shape.Shape;
import designPattern.factory.shape.ShapeFactory;

public class ProgramRunnerFactory 
{
public static void main(String[] args) {
		
		//accessing diff.shapes using Shape and Shape Factory.
		//no need to create a object.in the form of new.
	
		Shape s1 = ShapeFactory.getShape("circle"); 
		s1.draw();
		
		Shape s2 = ShapeFactory.getShape("rectangle");
		s2.draw();
		
		Shape s3 = ShapeFactory.getShape("triangle");
		s3.draw();
	}

}
//output-
/*I will draw a Circle now.
I will draw a Rectangle now.
I will draw a Triangle now.*/
