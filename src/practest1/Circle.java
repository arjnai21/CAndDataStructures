package practest1;

import practest1.IllegalRadiusException;

public class Circle {
	private double r;
	
	public Circle (double r) throws IllegalRadiusException
	{
		if(r<=0) throw new IllegalRadiusException();
		this.r = r;
	}
	
	public double getCircumference ()
	{
		return 2 * Math.PI * r;
	}
}
