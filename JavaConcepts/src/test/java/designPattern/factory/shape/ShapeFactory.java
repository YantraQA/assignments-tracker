package designPattern.factory.shape;

import designPattern.factory.shape.Circle;
import designPattern.factory.shape.Rectangle;
import designPattern.factory.shape.Shape;
import designPattern.factory.shape.Triangle;

public class ShapeFactory 
{

	public static Shape getShape(String type) {
		Shape shape=null;
		
		if (type.equalsIgnoreCase("circle")) {
			shape = new Circle();
		}else if (type.equalsIgnoreCase("rectangle")) {
			shape = new Rectangle();
		}else if (type.equalsIgnoreCase("triangle")) {
			shape = new Triangle();
		}
		return shape;
	}
}